package builder;

import java.util.Arrays;

import builder.Type.BinaryType;
import builder.Type.BoundlessType;
import builder.Type.DataType;
import builder.Type.UnaryType;
import builder.Type.VoidType;
import truthtrees.Term;

public class TermBuilder extends Term {
	public TermBuilder() {
		this.type = VoidType.Initial;
	}
	
	@Override
	protected Term copy() {
		TermBuilder builder = new TermBuilder();
		builder.setType(this.type, this.negated);
		builder.value = this.value;
		builder.children = this.children;
		return builder;
	}

	protected void setType(Type type, boolean negated) {
		this.type = type;
		this.negated = negated;
	}

	public void setType(DataType type, boolean negated, Object data) {
		this.setType(type, negated);
		this.value = data;
	}

	public void setType(UnaryType type, boolean negated, Term inner) {
		this.setType(type, negated);
		this.addChild(inner);
	}

	public void setType(BinaryType type, boolean negated, Term left, Term right) {
		this.setType(type, negated);
		this.addChildren(Arrays.asList(left, right));
	}

	public void setType(BoundlessType type, boolean negated, Iterable<? extends Term> terms) {
		this.setType(type, negated);
		this.addChildren(terms);
	}
}
