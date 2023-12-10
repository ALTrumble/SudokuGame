package Sudoku;

import java.awt.GridLayout;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SudokuBoard extends JPanel {
	
	int[] solutionBoard[];
	int[] solvableBoard[];
	
	int mistakes = 0;
	
	private static final Random random = new Random();
	
	private static final int SIZE = 9;
	int rootBoardSize;
	
	SudokuBoard() {
		
		setSize(600, 600);
		setLayout(new GridLayout(9, 9));
		
		rootBoardSize = (int) Math.sqrt(SIZE);
		
		solutionBoard = new int[SIZE][SIZE];
		solvableBoard = new int[SIZE][SIZE];
		
	}
	
	public void createBoard(int difficulty) {
		
		uniqueFirstRow(solutionBoard);
		
		if (fillBoard(solutionBoard, 0, 0)) {
			solvableBoard = createPuzzle(copyBoard(solutionBoard), difficulty);
		} else {
			// oops
		}
		
		addCellsToBoard();
		
	}
	public void addCellsToBoard() {
		
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				
				boolean isLeftmost = (col % 3 == 0);
				boolean isRightmost = (col == 8) || (col == 2) || (col == 5);
				
				boolean isTopmost = (row % 3 == 0);
				boolean isBottom = (row == 8) || (row == 2) || (row == 5);
				
				Cell c = new Cell(solvableBoard[row][col], solutionBoard[row][col], isTopmost, isBottom, isRightmost, isLeftmost);
				
				add(c);
				
			}
		}
	}
	
	public int solutionAt(int row, int col) {
		return solutionBoard[row][col];
	}
	
	public void modifySolvableBoardAt(int row, int col, int num) {
		solvableBoard[row][col] = num;
	}
	
	public int getMistakes() {
		return mistakes;
	}
	
	private static void uniqueFirstRow(int[][] board) {
		ArrayList<Integer> firstRow = new ArrayList<>();
	    for (int i = 1; i <= SIZE; i++) {
	        firstRow.add(i);
	    }
	    Collections.shuffle(firstRow);
	    for (int i = 0; i < SIZE; i++) {
	        board[0][i] = firstRow.get(i);
	    }
	}
    
    private static boolean fillBoard(int[][] board, int row, int col) {
        if (row == SIZE - 1 && col == SIZE) {
            return true;
        }
        if (col == SIZE) {
            row++;
            col = 0;
        }
        if (board[row][col] != 0) {
            return fillBoard(board, row, col + 1);
        }
        for (int number = 1; number <= SIZE; number++) {
            if (isValid(board, row, col, number)) {
                board[row][col] = number;
                if (fillBoard(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] board, int row, int col, int number) {
        // Check row and column
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == number || board[i][col] == number) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int[][] createPuzzle(int[][] board, int difficulty) {
        int cellsToRemove = 44 + (difficulty * 6);

        while (cellsToRemove > 0) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);

            if (board[row][col] != 0) {
                board[row][col] = 0;
                cellsToRemove--;
            }
        }

        return board;
    }

    /*private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }*/

    private static int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, SIZE);
        }
        return newBoard;
    }
	
}