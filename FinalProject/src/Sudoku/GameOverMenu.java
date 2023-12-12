package Sudoku;

import java.util.ArrayList;

import javax.swing.*;

public class GameOverMenu extends JPanel implements EventListener{
	
	private ArrayList<EventListener> listeners = new ArrayList<>();
	
	JLabel titleText = new JLabel("Game Over Menu (temporary text");
	
	GameOverMenu() {
		setVisible(false);
		setSize(727, 949);
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
