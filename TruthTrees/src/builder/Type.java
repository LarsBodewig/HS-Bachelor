package builder;

import lang.Enum;

public abstract class Type extends Enum {
	protected Type(String name) {
		super(name);
	}

	public static class VoidType extends Type {
		public static final VoidType Initial = new VoidType("Initial");

		protected VoidType(String name) {
			super(name);
		}
	}

	public static class UnaryType extends Type {
		public static final UnaryType Statement = new UnaryType("Statement");
		public static final UnaryType Precedence = new UnaryType("Precedence");

		protected UnaryType(String name) {
			super(name);
		}
	}

	public static class BinaryType extends Type {
		public static final BinaryType Conjunction = new BinaryType("Conjunction");
		public static final BinaryType Disjunction = new BinaryType("Disjunction");
		public static final BinaryType Subjunction = new BinaryType("Subjunction");

		protected BinaryType(String name) {
			super(name);
		}
	}
	
	public static class BoundlessType extends Type {
		public static final BoundlessType Statements = new BoundlessType("Statements");

		protected BoundlessType(String name) {
			super(name);
		}
	}

	public static class DataType extends Type {
		public static final DataType Variable = new DataType("Variable");

		protected DataType(String name) {
			super(name);
		}
	}
}
