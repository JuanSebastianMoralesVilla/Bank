package ui;

import customExceptions.UserAlreadyExistException;
import customExceptions.UserDoesNotExistException;
import customExceptions.ValuesIsEmptyException;


import java.io.IOException;
import java.time.LocalDate;

import javax.swing.Icon;
import javax.swing.JOptionPane;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import model.Bank;
import model.Client;
import model.Tarjet;

public class BankGUI {

	private Bank bank;
	private Client normalClient;
	private Client priorityClient;
	
	@FXML
    private Label currentShift;
	//Shift Screen 
    @FXML
    private Label txtNormalQueue;

    @FXML
    private Label txtPriorityQueue;

	// Elements of interface
    
    private BorderPane menuOptionsPane;
    private BorderPane menuPOptionsPane;
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

	// interfaz 2 de creacion

	@FXML
	private Button btCreateUser;

	@FXML
	private DatePicker txtDate;

	@FXML
	private TextField txtIdTarjet;

    @FXML
    private TextField txtamountCreate;

    @FXML
    private Button BtSearchInformationUserP;

    @FXML
    private Button btconsignacionP;

    @FXML
    private Button btPagoTarjetaP;

    @FXML
    private Button btRetiroP;

    @FXML
    private Button btCancelAccountP;

    @FXML
    private Button BTUNDOP;

    @FXML
    private Label currentShiftP;	

	// interfaz de buscar id

	@FXML
	private Button btSearch;

	@FXML
	private TextField txtid;

	@FXML
	private Button btAtrasSearch;

