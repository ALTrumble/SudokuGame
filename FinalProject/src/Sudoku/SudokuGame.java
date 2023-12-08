package Sudoku;

import javax.swing.SwingUtilities;

public class SudokuGame {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuSwitcher().display();
            }
        });
    }
}
