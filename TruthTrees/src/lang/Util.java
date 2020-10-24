package lang;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Util {

	public static <I, O> List<O> mapList(Collection<I> elements, Function<I, O> mapper) {
		return elements.stream().map(mapper).collect(Collectors.toList());
	}

	public static <I, O> Set<O> mapSet(Collection<I> elements, Function<I, O> mapper) {
		return elements.stream().map(mapper).collect(Collectors.toSet());
	}

	public static <I, O> List<O> flatMapList(Collection<I> elements, Function<I, Collection<O>> mapper) {
		return elements.stream().map(mapper).flatMap(Collection::stream).collect(Collectors.toList());
	}
}
