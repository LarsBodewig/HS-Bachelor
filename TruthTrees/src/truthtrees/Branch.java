package truthtrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import builder.Type.DataType;
import lang.Constants;
import lang.Tree;
import lang.Util;

public class Branch extends Tree<Set<Term>> {
	private boolean contradicts;

	public Branch(Set<Term> statements) {
		super(statements);
		this.contradicts = false;
	}

	public Branch(Branch copy) {
		super(copy.value);
		this.contradicts = copy.contradicts;
	}
	
	private void findContradiction() {
		List<Branch> ancestors = this.getLineage();
		List<Term> statements = Util.flatMapList(ancestors, Branch::value);
		statements.removeIf(term -> term.type != DataType.Variable);
		Map<String, Boolean> variables = new HashMap<>();
		for (Term statement : statements) {
			String variable = statement.value().toString();
			Boolean negated = Boolean.valueOf(statement.isNegated());
			Boolean previous = variables.put(variable, negated);
			if (previous != null && !previous.equals(negated)) {
				this.contradicts = true;
				return;
			}
		}
		this.contradicts = false;
	}

	public boolean contradicts() {
		return this.contradicts;
	}

	@Override
	public void addChild(Tree<Set<Term>> child) {
		super.addChild(child);
		((Branch) child).findContradiction();
	}

	public List<Branch> getLeafs() {
		if (this.children.isEmpty()) {
			return List.of(this);
		} else {
			return Util.flatMapList(this.children, child -> Branch.class.cast(child).getLeafs());
		}
	}

	public List<Branch> getLineage() {
		Branch parent = (Branch) this.parent;
		List<Branch> ancestors = (parent == null) ? new LinkedList<>() : parent.getLineage();
		ancestors.add(this);
		return ancestors;
	}

	public String print() {
		String self = this.toString();
		String children = StringUtils.join(Util.mapList(this.children, branch -> ((Branch) branch).print()), ", ");
		return self + " [ " + children + " ]" + (this.contradicts ? " X" : "");
	}
	
	@Override
	public String toString() {
		String inner = StringUtils.join(Util.mapSet(this.value, Term::toString), ", ");
		String self = Constants.SET_OPEN + " " + inner + " " + Constants.SET_CLOSE;
		return self;
	}
}
