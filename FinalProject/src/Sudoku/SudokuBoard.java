package Sudoku;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class SudokuBoard extends JPanel {
	
	int[] solutionBoard[];
	int[] solvableBoard[];
	
	
	int boardSize = 9;
	int rootBoardSize;
	
	SudokuBoard(int difficulty) {
		
		setSize(600, 600);
		setLayout(new GridLayout(9, 9));
		
		rootBoardSize = (int) Math.sqrt(boardSize);
		
		solutionBoard = new int[boardSize][boardSize];
		solvableBoard = new int[boardSize][boardSize];
		
		
		
	}
	public void createBoard(int difficulty) {
		
		createSolvableBoard(difficulty);
		addCellsToBoard();
	}
	public void addCellsToBoard() {
		
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				
				boolean isLeftmost = (col % 3 == 0);
				boolean isRightmost = (col == 8) || (col == 2) || (col == 5);
				
				boolean isTopmost = (row % 3 == 0);
				boolean isBottom = (row == 8) || (row == 2) || (row == 5);
				
				Cell c = new Cell(solutionBoard[row][col], isTopmost, isBottom, isRightmost, isLeftmost);
				
				add(c);
				
			}
		}
	}
	
	public int[][] createSolvableBoard(int difficulty) {
		// 0 - easy, 1 - normal, 2 - hard
				// 44 - easy, 50 - normal, 56 - hard
				int removals = 44 + (difficulty * 6);
				
				for (int i = 0; i < boardSize; i = i + rootBoardSize) {
					
					fillBox(i, i);
					
				}
				
				
				fillBoard(0, rootBoardSize);
				solvableBoard = solutionBoard;
				
				while (removals != 0) {
					int currentCell = getRandomNumber(boardSize * boardSize) - 1;

					int row = currentCell / boardSize;
					int col = currentCell % boardSize;
					
					if (col < 0) {
						col = 9;
					}
					
					if (solvableBoard[row][col] != 0) {
						
						removals--;
						solvableBoard[row][col] = 0;
					}
				}
				
				return solvableBoard;
	}
	
	//fills 3x3 boxes individually
		private void fillBox(int row, int col) {
			
			int num;
			
			for (int i = 0; i < rootBoardSize; i++) {
				for (int j = 0; j < rootBoardSize; j++) {
					do {
						num = getRandomNumber(boardSize);
					}
					while (!absentFromBox(row, col, num));
					
					solutionBoard[row + i][col + j] = num;
				}
			}
		}
		
		//fills remainder of board
		private boolean fillBoard(int row, int col) {

			if (col >= boardSize && row < boardSize - 1)
	        {
	            row += 1;
	            col = 0;
	        }
	        if (row >= boardSize && col >= boardSize)
	            return true;
	 
	        if (row < rootBoardSize)
	        {
	            if (col < rootBoardSize)
	                col = rootBoardSize;
	        }
	        else if (row < boardSize - rootBoardSize)
	        {
	            if (col == (int)(row / rootBoardSize) * rootBoardSize)
	                col += rootBoardSize;
	        }
	        else
	        {
	            if (col == boardSize - rootBoardSize)
	            {
	            	row += 1;
	                col = 0;
	                if (row >= boardSize)
	                    return true;
	            }
	        }
	 
	        for (int num = 1; num <= boardSize; num++)
	        {
	            if (safetyCheck(row, col, num))
	            {
	                solutionBoard[row][col] = num;
	                if (fillBoard(row, col + 1))
	                    return true;
	 
	                solutionBoard[row][col] = 0;
	            }
	        }
	        return false;
		}
	
		
		private boolean absentFromBox(int startRow, int startCol, int num) {
			
			for(int i = 0; i < rootBoardSize; i++) {
				for(int j = 0; j < rootBoardSize; j++) {
					if (solutionBoard[startRow + i][startCol + j] == num) {
						
						return false;					
					}
				}
			}
			
			return true;
		}
		
		private boolean absentFromRow(int row, int num) {
			for (int i = 0; i < boardSize; i++) {
				if (solutionBoard[row][i] == num) {
					return false;
				}
			}
			return true;
		}
		
		private boolean absentFromColumn(int col, int num) {
			for (int i = 0; i < boardSize; i++) {
				if (solutionBoard[i][col] == num) {
					return false;
				}
			}
			return true;
		}
		
		private boolean safetyCheck(int i, int j, int num) {return (absentFromRow(i, num) && absentFromColumn(j, num) && absentFromBox(i - i % rootBoardSize, j - j % rootBoardSize, num));}
		private int getRandomNumber(int n) {return (int) Math.floor((Math.random()*n + 1));}
		
		public int[][] getSolvableBoard() {return solvableBoard;}
		public int[][] getSolutionBoard() {return solutionBoard;}
}