package com.practice.chess;

public interface EntityMove {

	public boolean isValidMove(ChessSquare[][] chessBoard, Position initialPosition, Position finalPosition);

}
