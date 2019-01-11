package com.practice.chess;

public class ChessMain {

	public static void main(String[] args) {

		EntityFactory factory = new EntityFactory();

		EntityMove entity = factory.getEntityMove(Entity.PAWN);

		ChessSquare[][] chessBoard = createChessBoard();
		printChess(chessBoard);

		Position p1 = new Position(6, 3);
		Position p2 = new Position(5, 3);

		boolean valid = entity.isValidMove(chessBoard, p1, p2);

		if (valid) {

			chessBoard[p2.getX()][p2.getY()] = chessBoard[p1.getX()][p1.getY()];
			chessBoard[p1.getX()][p1.getY()] = null;

		}

		System.out.println(valid);
		System.out.println("-----------------------------------------------------------------");
		printChess(chessBoard);

	}

	public static void printChess(ChessSquare[][] chessBoard) {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {

				String val = chessBoard[i][j] != null ? chessBoard[i][j].toString() : "--";
				System.out.print(val + "  ");
			}
			System.out.println();
		}

	}

	public static ChessSquare[][] createChessBoard() {

		ChessSquare[][] chessBoard = new ChessSquare[8][8];
		chessBoard[0][0] = new ChessSquare(Color.WHITE, Entity.ROOK);
		chessBoard[0][1] = new ChessSquare(Color.WHITE, Entity.HORSE);
		chessBoard[0][2] = new ChessSquare(Color.WHITE, Entity.BISHOP);
		chessBoard[0][3] = new ChessSquare(Color.WHITE, Entity.QUEEN);
		chessBoard[0][4] = new ChessSquare(Color.WHITE, Entity.KING);
		chessBoard[0][5] = new ChessSquare(Color.WHITE, Entity.BISHOP);
		chessBoard[0][6] = new ChessSquare(Color.WHITE, Entity.HORSE);
		chessBoard[0][7] = new ChessSquare(Color.WHITE, Entity.ROOK);
		chessBoard[1][0] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][1] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][2] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][3] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][4] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][5] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][6] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][7] = new ChessSquare(Color.WHITE, Entity.PAWN);

		chessBoard[6][0] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][1] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][2] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][3] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][4] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][5] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][6] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][7] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[7][0] = new ChessSquare(Color.BLACK, Entity.ROOK);
		chessBoard[7][1] = new ChessSquare(Color.BLACK, Entity.HORSE);
		chessBoard[7][2] = new ChessSquare(Color.BLACK, Entity.BISHOP);
		chessBoard[7][3] = new ChessSquare(Color.BLACK, Entity.QUEEN);
		chessBoard[7][4] = new ChessSquare(Color.BLACK, Entity.KING);
		chessBoard[7][5] = new ChessSquare(Color.BLACK, Entity.BISHOP);
		chessBoard[7][6] = new ChessSquare(Color.BLACK, Entity.HORSE);
		chessBoard[7][7] = new ChessSquare(Color.BLACK, Entity.ROOK);
		return chessBoard;

	}

}
