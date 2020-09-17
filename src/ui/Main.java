package ui;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Bank;
import model.*;
import ui.*;

public class Main extends Application {

	private BankGUI bankGui;
	private Bank bank;

	public Main() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		FXMLLoader fxmlLoad = new FXMLLoader(getClass().getResource("WelcomeInicial.fxml"));
		bankGui = new BankGUI(stage, bank);
		fxmlLoad.setController(bankGui);
		Parent root = fxmlLoad.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm());
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.setMinHeight(600);
		stage.setMinWidth(1000);
        stage.setTitle("Bank");
		stage.show();
	}

}
