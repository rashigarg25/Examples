package com.practice.chess;

//FactoryClass
public class EntityFactory {

	public EntityMove getEntityMove(Entity entity) {

		switch (entity) {

		case PAWN:
			return new Pawn();
		default:
			return null;

		}
	}

}
