package Sudoku;

import javax.swing.JFrame;

public class MenuSwitcher implements EventListener {
	
	MainMenu mainMenu = new MainMenu();
	GameMenu gameMenu = new GameMenu();
	DifficultyMenu difficultySelect = new DifficultyMenu();
	StatisticsMenu statsPage = new StatisticsMenu();
	GameOverMenu endGamePage = new GameOverMenu();
	
	private JFrame frame;
	
	MenuSwitcher() {
		
		frame = new JFrame("Sudoku Game");
		frame.setSize(727, 949);
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        
        mainMenu.addEventListener(this);
        difficultySelect.addEventListener(this);
        gameMenu.addEventListener(this);
        endGamePage.addEventListener(this);
        statsPage.addEventListener(this);
        
        frame.add(gameMenu);
        frame.add(mainMenu);
        frame.add(difficultySelect);
        frame.add(statsPage);
        frame.add(endGamePage);        
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
	
	public void startGame(int difficulty) {
		gameMenu.setVisible(!gameMenu.isVisible());
		gameMenu.launchGame(difficulty);		
	}
	
	public void endGame() {
		gameMenu.setVisible(!gameMenu.isVisible());
	}
	
	public void toggleGameEnd(boolean win) {
		endGamePage.setVisible(!endGamePage.isVisible());
		endGamePage.toggleWinLose(win);
	}
	
	public void toggleStats() {
		statsPage.setVisible(!statsPage.isVisible());
	}
	
	@Override
	public void EventOccured(String details) {
		switch(details) {
		
		case "MainMenu":
			toggleMain();
			toggleDifficultySelect();
			toggleGameEnd(false);
			break;
		
		case "EasyGame":
			toggleDifficultySelect();
			startGame(0);
			break;
			
		case "MediumGame":
            toggleDifficultySelect();
            startGame(1);
            break;
            
		case "HardGame":
            toggleDifficultySelect();
            startGame(2);
            break;
            
		case "DifficultySelect":
			toggleDifficultySelect();
			toggleMain();
			break;
			
		case "GameLost":
			endGame();
			toggleGameEnd(false);
			break;
			
		case "GameWon":
			endGame();
			toggleGameEnd(true);	
		
		case "StatisticsMenu":
			toggleStats();
			toggleMain();
			break;
			
		default:
				// die
		}
		
	}

	
	
}
