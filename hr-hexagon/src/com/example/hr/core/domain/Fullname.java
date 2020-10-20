package com.example.hr.core.domain;

// Value Object -> Immutable Class -> record (since Java 14)
public final class Fullname {
	private final String first;
	private final String last;

	public Fullname(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	@Override
	public String toString() {
		return first + " " + last;
	}

}
