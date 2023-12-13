package Sudoku;

import java.util.ArrayList;


import javax.swing.*;

public class GameMenu extends JPanel implements EventListener {
	
	private ArrayList<EventListener> listeners = new ArrayList<>();
	private SudokuBoard board = new SudokuBoard();
	
	private Stopwatch stopwatch = new Stopwatch();
	private MistakeCounter mistakes = new MistakeCounter();
	
	private int mistakesMade = 0;
	private int cellsSolved = 0;
	private int cellsUnsolved = 0;
	
	String time;
	
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
	
    public int[] getStats() {
    	int[] stats = {mistakesMade, cellsSolved, cellsUnsolved};
    	return stats;
    }
    
    public String getElapsedTime() {
    	return time;
    }
    
	@Override
	public void EventOccured(String details) {
		if (details == "GameWon") {
			stopwatch.stop();
			
			time = stopwatch.getTime();
			
			mistakesMade = board.getMistakes();
			cellsSolved = board.getSolved();
			cellsUnsolved = board.getUnsolved();
			
			notifyListeners("GameWon");
		} else if (details == "GameLost") {
			stopwatch.stop();
			
			time = stopwatch.getTime();
			
			mistakesMade = board.getMistakes();
			cellsSolved = board.getSolved();
			cellsUnsolved = board.getUnsolved();
			
			if (cellsSolved > cellsUnsolved) {
				cellsSolved = cellsUnsolved;
			}
			
			notifyListeners("GameLost");
		} else if (details == "Mistake") {
			mistakes.mistake(); 
			
			mistakesMade = board.getMistakes();
			cellsSolved = board.getSolved();
			cellsUnsolved = board.getUnsolved();
			
		}
		
	}
	
	
}
