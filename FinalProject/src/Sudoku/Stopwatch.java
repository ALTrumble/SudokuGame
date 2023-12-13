package Sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JLabel;

public class Stopwatch extends JLabel {
	
	private long startTime;
	private long elapsedTime;
	
	private int seconds;
	private int minutes;
	private int hours;
	
	private Timer timer;
	
	Stopwatch() {
		
		setFont(new Font("Arial", Font.BOLD, 30));
		setText("Time: 00:00");
		
	    timer = new Timer(1000, new ActionListener() {
	    	@Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime = System.currentTimeMillis() - startTime;
                seconds = (int) (elapsedTime / 1000) % 60 ;
                minutes = (int) ((elapsedTime / (1000*60)) % 60);
                hours   = (int) ((elapsedTime / (1000*60*60)) % 24);
                
                if (hours > 0) {
                	updateText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
                } else {
                	updateText(String.format("%02d:%02d", minutes, seconds));
                }
                
            }
	    });
	    

    }
	
	public void start() {
		setText("Time: 00:00");
        startTime = System.currentTimeMillis();
        timer.start();       
        
	}
	
	public void stop() {
		timer.stop();
	}
	
	public String getTime() {
		if (hours > 0) {
        	return(String.format("%02d:%02d:%02d", hours, minutes, seconds));
        } else {
        	return(String.format("%02d:%02d", minutes, seconds));
        }
	}
	
	public void updateText(String text) {
		setText("Time: " + text);
	}

}

	