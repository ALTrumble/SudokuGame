package Sudoku;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class SudokuBoard extends JPanel {
	
	SudokuBoard() {
		
		setSize(600, 600);
		setLayout(new GridLayout(9, 9));
		
	}
	
	
	public Cell createCell(boolean top, boolean bottom, boolean right, boolean left) {
		
		return new Cell(top, bottom, right, left);
		
	}
	
	public void createBoard() {
		
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				
				boolean isLeftmost = (col % 3 == 0);
				boolean isRightmost = (col == 8) || (col == 2) || (col == 5);
				
				boolean isTopmost = (row % 3 == 0);
				boolean isBottom = (row == 8) || (row == 2) || (row == 5);
				
				Cell c = new Cell(isTopmost, isBottom, isRightmost, isLeftmost);
				
				add(c);
				
				
			}
		}
	}
}


