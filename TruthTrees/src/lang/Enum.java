package lang;

public abstract class Enum {

	private static int ordinalCounter = 0;

	protected final String name;
	protected final int ordinal;

	private static int assignOrdinal() {
		int value = Enum.ordinalCounter;
		Enum.ordinalCounter++;
		return value;
	}

	protected Enum(String name) {
		this.name = name;
		this.ordinal = Enum.assignOrdinal();
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Enum) {
			Enum otherEnum = Enum.class.cast(other);
			return this.ordinal == otherEnum.ordinal;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.ordinal;
	}
}
