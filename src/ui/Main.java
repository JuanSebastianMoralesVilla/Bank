package ui;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Bank;
import ui.BankGUI;

public class Main extends Application {

	private BankGUI bankGui;
	private Bank bank;

	public Main() {
		bank = new Bank();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		bankGui = new BankGUI(stage, bank);
		FileInputStream fis = new FileInputStream("Images/bank.png");
		FXMLLoader f = new FXMLLoader(getClass().getResource("Welcome.fxml"));
		f.setController(bankGui);
		Parent root = f.load();
		Scene sc = new Scene(root);
		stage.setScene(sc);
		stage.sizeToScene();
		sc.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm());
		stage.setScene(sc);
		stage.centerOnScreen();
		stage.getIcons().add(new Image(fis));
		stage.setTitle("BANK");
		stage.show();

	}

}