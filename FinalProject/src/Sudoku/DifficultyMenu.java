package Sudoku;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class DifficultyMenu extends JPanel implements EventListener{
	
	private ArrayList<EventListener> listeners = new ArrayList<>();
	
	JLabel titleLabel = new JLabel("Select Difficulty");
	
	JButton easyButton = new JButton("Easy");
	JButton mediumButton = new JButton("Medium");
    JButton hardButton = new JButton("Hard");
    JButton backButton = new JButton("Back");
    
    JPanel buttonPanel = new JPanel();
    
	DifficultyMenu() {
		setVisible(false);
		setSize(727, 949);
		
		titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Set font and size
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text
		add(titleLabel, BorderLayout.NORTH);
		
		easyButton.setFont(new Font("Calibri", Font.PLAIN, 14));
	    easyButton.setBackground(new Color(0x2dce98));
	    easyButton.setForeground(Color.white);
	    easyButton.setUI(new StyledButtonUI());
		
	    mediumButton.setFont(new Font("Calibri", Font.PLAIN, 14));
	    mediumButton.setBackground(new Color(0x2dce98));
	    mediumButton.setForeground(Color.white);
	    mediumButton.setUI(new StyledButtonUI());
	    
	    hardButton.setFont(new Font("Calibri", Font.PLAIN, 14));
	    hardButton.setBackground(new Color(0x2dce98));
	    hardButton.setForeground(Color.white);
	    hardButton.setUI(new StyledButtonUI());
	     
	    backButton.setFont(new Font("Calibri", Font.PLAIN, 14));
	    backButton.setBackground(new Color(0x2dce98));
	    backButton.setForeground(Color.white);
	    backButton.setUI(new StyledButtonUI());
		
	    easyButton.addActionListener(e -> {
	    	String info = "EasyGame";
	    	notifyListeners(info);
	    });
	    
	    mediumButton.addActionListener(e -> {
	    	String info = "MediumGame";
	    	notifyListeners(info);
	    });
	    
	    hardButton.addActionListener(e -> {
	    	String info = "HardGame";
	    	notifyListeners(info);
	    });
	    
	    //mediumButton.addActionListener(this);
	    //hardButton.addActionListener(this);
	    
	    backButton.addActionListener(e -> {
	    	String info = "MainMenu";
	    	notifyListeners(info);
	    });
	    
	    buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(easyButton);
        buttonPanel.add(mediumButton);
        buttonPanel.add(hardButton);
        buttonPanel.add(backButton);
        
        add(buttonPanel);
	    
	    //add(easyButton);
	    //add(mediumButton);
	    //add(hardButton);
	    //add(backButton);
	    
	    
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