	// interfaz de turno

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
		menuOptionsPane = new BorderPane();
		menuPOptionsPane = new BorderPane();
	}

	public void init(ActionEvent event) throws IOException {

		FXMLLoader fL = new FXMLLoader(getClass().getResource("turnoInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
		
		
		
		FXMLLoader fL2 = new FXMLLoader(getClass().getResource("reportQueue.fxml"));
		fL2.setController(this);
		Parent paneShowShifts;
		paneShowShifts = fL2.load();
		Scene scene = new Scene(paneShowShifts);
		scene.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm());
		Stage stageShowShifts = new Stage();
		stageShowShifts.setScene(scene);
		stageShowShifts.show();
		
		
		
		
		Scene sceneMenu = new Scene(menuOptionsPane);
		sceneMenu.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm());
		Stage stageMenu = new Stage();
		stageMenu.setScene(sceneMenu);
		stageMenu.show();
		
		
		FXMLLoader fLMenu = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fLMenu.setController(this);
		Parent paneMenuOptions = fLMenu.load();
		menuOptionsPane.getChildren().clear();
		menuOptionsPane.setCenter(paneMenuOptions);
		stageMenu.sizeToScene();
		stageMenu.setTitle("Menu Options Normal Queue");
		
		
		
		Scene sceneMenuP = new Scene(menuPOptionsPane);
		sceneMenuP.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm());
		Stage stageMenuP = new Stage();
		stageMenuP.setScene(sceneMenuP);
		stageMenuP.show();
		
		FXMLLoader fLMenuP = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fLMenuP.setController(this);
		Parent paneMenuPOptions = fLMenuP.load();
		menuPOptionsPane.getChildren().clear();
		menuPOptionsPane.setCenter(paneMenuPOptions);
		stageMenuP.sizeToScene();
		stageMenuP.setTitle("Menu Options Priority Queue");
		/*
		FXMLLoader fLMenuP = new FXMLLoader(getClass().getResource("MenuPOptions.fxml"));
		fLMenuP.setController(this);
		Parent paneMenuOptionsP;
		paneMenuOptionsP = fLMenuP.load();
		Scene sceneMenuP = new Scene(paneMenuOptionsP);
		sceneMenuP.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm());
		Stage stageMenuP = new Stage();
		stageMenuP.setScene(sceneMenuP);
		stageMenuP.show();
		
		*/
		/*
		 * FXMLLoader f= new FXMLLoader(getClass().getResource("CreateUser1.fxml"));
		 * f.setController(this); Parent root= f.load(); Stage st=new Stage();
		 * 
		 * sc.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm()); 
		 * st.initModality(Modality.APPLICATION_MODAL);
		 * st.initStyle(StageStyle.DECORATED); st.setScene(sc);
		 * 
		 * st.show();
		 * 
		 */
	}

	// create User 2
	@FXML
	void nextUser(ActionEvent event) throws IOException, ValuesIsEmptyException {
		if(txtName.getText()==" "||txtLastName.getText()==" "||txtIDaddUser.getText()==" ") {
			throw new ValuesIsEmptyException();
		}
		try {
			Integer.parseInt(txtIDaddUser.getText());
			FXMLLoader fL = new FXMLLoader(getClass().getResource("createUser2.fxml"));
			fL.setController(this);
			Parent pane;
			pane = fL.load();
			myPane.getChildren().clear();
			myPane.setCenter(pane);
		}catch(NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("BANK");
			alert.setContentText("Datos en formato no valido");
			alert.showAndWait();
		}
		
		
	

	}
    @FXML
    void tgTarjetAhorroCreateAction(ActionEvent event) {
    	if(tgTarjetAhorroCreate.isSelected()) {
    		
    	}
    }


	// Create user 1

	@FXML
	void addUser(ActionEvent event) throws IOException {
		
		

		FXMLLoader fL = new FXMLLoader(getClass().getResource("CreateUser1.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
		cbLevelPriorirty.getItems().removeAll(cbLevelPriorirty.getItems());
		cbLevelPriorirty.getItems().addAll("0","1","2","3");
		cbLevelPriorirty.getSelectionModel().select("0");

	}

	// radio buttons de los tipo de clientes y tipo de tarjtea
	
	   @FXML
	    private RadioButton tgTarjetCreditCreate;

	
	    @FXML
	    private RadioButton tgTarjetAhorroCreate;
	    
	    
	
	    
	    @FXML
	    private ComboBox<String> cbLevelPriorirty;
	    
	// BOTON PARA CREAR LOS USUARIOS
	    
	@FXML
	void createUser(ActionEvent event) throws IOException, ValuesIsEmptyException, UserAlreadyExistException {
		
		
		String name = txtName.getText();
		String lastname = txtLastName.getText();
		String id = txtIDaddUser.getText();
		String clientType  =cbLevelPriorirty.getValue() ;  // nivel d prioridad desde 0 hasta 3.
		
		boolean tarjetAhorros= tgTarjetAhorroCreate.isSelected();
		boolean tarjetCredito= tgTarjetCreditCreate.isSelected();
		if((!tarjetAhorros && !tarjetCredito) || txtIdTarjet.getText()==" ") {
			throw new ValuesIsEmptyException();
		}
		try {
			
		}catch(NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("EMPTY");
			alert.setHeaderText("BANK");
			alert.setContentText("Formato de valores incorrecto");

			alert.showAndWait();
		}
		String idTarjet= txtIdTarjet.getText();
		if(!tarjetAhorros) {
			txtamountCreate.setText("0");
		}
		Double amountAccount = Double.parseDouble(txtamountCreate.getText());
		
		boolean confirm = bank.addClient(name, lastname, id, clientType, idTarjet, amountAccount);
		
		FXMLLoader fL = new FXMLLoader(getClass().getResource("turnoInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
		if(confirm) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("EXITO");
			alert.setHeaderText("Cliente registrado con exito");
			alert.showAndWait();
		}else {
			throw new UserAlreadyExistException();
		}
		
		
	}

	// interfaz de busqueda

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

		FXMLLoader fL = new FXMLLoader(getClass().getResource("InformationUserInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);

	}

	// Interfaz de informaacion de usuario

	@FXML
	private TextField txtNameUser;

	@FXML
	private TextField txtLastNameUser;

	@FXML
	private TextField txtIDuser;

	@FXML
	private TextField txtAccountBankUser;

	@FXML
	private RadioButton tgTarjetDebitUser;

	@FXML
	private ToggleGroup TypeTarjetUserTG;

	@FXML
	private RadioButton tgTarjetCreditUser;

	@FXML
	private DatePicker txtDayPayUser;

	@FXML
	private DatePicker txtDayAccesBankUser;

	@FXML
	private Button btAtrasInformationUser;

	@FXML
	private Button btInformationTable;

	@FXML
	void loadMenuOptionsINformationUser(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
	}

	@FXML
	void loadTableInformationUser(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("TableInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
	}

	@FXML
	void loadInformationClient(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
		/*
		 * FXMLLoader fxmlLoader = new
		 * FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		 * fxmlLoader.setController(this); Parent root1 = (Parent) fxmlLoader.load();
		 * Stage stage = new Stage(); stage.setScene(new Scene(root1)); stage.show();
		 */
	}

	// Interfaz de Tabla de ordenamientos

	@FXML
	private TableView<?> Table1;

	@FXML
	private TableColumn<?, ?> TcNombre;

	@FXML
	private TableColumn<?, ?> TcCedula;

	@FXML
	private TableColumn<?, ?> TcVinculacion;

	@FXML
	private TableColumn<?, ?> TcMonto;

	@FXML
	private Button BtSelecition;

	@FXML
	private Button btHeapsort;

	@FXML
	private Button btMergesort;

	@FXML
	private Button btquicksort;

	@FXML
	private Button btatrasTable;

	@FXML
	void atrasTableInterface(ActionEvent event) throws IOException {

		FXMLLoader fL = new FXMLLoader(getClass().getResource("SearchID.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);

	}

	@FXML
	void LoadMergesort(ActionEvent event) {

	}

	@FXML
	void loadHeapsort(ActionEvent event) {

	}

	@FXML
	void loadQuikcsort(ActionEvent event) {

	}

	@FXML
	void loadSelectionSort(ActionEvent event) {

	}

	// interfaz prioriatria de turno

	@FXML
	private Button btOptionUser;

	@FXML
	private TextField txtStackNormal;

	@FXML
	private TextField txtStackPriority;

	@FXML
	private Button btnextTurn;

	// reporte de turnos fila normal y prioritaria
	@FXML
	void createShift(ActionEvent event) throws IOException, UserDoesNotExistException {
		boolean assigned = bank.assingShift(txtName1.getText(), txtid1.getText());
		if(assigned) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Shift assigned correcly");
			alert.show();
		}else {
			throw new UserDoesNotExistException();
		}
	}

	// carga el menu de opciones de la inerfaz de turno para devolverse

	@FXML
	void loadMenuOptions(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
		System.out.println("entre");
	}

	// Interfaz menu de opciones.
	@FXML
	private Button BtSearchInformationUser;

	@FXML
	private Button btconsignacion;

	@FXML
	private Button btPagoTarjeta;

	@FXML
	private Button btRetiro;

	@FXML
	private Button btCancelAccount;

	@FXML
	private Button btBacktoShift;

	@FXML
	void loadCancelAcount(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("CancelAccountInter.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);

	}

	@FXML
	void loadConsignation(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("ConsignmentInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
	}

	@FXML
	void loadPayTarjet(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("PayTarjetInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
	}

	@FXML
	void loadRetirement(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("RetirementInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
	}

	@FXML
	void loadbacktoinit(ActionEvent event) throws IOException {

		FXMLLoader fL = new FXMLLoader(getClass().getResource("turnoInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
		System.out.println("entre");

	}

	@FXML
	void loadSearchUser(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("SearchID.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPane.getChildren().clear();
		menuOptionsPane.setCenter(pane);
	}

	// undo

	@FXML
	void undoAction(ActionEvent event) {
		int confirm = 0;
		JOptionPane.showConfirmDialog(null, "¿Deshacer cambios?");

		if (JOptionPane.OK_OPTION == confirm)
			System.out.println("confirmado");
		else
			System.out.println("Seguir normal");
	}

	// interfaz de Retiro

	@FXML
	private TextField txtAmount;

	@FXML
	private TextField txtRetirement;

	@FXML
	private Button btpreviousRetirement;

	@FXML
	private Button btConfirmRetirement;

	@FXML
	void loadMenuRetirement(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
	}

	@FXML
	void retirementAction(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "Retiro Confirmada");
	}

	// interfaz de pago de tarjeta

	@FXML
	private TextField txtAmountPay;

	@FXML
	private RadioButton rbEfective;

	@FXML
	private ToggleGroup tgTypePay;

	@FXML
	private RadioButton rbAC;

	@FXML
	private Button btpreviousPay;

	@FXML
	void confirmPay(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "Pago Confirmado");
	}

	@FXML
	void loadMenuPay(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
	}

	// Interfaz de consignacion

	@FXML
	private TextField txtMoneytoConsinement;

	@FXML
	private TextField txtIDAccountConsignement;

	@FXML
	private Button btConsignementBill;

	@FXML
	private Button btPreviousConsignemeent;

	@FXML
	void consignationAction(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "Consignacion Confirmada");
	}

	@FXML
	void loadMenuConsignation(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
	}

	// Interfaz Cancel account

	@FXML
	private Button btConfirnCancel;

	@FXML
	private TextArea txtAreaMotiveofCancel;

	@FXML
	private DatePicker txtDayofcancelation;

	@FXML
	private Button btPreviuosCancel;

	@FXML
	void cancelAccountAction(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "Cancelacion Confirmada");
		System.out.println("CANCELACION CONFIRMADA");
	}

	@FXML
	void loadMenuCancel(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
	}
	//MenuOptionesPriority
	@FXML
    void loadCancelAcountP(ActionEvent event) {

    }

    @FXML
    void loadConsignationP(ActionEvent event) {

    }

    @FXML
    void loadPayTarjetP(ActionEvent event) {

    }

    @FXML
    void loadRetirementP(ActionEvent event) {

    }

    @FXML
    void loadSearchUserP(ActionEvent event) throws IOException {
    	FXMLLoader fL = new FXMLLoader(getClass().getResource("SearchID.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuPOptionsPane.getChildren().clear();
		menuPOptionsPane.setCenter(pane);
    }

    @FXML
    void undoActionP(ActionEvent event) {

    }

}
