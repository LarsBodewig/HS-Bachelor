// Generated from Logic.g4 by ANTLR 4.8

package grammar.logic;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LogicParser}.
 */
public interface LogicListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LogicParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(LogicParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(LogicParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conjunction}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(LogicParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conjunction}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(LogicParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code disjunction}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(LogicParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code disjunction}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(LogicParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void enterVar(LogicParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void exitVar(LogicParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code precedenceNeg}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void enterPrecedenceNeg(LogicParser.PrecedenceNegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code precedenceNeg}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void exitPrecedenceNeg(LogicParser.PrecedenceNegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subjunction}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void enterSubjunction(LogicParser.SubjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subjunction}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void exitSubjunction(LogicParser.SubjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inhibition}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void enterInhibition(LogicParser.InhibitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inhibition}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void exitInhibition(LogicParser.InhibitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varNeg}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void enterVarNeg(LogicParser.VarNegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varNeg}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void exitVarNeg(LogicParser.VarNegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sheffer}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void enterSheffer(LogicParser.ShefferContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sheffer}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void exitSheffer(LogicParser.ShefferContext ctx);
	/**
	 * Enter a parse tree produced by the {@code precedence}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void enterPrecedence(LogicParser.PrecedenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code precedence}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void exitPrecedence(LogicParser.PrecedenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code peirce}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void enterPeirce(LogicParser.PeirceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code peirce}
	 * labeled alternative in {@link LogicParser#term}.
	 * @param ctx the parse tree
	 */
	void exitPeirce(LogicParser.PeirceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LogicParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LogicParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogicParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(LogicParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(LogicParser.StatementsContext ctx);
}