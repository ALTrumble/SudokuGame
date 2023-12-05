package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsBoard extends JFrame {
	public StatisticsBoard() {
//		setTitle("Statistics Menu");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(600, 250); // Increased height to accommodate the title label
//        setLocationRelativeTo(null);
//        
//        // Create title label
//        JLabel titleLabel = new JLabel("Statisics Menu");
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Set font and size
//        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text
//        
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
