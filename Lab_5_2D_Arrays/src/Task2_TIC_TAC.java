
public class Task2_TIC_TAC {
//	private static final char EMPTY = ' ';
	private char[][] board;

	
	
	public Task2_TIC_TAC(char[][] board) {
		super();
		this.board = board;
	}









	/*
	* This method checks all rows and returns true if any of them are marked with
	* all of a single player's markers.
	* Otherwise, returns false.
	*/
	public boolean checkRows() {
		for (char[] cs : board) {
			int countX= 0;
			int countO= 0;
			for (char c : cs) {
				if (String.valueOf(c).equalsIgnoreCase("x")) {
					countX++;
				}
				if (String.valueOf(c).equalsIgnoreCase("o")) {
					countO++;
				}
				
				
				if (countX == board.length || countO== board.length) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	
	/*
	* This method checks all columns and returns true if any of them are marked
	* with all of a single player's.
	* Otherwise, returns false.
	*/
	public boolean checkColumns() {
		for (int i = 0; i < board.length; i++) {
			int countX= 0;
			int countO= 0;
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == 'X') {
					countX++;
				}
				if (board[j][i] == 'O') {
					countO++;
				}
				if (countX == board.length || countO== board.length) {
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	
	
	
	/*
	* This method checks both diagonals and returns true if
	any of them are marked
	* with all of a single player's markers. Otherwise,
	returns false.
	*/
	public boolean checkDiagonals() {
	// Check top-left to bottom-right
		int countX= 0;
		int countO= 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][i]=='X') {
				countX++;
			}
			if (board[i][i]=='O') {
				countO++;
			}
			if (countX == board.length || countO== board.length) {
				return true;
			}
		}
		
		
		// Check bottom-left to top-right
//			reset count
		countX= 0;
		countO= 0;
		int i = 0;
		int j = board.length-1;
		for (int k = 0; k < board.length; k++) {
			
				if (board[j][i]=='X') {
					countX++;
				}
				if (board[j][i]=='O') {
					countO++;
				}
				if (countX == board.length || countO== board.length) {
					return true;
				}
				i++; j--;
			
		}
		return false;
	} 
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static void main(String[] args) {
		char[][] board =  { {'X','X','X','X'},
							{'X','X','X','O'},
							{'O','X','O','X'},
							{'X','X','O','O'}};
		
		
		Task2_TIC_TAC test = new Task2_TIC_TAC(board);
		
		System.out.println(test.checkRows());
		System.out.println(test.checkColumns());
		System.out.println(test.checkDiagonals());
		
		
	}
}
