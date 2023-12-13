package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StatisticsMenu extends JPanel {
	
	private ArrayList<EventListener> listeners = new ArrayList<>();
	
	JLabel titleLabel = new JLabel("Statistics Menu");
	
	public StatisticsMenu() {
		setVisible(false);
		setSize(727, 949);
		
		titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Set font and size
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Center the text
		
        String StatFile = "StatsMenu";
		readingTheFile(StatFile );
		
        // Set up layout
        setLayout(new BorderLayout()); // Use BorderLayout for better control of component placement
        
        add(titleLabel, BorderLayout.NORTH);
	}
	public void readingTheFile(String StatFile) {
		try {
		      File myObj = new File(StatFile);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
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
	
	public void EventOccured(String details) {
		// TODO Auto-generated method stub
		
	}
}

