package Sudoku;

import java.awt.Color;
import java.util.ArrayList;


import javax.swing.*;

public class GameMenu extends JPanel implements EventListener {
	
	private ArrayList<EventListener> listeners = new ArrayList<>();
	private SudokuBoard board = new SudokuBoard();
	
	private Stopwatch stopwatch = new Stopwatch();
	private MistakeCounter mistakes = new MistakeCounter();
	
	public GameMenu() {
		setVisible(false);
		setSize(727, 949);
		setLayout(null);
		
		
		
	}
	
	public void launchGame(int difficulty) {
		board.createBoard(difficulty);
		board.setBounds(55, 55, 600, 600);
		board.addEventListener(this);
		
		mistakes.setBounds(55, 0, 300, 50);
		
		stopwatch.setBounds(450, 0, 300, 50);
		stopwatch.start();
		add(stopwatch);
		add(mistakes);
		add(board);
		
		validate();
		repaint();
	}
	
	public SudokuBoard getBoard() {
		return board;
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
		if (details == "GameWon") {
			notifyListeners("GameWon");
		} else if (details == "GameLost") {
			stopwatch.stop();
			notifyListeners("GameLost");
		} else if (details == "Mistake") {
			mistakes.mistake(); 
		}
		
	}
	
	
}
