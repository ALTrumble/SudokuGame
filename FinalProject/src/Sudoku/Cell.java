package Sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class Cell extends JPanel implements ActionListener, KeyListener {
	
	Boolean active = false;
	Boolean solved = false;
	
	private static SudokuBoard board;
	private static Cell currentlySelectedCell = null;
	
	int number;
	int input;
	
	int cellRow;
	int cellCol;
	
	JLabel numberLabel = new JLabel("", SwingConstants.CENTER);
	JButton button = new JButton();
	
	Cell(SudokuBoard board, int solution, boolean top, boolean bottom, boolean right, boolean left) {
		setSize(60, 60);
		setLayout(null);
		setBackground(new Color(235, 235, 235));
		setBorder(setCustomBorder((top ? 2 : 1), (left ? 2 : 1), (bottom ? 2 : 1), (right ? 2 : 1)));
		
		if (solution != 0) {
			solved = true;
		} 
		number = solution;
		
		Cell.board = board; 
		
		numberLabel.setBounds(0, 0, 60, 60);
		numberLabel.setFont(new Font("Serif", Font.PLAIN, 45));
		updateNumberLabel(solution);
		add(numberLabel);
		
		button.setSize(new Dimension(60, 60));
		button.setOpaque(false); // Make the button transparent
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
		button.addActionListener(this);
		button.addKeyListener(this);
		add(button);
		
	}
	
	public Border setCustomBorder(int top, int left, int bottom, int right) {
		
		Border black = new MatteBorder(top, left, bottom, right, Color.BLACK);
		Border gray = new MatteBorder(0, 0, 0, 0, Color.GRAY);
		
		Border border = new CompoundBorder(gray, black);
		
		return border;
	}
	
	public void updateNumberLabel(int num) {
		
		if (num == 0) {
			numberLabel.setText("");
		} else {
			numberLabel.setText(Integer.toString(num));
		}
	}
	
	public void deactivate() {
        active = false;
        updateCellColors();
    }
	
	private void toggleActiveStatus() {
        active = !active;
        if (active) {
            // If a cell is already selected, deselect it
            if (currentlySelectedCell != null) {
                currentlySelectedCell.deactivate();
            }
            currentlySelectedCell = this; // Set the currently selected cell
        } else {
            currentlySelectedCell = null; // Deselect the cell
        }
        updateCellColors();
    }

    private void updateCellColors() {
        if (active) {
            setBackground(new Color(173, 216, 230)); // Set a background color to indicate active status
        } else {
            setBackground(new Color(235, 235, 235)); // Reset the background color when deactivating
        }
    }
    
 // Inside the Cell class
    public void setNumber(int num) {
        if (!solved && num != 0) { // Allow setting numbers only for unsolved cells
            int row = getRow();
            int col = getCol();
            
            if (num == board.solutionAt(row, col)) {
                // If the entered number matches the solution, mark the cell as solved
                solved = true;
                updateCellColors();
                currentlySelectedCell = null; // Deselect the cell
                System.out.println("Cell Solved!");
            } else {
                // If the entered number is incorrect, handle it
                System.out.println("Wrong Number!");
            }

            number = num;
            board.modifySolvableBoardAt(row, col, num);
            updateNumberLabel(num);
        }
    }
    
    public int getRow() {
    	return cellRow;
    }
    
    public int getCol() {
    	return cellCol;
    }
    
    public Boolean isActive() {
        return active;
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!solved) {toggleActiveStatus();}
	}

	@Override
    public void keyTyped(KeyEvent e) {
        if (active && Character.isDigit(e.getKeyChar())) {
            int num = Character.getNumericValue(e.getKeyChar());
            setNumber(num);
        }
    }
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
