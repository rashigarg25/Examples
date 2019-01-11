package com.practice.chess;

public class ChessSquare {

	private Color color;
	private Entity entity;

	public ChessSquare(Color color, Entity entity) {
		super();
		this.color = color;
		this.entity = entity;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		return color.getSymbol() + entity.getSymbol();
	}

}
