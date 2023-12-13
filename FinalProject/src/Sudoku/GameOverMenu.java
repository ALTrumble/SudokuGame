package Sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GameOverMenu extends JPanel implements EventListener{
	
	private ArrayList<EventListener> listeners = new ArrayList<>();
	
	JLabel titleLabel = new JLabel("Game Over Menu (temporary text");
	JPanel buttonPanel = new JPanel();
	
	JButton mainButton = new JButton("Return to Main Menu");
	JButton exitButton = new JButton("Quit");
	
	JLabel mistakesLabel = new JLabel("Mistakes Made: 0/3");
	JLabel cellsSolved = new JLabel("Cells solved: 0/0");
	
	JLabel timeElapsedLabel = new JLabel("Time Elapsed: 00:00:00");
	
	GameOverMenu() {
		setVisible(false);
		setSize(727, 949);
		setLayout(new BorderLayout());
		
		titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Set font and size
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text
		add(titleLabel, BorderLayout.NORTH);
		
		mainButton.setBackground(new Color(0x2dce98));
		mainButton.setForeground(Color.white);
		mainButton.setUI(new StyledButtonUI());
		
		mistakesLabel.setFont(new Font("Arial", Font.BOLD, 20));
		mistakesLabel.setHorizontalAlignment(JLabel.CENTER);
		add(mistakesLabel, BorderLayout.EAST);
		
		cellsSolved.setFont(new Font("Arial", Font.BOLD, 20));
		cellsSolved.setHorizontalAlignment(JLabel.CENTER);
		add(cellsSolved, BorderLayout.WEST);
		
		timeElapsedLabel.setFont(new Font("Arial", Font.BOLD, 20));
		timeElapsedLabel.setHorizontalAlignment(JLabel.CENTER);
		add(timeElapsedLabel, BorderLayout.SOUTH);
		
		mainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyListeners("MainMenu");
			}
		});
		
		exitButton.setBackground(new Color(0x2dce98));
		exitButton.setForeground(Color.white);
		exitButton.setUI(new StyledButtonUI());
		
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(mainButton);
		buttonPanel.add(exitButton);
		add(buttonPanel, BorderLayout.CENTER);
		
		
	}
	
	
	public void toggleWinLose(boolean win, int[] stats, String time) {
		
		int mistakes = stats[0];
		int solved = stats[1];
		int unsolved = stats[2];
		
		if (win) {
			titleLabel.setText("Congratulations!");
			mistakesLabel.setText("Mistakes Made: " + mistakes + "/3");
			cellsSolved.setText("Cells Solved: " + solved + "/" + unsolved);
			
			timeElapsedLabel.setText("Time Elapsed: " + time);
			
			revalidate();
			repaint();
		} else {
			titleLabel.setText("Game Over!");
			mistakesLabel.setText("Mistakes Made: " + mistakes + "/3");
			cellsSolved.setText("Cells Solved: " + solved + "/" + unsolved);
			
			timeElapsedLabel.setText("Time Elapsed: " + time);
			
			revalidate();
			repaint();
		}
	}
	
	public void addEventListener(EventListener listener) {
    	listeners.add(listener);
    }
    
    public void notifyListeners(String info) {
    	for (EventListener listener : listeners) {
    		listener.EventOccured(info);
    	}
    }
	
	@Override
	public void EventOccured(String details) {
		// TODO Auto-generated method stub
		
	}

}
