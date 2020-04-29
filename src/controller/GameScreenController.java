package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.ArcadeGameState;
import model.GameInfo;
import model.GameModel;
import model.GameState;
import model.LevelObserver;
import model.LevelOneState;
import model.LivesObserver;
import model.ScoreObserver;
import model.TimerObserver;

public class GameScreenController implements Initializable {
	
	@FXML
	private Label scoreLabel;
	
	@FXML
	private Label highscoreLabel;
	
	@FXML
	private Label timerLabel;
	
	@FXML
	private Label levelLabel;
	
	@FXML
	private ImageView life1;
	
	@FXML
	private ImageView life2;
	
	@FXML
	private ImageView life3;
	
	private static GameState gameState;
	
	public static void setGameState(GameState gameState) {
		GameScreenController.gameState = gameState;
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		GameModel gameModel = new GameModel(gameState);
		ImageView[] lives = new ImageView[3];
		lives[0] = life1;
		lives[1] = life2;
		lives[2] = life3;
		
		LevelObserver levelObserver = new LevelObserver(levelLabel, gameModel);
		TimerObserver timerObserver = new TimerObserver(timerLabel);
		LivesObserver livesObserver = new LivesObserver(lives);
		ScoreObserver scoreObserver = new ScoreObserver(scoreLabel);
		
		gameModel.addObserver(levelObserver);
		gameModel.addObserver(timerObserver);
		gameModel.addObserver(livesObserver);
		gameModel.addObserver(scoreObserver);
		
	}

}
