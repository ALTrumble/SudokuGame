package Sudoku;

import java.awt.Font;

import javax.swing.JLabel;

public class MistakeCounter extends JLabel {
	
	private int mistakes = 0;
	
	MistakeCounter() {
		setFont(new Font("Arial", Font.BOLD, 30));
		setText("Mistakes: " + mistakes + "/3");
	}
	
	public void mistake() {
		mistakes++;
		updateText();
	}
	
	public void updateText() {
		setText("Mistakes: " + mistakes + "/3");
		repaint();
	}
	
	public void reset() {
		mistakes = 0;
		updateText();
	}
	
}
