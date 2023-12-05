package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsBoard extends JFrame {
	public StatisticsBoard() {
		// Set up the statistics board frame
        setTitle("Statistics Board");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose on close to avoid closing the entire application
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Create components for statistics (placeholders)
        JLabel gamesPlayedLabel = new JLabel("Games Played: 10");
        JLabel gamesWonLabel = new JLabel("Games Won: 5");
        JLabel winPercentageLabel = new JLabel("Win Percentage: 50%");

        // Set up layout for statistics board
        setLayout(new GridLayout(3, 1));
        add(gamesPlayedLabel);
        add(gamesWonLabel);
        add(winPercentageLabel);
        
	}
}
