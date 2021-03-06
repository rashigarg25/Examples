package com.practice.chess;

import java.util.ArrayList;
import java.util.List;

public class Horse implements EntityMove {

	@Override
	public boolean isValidMove(ChessSquare[][] chessBoard, Position initialPosition, Position finalPosition) {
		boolean valid = false;
		int initalX = initialPosition.getX();
		int initalY = initialPosition.getY();
		int finalX = finalPosition.getX();
		int finalY = finalPosition.getY();

		ChessSquare initialSquare = chessBoard[initalX][initalY];
		ChessSquare finalSquare = chessBoard[finalX][finalY];

		List<Position> validPositions = getValidPositions(initalX, initalY);

		for (Position pos : validPositions) {

			if (pos.equals(finalPosition)
					&& (finalSquare == null || finalSquare.getColor() != initialSquare.getColor())) {
				valid = true;
			}

		}

		return valid;

	}

	private List<Position> getValidPositions(int x, int y) {

		List<Position> positions = new ArrayList<>();
		if (x - 2 >= 0) {
			if (y - 1 >= 0) {
				positions.add(new Position(x - 2, y - 1));
			}
			if (y + 1 < 8) {
				positions.add(new Position(x - 2, y + 1));
			}
		}

		if (x + 2 < 8) {
			if (y - 1 >= 0) {
				positions.add(new Position(x + 2, y - 1));
			}
			if (y + 1 < 8) {
				positions.add(new Position(x + 2, y + 1));
			}
		}

		if (y - 2 >= 0) {
			if (x - 1 >= 0) {
				positions.add(new Position(x - 1, y - 2));
			}
			if (x + 1 < 8) {
				positions.add(new Position(x + 1, y - 2));
			}
		}

		if (y + 2 >= 0) {
			if (x - 1 >= 0) {
				positions.add(new Position(x - 1, y + 2));
			}
			if (x + 1 < 8) {
				positions.add(new Position(x + 1, y + 2));
			}
		}

		return null;
	}

}
