package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class helpMenuController implements Initializable {
	
	@FXML
	private Button mainMenuButton;
	
	public void mainMenuButtonAction(ActionEvent event) {
		ButtonHandler.goToDifferentScreen(event, "/view/MainMenu.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
