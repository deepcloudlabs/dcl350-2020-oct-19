package com.example.hr.core.domain;

import java.util.Objects;

// Value Object
public class Photo {
	private final byte[] values;

	private Photo(byte[] values) {
		this.values = values;
	}

	public byte[] getValues() {
		return values;
	}

	public static Photo valueOf(byte[] values) {
		Objects.requireNonNull(values);
		return new Photo(values);
	}
}
