package cli;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.StringUtils;

import lang.Util;
import truthtrees.Term;

public class Cli {

	private static final String USAGE = "truthtree [options] <STATEMENT> | { <STATEMENT>, <STATEMENT>, ... }";
	private static final String HEADER = "Generates a truth tree for the given statement(s)" + System.lineSeparator()
			+ "Recognized connectives are AND, OR, IMPLY, NOT (case-insensitive)" + System.lineSeparator()
			+ System.lineSeparator();
	private static final String FOOTER = "";
	private static final boolean AUTO_USAGE = false;

	private static final CommandLineParser PARSER = new DefaultParser();
	private static final Options OPTIONS = new Options().addOption(Option.WIDTH).addOption(Option.VERBOSE).addOptionGroup(
			new OptionGroup().addOption(Option.OUTPUT).addOption(Option.DISPLAY).addOption(Option.SOLUTION));
	private static final HelpFormatter FORMATTER = new HelpFormatter();

	private final CommandLine cmd;

	public Cli(String[] args) throws ParseException {
		this.cmd = Cli.PARSER.parse(Cli.OPTIONS, args);
	}
	
	private boolean isVerbose() {
		return this.cmd.hasOption(Option.VERBOSE.flag);
	}

	public Option getOption() {
		if (this.cmd.getArgList().isEmpty()) {
			return Option.EMPTY;
		}
		if (this.cmd.hasOption(Option.SOLUTION.flag)) {
			return Option.SOLUTION;
		}
		if (this.cmd.hasOption(Option.DISPLAY.flag)) {
			return Option.DISPLAY;
		}
		if (this.cmd.hasOption(Option.OUTPUT.flag)) {
			return Option.OUTPUT;
		}
		return Option.EMPTY;
	}

	public String getInput() {
		List<String> arguments = this.cmd.getArgList();
		return StringUtils.join(arguments, ' ');
	}

	public int getWidth() {
		return Integer.valueOf(this.cmd.getOptionValue("w", "800"));
	}

	public String getOutputPath() {
		return this.cmd.getOptionValue(Option.OUTPUT.flag);
	}

	public void printSolutionSet(PrintStream out, Set<Set<Term>> solutionSet) {
		String solution = "{" + StringUtils.join(Util.mapSet(solutionSet,
				element -> "{ " + StringUtils.join(Util.mapSet(element, Term::toString), ", ") + " }"), ";") + "}";
		out.println("L = " + solution);
	}

	public static void printHelp(PrintStream out) {
		Cli.internalPrintHelp(out, Cli.FOOTER);
	}
	
	public void debug(PrintStream out, String message) {
		if (this.isVerbose()) {
			out.println("DEBUG: " + message);
		}
	}

	public static void printHelp(PrintStream err, Exception exception) {
		Cli.internalPrintHelp(err, "Exception occured: ");
		exception.printStackTrace(err);
	}

	private static void internalPrintHelp(PrintStream stream, String footer) {
		PrintWriter writer = new PrintWriter(stream);
		Cli.FORMATTER.printHelp(writer, HelpFormatter.DEFAULT_WIDTH, Cli.USAGE, Cli.HEADER, Cli.OPTIONS,
				HelpFormatter.DEFAULT_LEFT_PAD, HelpFormatter.DEFAULT_DESC_PAD, footer, Cli.AUTO_USAGE);
		writer.flush();
	}
}
