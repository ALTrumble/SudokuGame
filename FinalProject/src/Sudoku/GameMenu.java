package Sudoku;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameMenu extends JPanel implements EventListener {
	
	private ArrayList<EventListener> listeners = new ArrayList<>();
	
	SudokuBoard board = new SudokuBoard();
	
	public GameMenu() {
		setVisible(false);
		setSize(727, 949);
		setBackground(Color.ORANGE);
		setLayout(null);
		
	}
	
	public void launchGame(int difficulty) {
		board.createBoard(difficulty);
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
		// TODO Auto-generated method stub
		
	}
	
	
}
