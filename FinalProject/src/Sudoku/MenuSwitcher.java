package Sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MenuSwitcher implements EventListener, ActionListener {
	
	MainMenu mainMenu = new MainMenu();
	GameMenu gameMenu = new GameMenu();
	DifficultyMenu difficultySelect = new DifficultyMenu();
	StatisticsMenu statsPage = new StatisticsMenu();
	
	private JFrame frame;
	
	MenuSwitcher() {
		
		frame = new JFrame("Sudoku Game");
		frame.setSize(727, 949);
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        
        mainMenu.addEventListener(this);
        
        frame.add(gameMenu);
        frame.add(mainMenu);
        frame.add(difficultySelect);
        frame.add(statsPage);
        
	}
	
	public void display() {
		frame.setVisible(true);
		toggleMain();
	}
	
	public void toggleMain() {
		mainMenu.setVisible(!mainMenu.isVisible());
	}
	
	public void toggleDifficultySelect() {
		difficultySelect.setVisible(!difficultySelect.isVisible());
	}
	
	public void toggleGame() {
		gameMenu.setVisible(!gameMenu.isVisible());
	}
	
	public void toggleStats() {
		statsPage.setVisible(!statsPage.isVisible());
	}

	@Override
	public void EventOccured(String details) {
		switch(details) {
		
		case "MainMenu":
			toggleMain();
			break;
			
		case "GameMenu":
			toggleGame();
			break;
			
		case "DifficultySelect":
			toggleDifficultySelect();
			toggleMain();
			break;
		default:
				// die
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
