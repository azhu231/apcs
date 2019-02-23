import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class P2_Zhu_Anthony_Life {
	// Constructor that initializes a game of Life from the given data file
	boolean[][] board;
	public static void main(String[] args) {
		P2_Zhu_Anthony_Life test = new P2_Zhu_Anthony_Life("life100.txt");
		test.runLife(5);
		test.printBoard();
		System.out.println("Amount living in row 9: " + test.rowCount(9));
		System.out.println("Amount living in col 9: " +test.colCount(9));
		System.out.println("Amount total living: " + test.totalCount());
	}
	
	public P2_Zhu_Anthony_Life(String fileName){
		Scanner read = new Scanner(System.in);
		try {
			read = new Scanner(new File(fileName));
		}
		catch (IOException i) {
			System.out.println("No such file exists! BOO HOO");
		}
		board = new boolean[read.nextInt()][read.nextInt()];
		while(read.hasNext()) {
			board[read.nextInt()][read.nextInt()] = true;
		}
	}
	
	// Method that runs the Life simulation through the given generation
	// Generation 0 is the initial position, Generation 1 is the position after one round of Life, etc...
	public void runLife(int numGenerations) {
		for(int i = 1; i <= numGenerations; i++) {
			nextGeneration();
		}
	}
	
	// Method that returns the number of living cells in the given row
	// or returns -1 if row is out of bounds.  The first row is row 0.
	public int rowCount(int row) {
		if(row < 0 || row > board.length) {
			return -1;
		}
		else{
			int truthCounter = 0;
			for(int i = 0; i < board[0].length; i++) {
				if(board[row][i]) {
					truthCounter++;
				}
			}
			return truthCounter;
		}
	}
	
	// Method that returns the number of living cells in the given column
	// or returns -1 if column is out of bounds.  The first column is column 0.
	public int colCount(int col) {
		if(col < 0 || col > board[0].length) {
			return -1;
		}
		else {
			int truthCounter = 0;
			for(int i = 0; i < board.length; i++) {
				if(board[i][col]) {
					truthCounter++;
				}
			}
			return truthCounter;
		}
	}
	
	// Method that returns the total number of living cells on the board
	public int totalCount() {
		int truthCounter = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j]) {
					truthCounter++;
				}
			}
		}
		return truthCounter;
	}

	// Prints out the Life array with row and column headers as shown in the example below.
	public void printBoard() {
		//print out the headers
		System.out.print("   ");
		for(int i = 0; i < board[0].length; i++) {
			System.out.print(i%10);
		}
		System.out.println();
		for(int j = 0; j < board.length; j++) {
			System.out.printf("%2d ", j);
			for(int k = 0; k < board[0].length; k ++) {
				if(board[j][k]) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	// Advances Life forward one generation
	public void nextGeneration() {
		boolean[][] temp = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(numAdjacentTruths(board, i, j) <= 1 || numAdjacentTruths(board, i, j) > 3) {
					//it dies!
					temp[i][j] = false;
				}
				else if (numAdjacentTruths(board, i, j) == 2) {
					//it stays the same!
					temp[i][j] = board[i][j];
				}
				else {
					//life is created!! yayyyy
					temp[i][j] = true;
				}
			}
		}
		board = temp;
	}
	
	public static int numAdjacentTruths(boolean[][] map, int row, int col) {
    	// Yoda says "Fall to the darkside, those who fail to respect boundaries will."
    	int[] vertical = {1, 1, 1, 0, 0, -1, -1 ,-1};
    	int[] horizontal = {1, 0, -1, 1, -1, -1, 0, 1};
    	int truthCount = 0;
    	for(int i = 0; i < 8; i++) {
    		if(inBounds(row+horizontal[i], col+vertical[i], map)) {
    			if(map[row+horizontal[i]][col+vertical[i]]) {
    				truthCount++;
    			}
    		}
    	}
    	return truthCount;
    }
    
    static boolean inBounds(int row, int col, boolean[][]map) {
    	if(row >= map[0].length || row < 0) {
    		return false;
    	}
    	else if(col >= map.length || col < 0) {
    		return false;
    	}
    	return true;
    }
}
