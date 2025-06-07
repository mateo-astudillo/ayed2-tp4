package com.mast;

import java.util.Optional;
import java.util.UUID;

/**
 * Register
 */
public abstract class Register {
	protected final UUID id;
	protected String name;
	protected Optional<String> description;
	protected boolean isDeleted = false;

	{
		this.id = UUID.randomUUID();
	}

	public Register(String name) {
		this.name = name;
		this.description = Optional.empty();
	}

	public Register(String name, String description) {
		this.name = name;
		this.description = Optional.of(description);
	}

	public boolean equalsKey(UUID key) {
		return this.id.equals(key);
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<String> getDescription() {
		return description;
	}

	public void setDescription(Optional<String> description) {
		this.description = description;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
