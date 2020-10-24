package builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;

import builder.Type.BinaryType;
import builder.Type.BoundlessType;
import builder.Type.DataType;
import builder.Type.UnaryType;
import grammar.logic.LogicBaseListener;
import grammar.logic.LogicParser.ConjunctionContext;
import grammar.logic.LogicParser.DisjunctionContext;
import grammar.logic.LogicParser.InhibitionContext;
import grammar.logic.LogicParser.PeirceContext;
import grammar.logic.LogicParser.PrecedenceContext;
import grammar.logic.LogicParser.PrecedenceNegContext;
import grammar.logic.LogicParser.ShefferContext;
import grammar.logic.LogicParser.StatementContext;
import grammar.logic.LogicParser.StatementsContext;
import grammar.logic.LogicParser.SubjunctionContext;
import grammar.logic.LogicParser.VarContext;
import grammar.logic.LogicParser.VarNegContext;
import lang.Util;
import truthtrees.Term;

public class TokenListener extends LogicBaseListener {
	private Map<RuleContext, TermBuilder> map = new HashMap<>();
	private Term root;

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		TermBuilder term = new TermBuilder();
		this.map.put(ctx, term);
	}

	@Override
	public void exitStatements(StatementsContext ctx) {
		TermBuilder term = this.map.get(ctx);
		List<TermBuilder> statements = Util.mapList(ctx.statement(), this.map::get);
		term.setType(BoundlessType.Statements, false, statements);
		this.root = term;
	}

	@Override
	public void exitStatement(StatementContext ctx) {
		TermBuilder term = this.map.get(ctx);
		TermBuilder inner = this.map.get(ctx.term());
		term.setType(UnaryType.Statement, false, inner);
	}

	@Override
	public void exitVar(VarContext ctx) {
		TermBuilder term = this.map.get(ctx);
		String name = ctx.variable().getText();
		term.setType(DataType.Variable, false, name);
	}

	@Override
	public void exitVarNeg(VarNegContext ctx) {
		TermBuilder term = this.map.get(ctx);
		String name = ctx.variable().getText();
		term.setType(DataType.Variable, true, name);
	}

	@Override
	public void exitConjunction(ConjunctionContext ctx) {
		TermBuilder term = this.map.get(ctx);
		TermBuilder left = this.map.get(ctx.term(0));
		TermBuilder right = this.map.get(ctx.term(1));
		term.setType(BinaryType.Conjunction, false, left, right);
	}

	@Override
	public void exitDisjunction(DisjunctionContext ctx) {
		TermBuilder term = this.map.get(ctx);
		TermBuilder left = this.map.get(ctx.term(0));
		TermBuilder right = this.map.get(ctx.term(1));
		term.setType(BinaryType.Disjunction, false, left, right);
	}

	@Override
	public void exitSubjunction(SubjunctionContext ctx) {
		TermBuilder term = this.map.get(ctx);
		TermBuilder left = this.map.get(ctx.term(0));
		TermBuilder right = this.map.get(ctx.term(1));
		term.setType(BinaryType.Subjunction, false, left, right);
	}

	@Override
	public void exitSheffer(ShefferContext ctx) {
		TermBuilder term = this.map.get(ctx);
		TermBuilder left = this.map.get(ctx.term(0));
		TermBuilder right = this.map.get(ctx.term(1));
		term.setType(BinaryType.Conjunction, true, left, right);
	}

	@Override
	public void exitPeirce(PeirceContext ctx) {
		TermBuilder term = this.map.get(ctx);
		TermBuilder left = this.map.get(ctx.term(0));
		TermBuilder right = this.map.get(ctx.term(1));
		term.setType(BinaryType.Disjunction, true, left, right);
	}

	@Override
	public void exitInhibition(InhibitionContext ctx) {
		TermBuilder term = this.map.get(ctx);
		TermBuilder left = this.map.get(ctx.term(0));
		TermBuilder right = this.map.get(ctx.term(1));
		term.setType(BinaryType.Subjunction, true, left, right);
	}

	@Override
	public void exitPrecedence(PrecedenceContext ctx) {
		TermBuilder term = this.map.get(ctx);
		TermBuilder inner = this.map.get(ctx.term());
		term.setType(UnaryType.Precedence, false, inner);
	}

	@Override
	public void exitPrecedenceNeg(PrecedenceNegContext ctx) {
		TermBuilder term = this.map.get(ctx);
		TermBuilder inner = this.map.get(ctx.term());
		term.setType(UnaryType.Precedence, true, inner);
	}

	public Term getTree() {
		return this.root;
	}
}
