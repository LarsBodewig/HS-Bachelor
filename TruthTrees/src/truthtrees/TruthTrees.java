package truthtrees;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import builder.ErrorListener;
import builder.TokenListener;
import builder.Type.DataType;
import cli.Cli;
import cli.Option;
import display.View;
import grammar.logic.LogicLexer;
import grammar.logic.LogicParser;
import grammar.logic.LogicParser.StatementsContext;
import lang.Constants;
import lang.Tree;
import lang.Util;

public class TruthTrees {

	public static void main(String[] args) {
		try {
			Cli cli = new Cli(args);
			Option opt = cli.getOption();
			if (opt == Option.EMPTY) {
				Cli.printHelp(Constants.OUT);
				return;
			}
			String input = cli.getInput();
			cli.debug(Constants.OUT, "Input: " + input);
			Set<Term> statementSet = toStatementSet(input);
			cli.debug(Constants.OUT, "Statements: " + statementSet);
			Branch tree = buildTree(statementSet);
			cli.debug(Constants.OUT, "Tree: " + tree);
			if (opt == Option.SOLUTION) {
				Set<Set<Term>> solutionSet = getSolutionSet(tree);
				cli.printSolutionSet(Constants.OUT, solutionSet);
				return;
			}
			int width = Math.max(0, cli.getWidth());
			View view = new View(tree, width);
			if (opt == Option.DISPLAY) {
				view.display();
				return;
			}
			String path = cli.getOutputPath();
			if (!path.isBlank()) {
				view.saveToFile(path);
				return;
			}
			Cli.printHelp(Constants.OUT);
		} catch (Exception exc) {
			Cli.printHelp(Constants.ERR, exc);
		}
	}

	public static Set<Term> toStatementSet(String input) throws RuntimeException {
		CharStream stream = CharStreams.fromString(input);
		LogicLexer lexer = new LogicLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicParser parser = new LogicParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new ErrorListener(input));
		StatementsContext root = parser.statements();
		TokenListener listener = new TokenListener();
		ParseTreeWalker.DEFAULT.walk(listener, root);
		List<Tree<Object>> statements = listener.getTree().children();
		return Util.mapSet(statements, child -> (Term) child.children().get(0));
	}

	public static Branch buildTree(Set<Term> root) {
		Queue<Term> queue = new LinkedList<>();
		Map<Term, Branch> parents = new HashMap<>();
		Branch tree = new Branch(root);
		{
			Set<Term> statements = tree.value();
			statements.forEach(stmt -> parents.put(stmt, tree));
			queue.addAll(tree.value());
		}
		while (!queue.isEmpty()) {
			Term statement = queue.poll();
			Branch parent = parents.get(statement);
			Set<Set<Term>> branches = statement.transform();
			if (!branches.isEmpty()) {
				Set<Branch> children = Util.mapSet(branches, Branch::new);
				List<Branch> successors = parent.getLeafs();
				for (Branch successor : successors) {
					if (!successor.contradicts()) {
						for (Branch child : children) {
							Branch copy = new Branch(child);
							successor.addChild(copy);
							if (!copy.contradicts()) {
								Set<Term> statements = copy.value();
								statements.forEach(term -> parents.put(term, copy));
								queue.addAll(statements);
							}
						}
					}
				}
			}
		}
		return tree;
	}

	public static Set<Set<Term>> getSolutionSet(Branch tree) {
		Set<Set<Term>> solutionSet = new HashSet<>();
		List<Branch> branches = tree.getLeafs();
		branches.removeIf(Branch::contradicts);
		for (Branch branch : branches) {
			List<Branch> ancestors = branch.getLineage();
			List<Term> terms = Util.flatMapList(ancestors, Branch::value);
			terms.removeIf(term -> term.type != DataType.Variable);
			SortedSet<Term> solution = new TreeSet<>(new Comparator<Term>() {
				@Override
				public int compare(Term o1, Term o2) {
					return o1.value().toString().compareTo(o2.value().toString());
				}
			});
			solution.addAll(terms);
			solutionSet.add(solution);
		}
		return solutionSet;
	}
}
