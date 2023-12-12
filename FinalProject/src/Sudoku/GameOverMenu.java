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
	JButton restartButton = new JButton("New Game");
	
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
		
		mainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyListeners("MainMenu");
			}
		});
		
		restartButton.setBackground(new Color(0x2dce98));
		restartButton.setForeground(Color.white);
		restartButton.setUI(new StyledButtonUI());
		
		restartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notifyListeners("GameRestarted");
			}
		});
		
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(mainButton);
		buttonPanel.add(restartButton);
		add(buttonPanel, BorderLayout.CENTER);
		
		
	}
	
	
	public void toggleWinLose(boolean win) {
		if (win) {
			
		} else {
			// TODO win lose menu
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
