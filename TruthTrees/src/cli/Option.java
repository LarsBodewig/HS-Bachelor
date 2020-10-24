package cli;

public class Option extends org.apache.commons.cli.Option {

	private static final long serialVersionUID = 1L;

	public static final Option VERBOSE = new Option("v", "Output steps to produce tree");
	public static final Option WIDTH = new Option("w", true, "Width of produced tree graphic");
	public static final Option OUTPUT = new Option("o", true, "Output file path");
	public static final Option DISPLAY = new Option("d", "Display graphic in window");
	public static final Option SOLUTION = new Option("s",
			"Print the solution sub set to satisfy the input statements");
	public static final Option EMPTY = null;

	public final String flag;
	
	private Option(String flag, boolean hasArg, String desc) {
		super(flag, hasArg, desc);
		this.flag = flag;
	}

	private Option(String flag, String desc) {
		this(flag, false, desc);
	}
}