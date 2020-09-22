package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Bank;

public class BankGUI {

	private Bank bank;

	// Elements of interface
	

    @FXML
    private BorderPane myPane;
	
	@FXML
	private Button btInit;


    
    

	 /// fxml de la creacion de clientes
    
    private Button btnextUser;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtIDaddUser;

    
    
    
   
    
    @FXML
    private BorderPane BorderPaint1;

    @FXML
    private Pane mainPaneCreateUser;

 

    @FXML
    private ToggleGroup grupoTipocliente;

   

//Constructor


	public BankGUI(Stage stage, Bank bank) {
		// TODO Auto-generated constructor stub
	}

	public void init(ActionEvent event) throws IOException {
	
		FXMLLoader fL = new FXMLLoader(getClass().getResource("CreateUser1.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);

		
		
		
		/*
	FXMLLoader f= new FXMLLoader(getClass().getResource("CreateUser1.fxml"));
	f.setController(this);
	Parent root= f.load();
	Stage st=new Stage();
	
	sc.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm());
	st.initModality(Modality.APPLICATION_MODAL);
st.initStyle(StageStyle.DECORATED);
st.setScene(sc);

st.show();

*/
	}
	
	
	
    @FXML
    void nextUser(ActionEvent event) throws IOException {
    	
    	FXMLLoader fL = new FXMLLoader(getClass().getResource("createUser2.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);

    }
    
    // interfaz 2 de creacion 
    
    @FXML
    private Button btCreateUser;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtIdTarjet;

    @FXML
    private TextField txtamount;

    @FXML
    private ToggleGroup GroupTarjet;

    @FXML
    void createUser(ActionEvent event) throws IOException {

    	
       	FXMLLoader fL = new FXMLLoader(getClass().getResource("SearchID.fxml"));
    		fL.setController(this);
    		Parent pane;
    		pane = fL.load();
    		myPane.getChildren().clear();
    		myPane.setCenter(pane);
    }
    
    
    
    
    // interfaz de buscar id
    
    @FXML
    private Button btSearch;

    @FXML
    private TextField txtid;

    @FXML
    private Button btAtrasSearch;

    @FXML
    void btAtras(ActionEvent event) throws IOException {
    
       	FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
    		fL.setController(this);
    		Parent pane;
    		pane = fL.load();
    		myPane.getChildren().clear();
    		myPane.setCenter(pane);
    		System.out.println("entre");
        	

    }

    @FXML
    void btSearchIDtoOptions(ActionEvent event) throws IOException {
    	
    	FXMLLoader fL = new FXMLLoader(getClass().getResource("TableInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
		
  
    }

    

}
