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
		mainMenu.setVisible(true);
	}
	
	public void startGame(int difficulty) {
		gameMenu.setVisible(true);
		gameMenu.launchGame(difficulty);		
	}
	
	
	
	@Override
	public void EventOccured(String details) {
		switch(details) {
		
		case "MainMenu":
			mainMenu.setVisible(true);
			difficultySelect.setVisible(false);
			endGamePage.setVisible(false);
			statsPage.setVisible(false);
			break;
		
		case "EasyGame":
			difficultySelect.setVisible(false);
			startGame(0);
			break;
			
		case "MediumGame":
			difficultySelect.setVisible(false);
            startGame(1);
            break;
            
		case "HardGame":
			difficultySelect.setVisible(false);
            startGame(2);
            break;
            
		case "DifficultySelect":
			difficultySelect.setVisible(true);
			mainMenu.setVisible(false);
			break;
			
		case "GameLost":
			gameMenu.setVisible(false);
			endGamePage.setVisible(true);
			endGamePage.toggleWinLose(false);
			break;
			
		case "GameWon":
			gameMenu.setVisible(false);
			endGamePage.setVisible(true);
			endGamePage.toggleWinLose(true);	
			break;
			
		case "StatisticsMenu":
			statsPage.setVisible(true);
			mainMenu.setVisible(false);
			break;
			
		default:
				// die
		}
		
	}

	
	
}
