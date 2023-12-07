package Sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class Cell extends JPanel implements ActionListener, KeyListener {
	
	Boolean selected = false;
	
	JLabel number = new JLabel("0", SwingConstants.CENTER);
	//JButton button = new JButton();
	
	Cell(boolean top, boolean bottom, boolean right, boolean left) {
		setSize(60, 60);
		setLayout(null);
		setBackground(new Color(235, 235, 235));
		setBorder(setCustomBorder((top ? 2 : 1), (left ? 2 : 1), (bottom ? 2 : 1), (right ? 2 : 1)));
		
		number.setBounds(0, 0, 0, 0);
		number.setFont(new Font("Serif", Font.PLAIN, 45));
		add(number);
		
	}
	
	public Border setCustomBorder(int top, int left, int bottom, int right) {
		
		Border black = new MatteBorder(top, left, bottom, right, Color.BLACK);
		Border gray = new MatteBorder(0, 0, 0, 0, Color.GRAY);
		
		Border border = new CompoundBorder(gray, black);
		
		return border;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
