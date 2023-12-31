package Sudoku;

import javax.swing.JFrame;

public class MenuSwitcher implements EventListener {
	
	MainMenu mainMenu = new MainMenu();
	GameMenu gameMenu = new GameMenu();
	DifficultyMenu difficultySelect = new DifficultyMenu();
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
        
        frame.add(gameMenu);
        frame.add(mainMenu);
        frame.add(difficultySelect);
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
			endGamePage.toggleWinLose(false, gameMenu.getStats(), gameMenu.getElapsedTime());
			break;
			
		case "GameWon":
			gameMenu.setVisible(false);
			endGamePage.setVisible(true);
			endGamePage.toggleWinLose(true, gameMenu.getStats(), gameMenu.getElapsedTime());	
			break;
			
		default:
				// die
		}
		
	}

	
	
}
