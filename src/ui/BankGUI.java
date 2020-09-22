package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Bank;
import threads.ValuesEmptyThread;

public class BankGUI {

	private Bank bank;

	// Elements of interface
	@FXML
	private Pane mainPane;
	@FXML
	private Button btInit;

	// turn

	@FXML
	private Button btShift;

	@FXML
	private TextField txtName1;

	@FXML
	private TextField txtid1;

	@FXML
	private Button btcreateUser;

//Constructor

	public BankGUI(Stage stage, Bank bank) {
		// TODO Auto-generated constructor stub
		this.bank = bank;

	}

	
	public void init(ActionEvent event) throws Exception {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
			fxmlLoader.setController(this);
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
			System.out.println("Entre");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	




	
}
