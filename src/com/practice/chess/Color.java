package com.practice.chess;

public enum Color {

	BLACK("B"), WHITE("W");

	private String symbol;

	private Color(String symbol) {
		this.symbol = symbol;
	}

	String getSymbol() {
		return this.symbol;
	}

}
