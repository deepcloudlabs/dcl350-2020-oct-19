package com.example.hr.core.domain;

// Value Object -> Immutable -> Enum
public enum FiatCurrency {
	TL("\u20BA"), USD("$"), EUR("€");
	private final String symbol;

	private FiatCurrency(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}
	
}
