package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsMenu extends JPanel {
	public StatisticsMenu() {
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
		setVisible(false);
        
        
        setSize(727, 949);
        

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

