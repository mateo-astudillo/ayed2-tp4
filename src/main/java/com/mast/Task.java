package com.mast;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Task
 */
public class Task extends Register {
	// @SuppressWarnings("unused")
	private State state; // pendiente - en progreso - finalizada - cancelada
	private final LocalDate createdAt;
	private Optional<LocalDate> finishedAt;

	{
		this.state = State.PENDING;
		this.createdAt = LocalDate.now();
		this.finishedAt = Optional.empty();
	}

	public Task(String name) {
		super(name);
	}

	public Task(String name, String description) {
		super(name, description);
	}

	public void changeState(State newState) {
		if (this.state.equals(newState)) // No es necesario cambiar al mismo estado
			return;

		this.state = switch (this.state) {
			case PENDING -> switch (newState) { // Desde "PENDIENTE" puede ir a
				case IN_PROGRESS -> newState; // "EN PROGRESO"
				case CANCELED -> newState; // "CANCELADA"
				default -> this.state;
			};
			case IN_PROGRESS -> newState; // Desde "PENDIENTE" puede ir a cualquier estado
			case DONE -> switch (newState) { // Desde "FINALIZADA" puede ir a
				case CANCELED -> newState; // "CANCELADA"
				default -> this.state;
			};
			case CANCELED -> switch (newState) { // Desde "CANCELADA" puede ir a
				case PENDING -> newState; // "PENDIENTE"
				default -> this.state;
			};
		};
	}

	public String getState() {
		return switch (this.state) {
			case PENDING -> "pendiente";
			case IN_PROGRESS -> "en progreso";
			case DONE -> "finalizada";
			case CANCELED -> "cancelada";
		};
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public Optional<LocalDate> getFinishedAt() {
		return finishedAt;
	}

	@Override
	public String toString() {
		String finishedAtStr = "";
		String descriptionStr = "";
		if (this.state == State.DONE)
			finishedAtStr = "\nFECHA DE REALIZACIÓN: " + this.finishedAt.toString();
		if (this.description.isPresent())
			descriptionStr = "\nDESCRIPCIÓN: " + this.description.get();
		return "UUID: " + this.id +
				"\nNOMBRE: " + this.name +
				descriptionStr +
				"\nESTADO: " + this.getState() +
				"\nFECHA DE CREACIÓN: " + this.createdAt.toString() +
				finishedAtStr;
	}
}
