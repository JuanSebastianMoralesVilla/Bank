package ui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Bank;

public class BankGUI {
	
	private Bank bank;

	//Elements of interface
@FXML
private Pane mainPane;
@FXML
private Button btInit;
   


//Constructor
	   
	BankGUI(Stage ventana, Bank bank){
		this.bank= bank;
		
	}


    @FXML
    void init(ActionEvent event) throws Exception {
    	
    	  try {
              FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchID.fxml"));
                      Parent root1 = (Parent) fxmlLoader.load();
                      Stage stage = new Stage();
                      stage.setScene(new Scene(root1));  
                      stage.show();
              } catch(Exception e) {
                 e.printStackTrace();
                }
    }
    
    
    }

    	
    	

