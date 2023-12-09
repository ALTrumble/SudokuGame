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

public class Cell extends JPanel implements ActionListener, KeyListener, MouseListener {
	
	Boolean active = false;
	Boolean solved = false;
	
	int number;
	int input;
	
	
	JLabel numberLabel = new JLabel("", SwingConstants.CENTER);
	JButton button = new JButton();
	
	Cell(int solution, boolean top, boolean bottom, boolean right, boolean left) {
		setSize(60, 60);
		setLayout(null);
		setBackground(new Color(235, 235, 235));
		setBorder(setCustomBorder((top ? 2 : 1), (left ? 2 : 1), (bottom ? 2 : 1), (right ? 2 : 1)));
		
		number = solution;
		
		numberLabel.setBounds(0, 0, 60, 60);
		numberLabel.setFont(new Font("Serif", Font.PLAIN, 45));
		updateNumberLabel(solution);
		add(numberLabel);
		
		button.setSize(new Dimension(60, 60));
		button.setOpaque(false); // Make the button transparent
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
		button.addActionListener(this);
		add(button);
		
		
        
        //button.addActionListener(this);
		
		// Add mouse listener to detect clicks
		/*
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toggleActiveStatus();
            }
            */
		
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
	
	private void toggleActiveStatus() {
        active = !active;
        updateCellColors();
    }

    private void updateCellColors() {
        if (active) {
            setBackground(new Color(173, 216, 230)); // Set a background color to indicate active status
        } else {
            setBackground(new Color(235, 235, 235)); // Reset the background color when deactivating
        }
    }

    public Boolean isActive() {
        return active;
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		toggleActiveStatus();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
