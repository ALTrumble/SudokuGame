package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGameMenu extends JFrame {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SudokuGameMenu().setVisible(true);
            }
        });
    }
    public SudokuGameMenu() {
        // Set up the main menu frame
        setTitle("Sudoku Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700); // Increased height to accommodate the title label
        setLocationRelativeTo(null);
        JPanel buttonPanel = new JPanel(); // Panel to hold buttons
        
        // Create title label
        JLabel titleLabel = new JLabel("Sudoku");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Set font and size
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text

        // Create components
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        startButton.setBackground(new Color(0x2dce98));
        startButton.setForeground(Color.white);
        startButton.setUI(new StyledButtonUI());
        
        JButton statisticsButton = new JButton("Statistics");
        statisticsButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        statisticsButton.setBackground(new Color(0x2dce98));
        statisticsButton.setForeground(Color.white);
        statisticsButton.setUI(new StyledButtonUI());
        
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        exitButton.setBackground(new Color(0x2dce98));
        exitButton.setForeground(Color.white);
        exitButton.setUI(new StyledButtonUI());

        // Create buttons for difficulty levels
        JButton easyButton = new JButton("Easy");
        easyButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        easyButton.setBackground(new Color(0x2dce98));
        easyButton.setForeground(Color.white);
        easyButton.setUI(new StyledButtonUI());
        
        JButton mediumButton = new JButton("Medium");
        mediumButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        mediumButton.setBackground(new Color(0x2dce98));
        mediumButton.setForeground(Color.white);
        mediumButton.setUI(new StyledButtonUI());
        
        JButton hardButton = new JButton("Hard");
        hardButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        hardButton.setBackground(new Color(0x2dce98));
        hardButton.setForeground(Color.white);
        hardButton.setUI(new StyledButtonUI());
        
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        backButton.setBackground(new Color(0x2dce98));
        backButton.setForeground(Color.white);
        backButton.setUI(new StyledButtonUI());

        
        // Add action listeners to buttons
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showDifficultyMenu();
            	startButton.setVisible(false);
            	statisticsButton.setVisible(false);
            	exitButton.setVisible(false);
            	easyButton.setVisible(true);
            	mediumButton.setVisible(true);
            	hardButton.setVisible(true);
            	backButton.setVisible(true);
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showDifficultyMenu();
            	startButton.setVisible(true);
            	statisticsButton.setVisible(true);
            	exitButton.setVisible(true);
            	easyButton.setVisible(false);
            	mediumButton.setVisible(false);
            	hardButton.setVisible(false);
            	backButton.setVisible(false);
            }
        });

        statisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to show statistics
                JOptionPane.showMessageDialog(SudokuGameMenu.this, "Statistics not implemented yet!");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        SudokuBoard board = new SudokuBoard(0);
        // Add action listeners to difficulty buttons
        easyButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		//buttonPanel.add(board);
        	}
        });
        
        mediumButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO: Add logic to start a game with easy difficulty
        		//JOptionPane.showMessageDialog(buttonPanel, "Starting medium game!");
        		
        	}
        });
        
        hardButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO: Add logic to start a game with easy difficulty
        		//JOptionPane.showMessageDialog(buttonPanel, "Starting hard game!");
        		
        	}
        });

        // Set up layout
        setLayout(new BorderLayout()); // Use BorderLayout for better control of component placement
        add(titleLabel, BorderLayout.NORTH); // Add title label to the top
 
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(statisticsButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(easyButton);
        buttonPanel.add(mediumButton);
        buttonPanel.add(hardButton);
        buttonPanel.add(backButton);

        JFrame GamePanel = new JFrame(); 
        GamePanel.add(board);
        //add(GamePanel, BorderLayout.SOUTH);

        
        board.addCellsToBoard();
        add(board, BorderLayout.CENTER);
        board.setVisible(false);

        
        easyButton.setVisible(false);
        mediumButton.setVisible(false);
        hardButton.setVisible(false);
        backButton.setVisible(false);
        
        add(buttonPanel, BorderLayout.CENTER); // Add button panel to the center
    }
}
