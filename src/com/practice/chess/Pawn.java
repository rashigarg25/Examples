package com.practice.chess;

public class Pawn implements EntityMove {

	@Override
	public boolean isValidMove(ChessSquare[][] chessBoard, Position initialPosition, Position finalPosition) {

		// boolean isValid = false;
		boolean validX = false;
		boolean validY = false;
		int initalX = initialPosition.getX();
		int initalY = initialPosition.getY();
		int finalX = finalPosition.getX();
		int finalY = finalPosition.getY();

		if (chessBoard[initalX][initalY].getColor() == Color.BLACK) {
			if ((finalX + 1) == initalX) {
				validX = true;
			}
			if (initalY == finalY && chessBoard[finalX][finalY] == null) {
				validY = true;
			}
			int diff = Math.abs(finalY - initalY);
			if (diff == 1 && chessBoard[finalX][finalY] != null
					&& chessBoard[finalX][finalY].getColor() == Color.WHITE) {
				validY = true;
			}
		} else if (chessBoard[initalX][initalY].getColor() == Color.WHITE) {
			if ((finalX - 1) == initalX) {
				validX = true;
			}
			if (initalY == finalY && chessBoard[finalX][finalY] == null) {
				validY = true;
			}
			int diff = Math.abs(finalY - initalY);
			if (diff == 1 && chessBoard[finalX][finalY] != null
					&& chessBoard[finalX][finalY].getColor() == Color.BLACK) {
				validY = true;
			}
		}
		return validX && validY;

	}

}
