package com.practice.chess;

public class Queen implements EntityMove {

	@Override
	public boolean isValidMove(ChessSquare[][] chessBoard, Position initialPosition, Position finalPosition) {
		boolean valid = false;
		int initalX = initialPosition.getX();
		int initalY = initialPosition.getY();
		int finalX = finalPosition.getX();
		int finalY = finalPosition.getY();

		if (initalX == finalX || initalY == finalY || (Math.abs(finalX - initalX) == Math.abs(finalY - finalX))) {
			valid = true;
		}

		return valid;
	}

}
