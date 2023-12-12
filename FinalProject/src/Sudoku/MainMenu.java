package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends JPanel implements EventListener {
	
	private ArrayList<EventListener> listeners = new ArrayList<>();
	
	JButton exitButton = new JButton("Exit");
	JButton statisticsButton = new JButton("Statistics");
	JButton startButton = new JButton("Start Game");
	
	JPanel buttonPanel = new JPanel();
	JLabel titleLabel = new JLabel("Sudoku");
	
    public MainMenu() {
    	
    	setVisible(false);
        setSize(727, 949); 

        
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Set font and size
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text

        // Create components
        
        startButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        startButton.setBackground(new Color(0x2dce98));
        startButton.setForeground(Color.white);
        startButton.setUI(new StyledButtonUI());
        
        
        statisticsButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        statisticsButton.setBackground(new Color(0x2dce98));
        statisticsButton.setForeground(Color.white);
        statisticsButton.setUI(new StyledButtonUI());
        
        
        exitButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        exitButton.setBackground(new Color(0x2dce98));
        exitButton.setForeground(Color.white);
        exitButton.setUI(new StyledButtonUI());

        
        // Add action listeners to buttons
        startButton.addActionListener(e -> {
        	String info = "DifficultySelect";
        	notifyListeners(info);
        });
        
        statisticsButton.addActionListener(e -> {
        	String info = "StatisticsMenu";
        	notifyListeners(info);
        });
        
//        statisticsButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Add logic to show statistics
//                JOptionPane.showMessageDialog(MainMenu.this, "Statistics not implemented yet!");
//            }
//        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        

        // Set up layout
        setLayout(new BorderLayout()); // Use BorderLayout for better control of component placement
        //setLayout(null); // Use
        add(titleLabel, BorderLayout.NORTH); // Add title label to the top
 
        //adding all of the buttons to the panel
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(statisticsButton);
        buttonPanel.add(exitButton);
        
        add(buttonPanel);
        
        
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