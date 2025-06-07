package com.mast;

import java.util.Optional;
import java.util.UUID;

/**
 * HashTable
 */
@SuppressWarnings("unchecked")
public class HashTable {
	private final double R = 0.618_033_988;
	private final int M = 15;
	private Optional<Node>[] registers;

	public HashTable() {
		this.registers = (Optional<Node>[]) new Optional[this.M];
		for (int i = 0; i < this.M; i++)
			registers[i] = Optional.empty();
	}

	public HashTable(int capacity) throws Exception {
		if (capacity < 1)
			throw new Exception();
		this.registers = (Optional<Node>[]) new Optional[capacity];
		for (Optional<Node> optional : registers) {
			if (optional == null)
				optional = Optional.empty();
		}
	}

	public void insert(UUID key, Register register) {
		int index = hash(key);
		Optional<Node> currentNode = registers[index];

		if (currentNode.isEmpty()) {
			registers[index] = Optional.of(new Node(register));
			return;
		}

		while (currentNode.get().getNext().isPresent())
			currentNode = currentNode.get().getNext();

		currentNode.get().setNext(Optional.of(new Node(register)));
	}

	public Optional<Register> search(UUID key) {
		int index = hash(key);
		Optional<Node> currentNode = registers[index];

		if (currentNode.isEmpty())
			return Optional.empty();

		while (!currentNode.get().getRegister().equalsKey(key)) {
			if (currentNode.get().getNext().isEmpty())
				return Optional.empty();
			currentNode = currentNode.get().getNext();
		}

		return Optional.of(currentNode.get().getRegister());
	}

	private long UUIDtoInt(UUID key) {
		String keyString = key.toString();
		// NOTE Se eliminan los guiones para mejor disperción
		keyString = keyString.replaceAll("-", "");

		long code = 0;
		// NOTE Los UUID siempre tienen más de 10 caracteres
		for (char c : keyString.substring(0, 10).toCharArray())
			code += (int) c;
		return code;
	}

	private int hash(UUID keyUUID) {
		long key = UUIDtoInt(keyUUID);
		double result = (this.R * key) - (Math.floor(this.R * key));
		return (int) (this.M * result);
	}

	public void printAll() {
		for (Optional<Node> optional : registers) {
			optional.ifPresent(node -> {
				printRegister(node.getRegister());
				Optional<Node> currentNode = node.getNext();
				while (currentNode.isPresent()) {
					currentNode.ifPresent(nextNode -> printRegister(nextNode.getRegister()));
					currentNode = currentNode.get().getNext();
				};
			});
		}
	}

	private void printRegister(Register register) {
		System.out.println(register.toString() + "\n");
	}
}
