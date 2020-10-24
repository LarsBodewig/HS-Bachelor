package lang;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Tree<T> {
	protected T value;
	protected Tree<T> parent;
	protected List<Tree<T>> children;

	public Tree() {
		this.children = new LinkedList<>();
	}

	public Tree(T value) {
		this();
		this.value = value;
	}

	public void addChild(Tree<T> child) {
		child.parent = this;
		this.children.add(child);
	}

	public void addChildren(Iterable<? extends Tree<T>> children) {
		children.forEach(this::addChild);
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T value() {
		return this.value;
	}

	public Tree<T> getParent() {
		return this.parent;
	}

	public List<Tree<T>> children() {
		return Collections.unmodifiableList(this.children);
	}
}