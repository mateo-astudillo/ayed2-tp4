package com.mast;

import java.util.Optional;

/**
 * Node
 */
public class Node {
	private final Register register;
	private Optional<Node> next;

	public Node(Register register) {
		this.register = register;
		this.next = Optional.empty();
	}

	public Register getRegister() {
		return register;
	}

	public Optional<Node> getNext() {
		return next;
	}

	public void setNext(Optional<Node> next) {
		this.next = next;
	}
}
