//Graham Guletz, knight.java
//5/16/2011
//Included as part of the Code-Foo IGN Application

public class knight {
	public int count;
	int[][] board;
	public int yLoc, xLoc;

	public knight(int c, int[][] b, int x, int y) {
		count = c;
		board = b;
		yLoc = x;
		xLoc = y;
	}

	public static void main(String[] args) {
		int[][] board = new int[8][8];
		int yLoc = 0;
		int xLoc = 1;
		knight k = new knight(0, board, yLoc, xLoc);
		k = initializeBoard(k);
		while (!isDone(k)) {
			k = determineNewLocation(k);
		}
		System.out.println("The Knight has landed on all " + spacesCovered(k) + " spaces. It took " + k.count + " moves.");
	}

	public static void printBoard(knight k) {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				System.out.print(k.board[x][y] + " ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		
	}


	public static knight determineNewLocation(knight k) {
		k = finishSquare(k); // moves to all locations in top left square
		// moves to starting location of next square
		k = movePiece(k, 2, 1);
		k = movePiece(k, -2, 1);
		k = finishSquare(k); // moves to all locations in top right square
		// moves to starting location of next square
		k = movePiece(k, 2, -1);
		k = movePiece(k, 2, -1);
		k = finishSquare(k); // moves to all locations in bottom right square
		// moves to starting location of next square
		k = movePiece(k, 2, -1);
		k = movePiece(k, 1, -2);
		k = movePiece(k, -1, -2);
		k = movePiece(k, -2, -1);
		k = finishSquare(k); // moves to all locations in bottom left square
		return k;
	}

	public static knight finishSquare(knight k) {
		k = movePiece(k, 1, 2);
		k = movePiece(k, 2, -1);
		k = movePiece(k, -1, -2);
		k = movePiece(k, -1, 2);
		k = movePiece(k, 2, 1);
		k = movePiece(k, -1, -2);
		k = movePiece(k, -2, -1);
		k = movePiece(k, 1, 2);
		k = movePiece(k, 2, -1);
		k = movePiece(k, -2, -1);
		k = movePiece(k, -1, 2);
		k = movePiece(k, 2, 1);
		k = movePiece(k, -1, -2);
		k = movePiece(k, 2, -1);
		k = movePiece(k, -1, 2);
		k = movePiece(k, -2, 1);
		System.out.println("The Knight has moved: " + k.count + " spaces so far.");
		printBoard(k);
		return k;
	}

	public static knight initializeBoard(knight k) {
		for (int x = 0; x < 8; x++)
			for (int y = 0; y < 8; y++) {
				k.board[y][x] = 0;
			}

		k.board[k.yLoc][k.xLoc] = 1;
		System.out.println("Original Empty Board:");
		printBoard(k);
		return k;
	}

	static knight addToCount(knight k) {
		k.count++;
		return k;
	}

	public static knight movePiece(knight k, int yChg, int xChg) {
		k.xLoc = k.xLoc + xChg;
		k.yLoc = k.yLoc + yChg;
		if (k.board[k.yLoc][k.xLoc] == 0) {
			k.board[k.yLoc][k.xLoc] = 1;
		}
		k = addToCount(k);
		//System.out.println("Move #: " + k.count);
		//System.out.println("Spaces Covered: " + spacesCovered(k));
		return k;
	}

	public static boolean isDone(knight k) {
		for (int x = 0; x < 8; x++)
			for (int y = 0; y < 8; y++) {
				if (k.board[y][x] == 0) {
					return false;
				}
			}
		return true;
	}

	public static int spacesCovered(knight k){
		int count = 0;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if(k.board[x][y]==1){
					count++;
				}
			}
		}
		return count;
	}
	}