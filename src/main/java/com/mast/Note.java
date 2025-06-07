package com.mast;

/**
 * Note
 */
public class Note extends Register {
	private String color;

	public Note(String name, String color) {
		super(name);
		this.color = color;
	}

	public Note(String name, String color, String description) {
		super(name, description);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		String descriptionStr = "";
		if (this.description.isPresent())
			descriptionStr = "\nDESCRIPCIÓN: " + this.description.get();
		return "UUID: " + this.id +
				"\nNOMBRE: " + this.name +
				descriptionStr +
				"\nCOLOR: " + this.color;
	}
}
