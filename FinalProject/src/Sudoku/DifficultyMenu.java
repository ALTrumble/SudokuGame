package Sudoku;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class DifficultyMenu extends JPanel implements EventListener{
	
	private ArrayList<EventListener> listeners = new ArrayList<>();
	
	JButton easyButton = new JButton("Easy");
	JButton mediumButton = new JButton("Medium");
    JButton hardButton = new JButton("Hard");
    JButton backButton = new JButton("Back");
    
	DifficultyMenu() {
		setVisible(false);
		setSize(727, 949);
		setBackground(Color.BLUE);
		
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
	    
	    //mediumButton.addActionListener(this);
	    //hardButton.addActionListener(this);
	    
	    backButton.addActionListener(e -> {
	    	String info = "MainMenu";
	    	notifyListeners(info);
	    });
	    
	    add(easyButton);
	    add(mediumButton);
	    add(hardButton);
	    add(backButton);
	    
	    
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
