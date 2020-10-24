package truthtrees;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

import builder.Type;
import builder.Type.BinaryType;
import builder.Type.BoundlessType;
import builder.Type.DataType;
import builder.Type.UnaryType;
import lang.Constants;
import lang.Tree;
import lang.Util;

public abstract class Term extends Tree<Object> {
	protected Type type;
	protected boolean negated;

	public boolean isNegated() {
		return this.negated;
	}
	
	@Override
	public String toString() {
		List<String> children = Util.mapList(this.children(), child -> child.toString());
		String result = "";
		Function<String, String> negation = term -> negated ? Constants.NOT + " " + term : term;
		Function<String, String> parentheses = term -> Constants.PARENTHESES_OPEN + term + Constants.PARENTHESES_CLOSE;
		Function<String, String> grouping = term -> negated ? parentheses.apply(term) : term;

		if (this.type == UnaryType.Statement) {
			String stmt = children.get(0);
			result = stmt;
		} else if (this.type == UnaryType.Precedence) {
			String inner = children.get(0);
			result = negation.apply(parentheses.apply(inner));
		} else if (this.type == BinaryType.Conjunction) {
			String inner = children.get(0) + " " + Constants.AND + " " + children.get(1);
			result = negation.apply(grouping.apply(inner));
		} else if (this.type == BinaryType.Disjunction) {
			String inner = children.get(0) + " " + Constants.OR + " " + children.get(1);
			result = negation.apply(grouping.apply(inner));
		} else if (this.type == BinaryType.Subjunction) {
			String inner = children.get(0) + " " + Constants.IMPLY + " " + children.get(1);
			result = negation.apply(grouping.apply(inner));
		} else if (this.type == BoundlessType.Statements) {
			String inner = StringUtils.join(children, ", ");
			result = Constants.SET_OPEN + " " + inner + " " + Constants.SET_CLOSE;
		} else if (this.type == DataType.Variable) {
			String variable = this.value.toString();
			result = negation.apply(variable);
		} else {
			result = "ERR";
		}
		return result;
	}

	public Set<Set<Term>> transform() {
		List<Term> children = Util.mapList(this.children, child -> (Term) child);
		Set<Set<Term>> branches = new HashSet<>();
		Set<Term> left = new HashSet<>();
		Set<Term> right = new HashSet<>();
		if (this.type == BinaryType.Conjunction && !this.negated) {
			left.add(children.get(0));
			left.add(children.get(1));
			branches.add(left);
		} else if (this.type == BinaryType.Conjunction && this.negated) {
			left.add(children.get(0).negate());
			right.add(children.get(1).negate());
			branches.add(left);
			branches.add(right);
		} else if (this.type == BinaryType.Disjunction && !this.negated) {
			left.add(children.get(0));
			right.add(children.get(1));
			branches.add(left);
			branches.add(right);
		} else if (this.type == BinaryType.Disjunction && this.negated) {
			left.add(children.get(0).negate());
			left.add(children.get(1).negate());
			branches.add(left);
		} else if (this.type == BinaryType.Subjunction && !this.negated) {
			left.add(children.get(0).negate());
			right.add(children.get(1));
			branches.add(left);
			branches.add(right);
		} else if (this.type == BinaryType.Subjunction && this.negated) {
			left.add(children.get(0));
			left.add(children.get(1).negate());
			branches.add(left);
		} else if (this.type == UnaryType.Precedence) {
			branches = children.get(0).transform();
		} else if (this.type == DataType.Variable) {
			// no transformation
		}
		return branches;
	}
	
	protected abstract Term copy();
	
	private Term negate() {
		Term copy = this.copy();
		copy.negated = !copy.negated;
		return copy;
	}
}
