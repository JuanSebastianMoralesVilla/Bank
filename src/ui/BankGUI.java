package ui;

import customExceptions.NoUserException;
import customExceptions.UserAlreadyExistException;

import customExceptions.UserDoesNotExistException;
import customExceptions.ValuesIsEmptyException;
import data_structures.ListSorts;

import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
import javafx.scene.control.cell.PropertyValueFactory;
import model.Bank;
import model.Client;
import model.Tarjet;

public class BankGUI {

	private Bank bank;
	private Client normalClient;
	private Client priorityClient;
	
	//InnfoUserP
    @FXML
    private Button nextUserP;

    @FXML
    private Button nextuser;

    @FXML
    private TextField txtNameUserP;

    @FXML
    private TextField txtLastNameUserP;

    @FXML
    private TextField txtIDuserP;

    @FXML
    private TextField txtAccountBankUserP;

    @FXML
    private RadioButton tgTarjetDebitUserP;

    @FXML
    private RadioButton tgTarjetCreditUserP;

    @FXML
    private DatePicker txtDayPayUserP;

    @FXML
    private DatePicker txtDayAccesBankUserP;

    @FXML
    private Button btAtrasInformationUserP;

    @FXML
    private Button btInformationTableP;

	
	//SeachIDP
	   @FXML
	    private Button btSearchP;

	    @FXML
	    private TextField txtidP;

	    @FXML
	    private Button btAtrasSearchP;
	    	
	@FXML
    private Label currentShift;
	//Shift Screen 
    @FXML
    private Label txtNormalQueue;

    @FXML
    private Label txtPriorityQueue;

	// Elements of interface
    
    private BorderPane menuOptionsPane;
    private BorderPane menuOptionsPaneP;
	@FXML
	private BorderPane myPane;

	@FXML
	private Button btInit;

	/// fxml de la creacion de clientes

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
	
	//Table
    @FXML
    private ComboBox<String> cbSortValue;

    @FXML
    private CheckBox isAcending;

    @FXML
    private Button btnDisorder;
    
    @FXML
    private Label labelTime;

    Stage window;
//Constructor

	public BankGUI(Stage stage, Bank bank) {
		normalClient=null;
		priorityClient=null;
		this.bank = bank;
		this.window =stage;
		menuOptionsPane = new BorderPane();
		menuOptionsPaneP = new BorderPane();
	}

	public void init(ActionEvent event) throws IOException {
		
		FXMLLoader fL = new FXMLLoader(getClass().getResource("turnoInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
		window.setY(window.getY()-100);
		
		
		FXMLLoader fL2 = new FXMLLoader(getClass().getResource("reportQueue.fxml"));
		fL2.setController(this);
		Parent paneShowShifts;
		paneShowShifts = fL2.load();
		Scene scene = new Scene(paneShowShifts);
		scene.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm());
		Stage stageShowShifts = new Stage();
		paneShowShifts.setLayoutY(paneShowShifts.getLayoutY()-scene.getHeight());
		stageShowShifts.setScene(scene);
		stageShowShifts.show();
		stageShowShifts.centerOnScreen();
		stageShowShifts.setY(stageShowShifts.getY()+scene.getHeight());
		
		
		
		
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
		paneMenuOptions.setLayoutX(paneMenuOptions.getLayoutX()-sceneMenu.getWidth());
		stageMenu.centerOnScreen();
		stageMenu.setX(stageMenu.getX()-sceneMenu.getWidth());
		
		
		Scene sceneMenuP = new Scene(menuOptionsPaneP);
		sceneMenuP.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm());
		Stage stageMenuP = new Stage();
		stageMenuP.setScene(sceneMenuP);
		stageMenuP.show();
		
		FXMLLoader fLMenuP = new FXMLLoader(getClass().getResource("MenuOptionsP.fxml"));
		fLMenuP.setController(this);
		Parent paneMenuPOptions = fLMenuP.load();
		menuOptionsPaneP.getChildren().clear();
		menuOptionsPaneP.setCenter(paneMenuPOptions);
		
		stageMenuP.sizeToScene();
		stageMenuP.setTitle("Menu Options Priority Queue");
		stageMenuP.centerOnScreen();
		stageMenuP.setX(stageMenuP.getX()+sceneMenuP.getWidth());
		
		
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
		String tarjetType  = " ";  // nivel d prioridad desde 0 hasta 3.
		
		boolean tarjetAhorros= tgTarjetAhorroCreate.isSelected();
		boolean tarjetCredito= tgTarjetCreditCreate.isSelected();
		if((!tarjetAhorros && !tarjetCredito) || txtIdTarjet.getText()==" ") {
			throw new ValuesIsEmptyException();
		}else {
			if(tarjetAhorros&&tarjetCredito) {
				tarjetType = Tarjet.BOTH;
			}else if(tarjetAhorros){
				tarjetType = Tarjet.AHORROS;
			}else {
				tarjetType = Tarjet.CREDIT;
			}
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
		int level = Integer.parseInt(cbLevelPriorirty.getValue());
		boolean confirm = bank.addClient(name, lastname, id,level, tarjetType, idTarjet, amountAccount);
		
		
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
		menuOptionsPane.getChildren().clear();
		menuOptionsPane.setCenter(pane);
		
	}
		
	@FXML
	void loadTableInformationUser(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("TableInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPane.getChildren().clear();
		menuOptionsPane.setCenter(pane);
		ObservableList<Client> observableList;
		cbSortValue.getItems().removeAll(cbSortValue.getItems());
		cbSortValue.getItems().addAll(Client.NAME,Client.ID,Client.DATE,Client.AMOUNT);
		cbSortValue.getSelectionModel().select(Client.NAME);
		observableList = FXCollections.observableArrayList(bank.sortList("Unsorted", Client.NAME, true));
		Table1.setItems(observableList);
		
		TcCedula.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		TcNombre.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		TcVinculacion.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dateJoinedBank"));
		TcMonto.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
		
	}

	@FXML
	void loadInformationClient(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
		
	}

	// Interfaz de Tabla de ordenamientos

	@FXML
	private TableView<Client> Table1;

	@FXML
	private TableColumn<Client, String> TcNombre;

	@FXML
	private TableColumn<Client, String> TcCedula;

	@FXML
	private TableColumn<Client,LocalDate> TcVinculacion;

	@FXML
	private TableColumn<Client, Double> TcMonto;

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

		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPane.getChildren().clear();
		menuOptionsPane.setCenter(pane);

	}

	@FXML
	void LoadMergesort(ActionEvent event) {
		double initialTime = System.currentTimeMillis();
		boolean ascendancy = isAcending.isSelected();
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(bank.sortList(ListSorts.MERGE, cbSortValue.getValue(), ascendancy));
		Table1.setItems(observableList);
		
		TcCedula.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		TcNombre.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		TcVinculacion.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dateJoinedBank"));
		TcMonto.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
		double finalTime = System.currentTimeMillis();
		labelTime.setText((finalTime-initialTime)/1000+"sg");
	}

	@FXML
	void loadHeapsort(ActionEvent event) {
		double initialTime = System.currentTimeMillis();
		boolean ascendancy = isAcending.isSelected();
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(bank.sortList(ListSorts.HEAP, cbSortValue.getValue(), ascendancy));
		Table1.setItems(observableList);
		
		TcCedula.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		TcNombre.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		TcVinculacion.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dateJoinedBank"));
		TcMonto.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
		double finalTime = System.currentTimeMillis();
		labelTime.setText((finalTime-initialTime)/1000+"sg");
	}

	@FXML
	void loadQuikcsort(ActionEvent event) {
		double initialTime = System.currentTimeMillis();
		boolean ascendancy = isAcending.isSelected();
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(bank.sortList(ListSorts.QUICK, cbSortValue.getValue(), ascendancy));
		Table1.setItems(observableList);
		
		TcCedula.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		TcNombre.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		TcVinculacion.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dateJoinedBank"));
		TcMonto.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
		double finalTime = System.currentTimeMillis();
		labelTime.setText((finalTime-initialTime)/1000+"sg");
	}

	@FXML
	void loadSelectionSort(ActionEvent event) {
		double initialTime = System.currentTimeMillis();
		boolean ascendancy = isAcending.isSelected();
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(bank.sortList(ListSorts.SELECTION, cbSortValue.getValue(), ascendancy));
		Table1.setItems(observableList);
		
		TcCedula.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		TcNombre.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		TcVinculacion.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dateJoinedBank"));
		TcMonto.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
		double finalTime = System.currentTimeMillis();
		labelTime.setText((finalTime-initialTime)/1000+"sg");
	}
	@FXML
    void btnDisorder(ActionEvent event) {
		boolean ascendancy = isAcending.isSelected();
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(bank.sortList("Unsorted", "unsorted", ascendancy));
		Table1.setItems(observableList);
		
		TcCedula.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		TcNombre.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		TcVinculacion.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dateJoinedBank"));
		TcMonto.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
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
			if(normalClient==null) {
				nextuser(event);
			}
			if(priorityClient==null) {
				nextUserP(event);
			}
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
		if(normalClient!=null) {
			FXMLLoader fL = new FXMLLoader(getClass().getResource("CancelAccountInter.fxml"));
			fL.setController(this);
			Parent pane;
			pane = fL.load();
			menuOptionsPane.getChildren().clear();
			menuOptionsPane.setCenter(pane);
			txtDayofcancelation.setValue(LocalDate.now());
		}
	}

	@FXML
	void loadConsignation(ActionEvent event) throws IOException {
		if(normalClient!=null) {
			if(!normalClient.getTarjet().getType().equals(Tarjet.CREDIT)) {
				FXMLLoader fL = new FXMLLoader(getClass().getResource("ConsignmentInterface.fxml"));
				fL.setController(this);
				Parent pane;
				pane = fL.load();
				menuOptionsPane.getChildren().clear();
				menuOptionsPane.setCenter(pane);
				txtIDAccountConsignement.setText(normalClient.getTarjet().getIdAccount());
			}
		}
	}

	@FXML
	void loadPayTarjet(ActionEvent event) throws IOException {
		if(normalClient!=null) {
			if(!normalClient.getTarjet().getType().equals(Tarjet.AHORROS)) {
				FXMLLoader fL = new FXMLLoader(getClass().getResource("PayTarjetInterface.fxml"));
				fL.setController(this);
				Parent pane;
				pane = fL.load();
				menuOptionsPane.getChildren().clear();
				menuOptionsPane.setCenter(pane);
			}
		}
	}

	@FXML
	void loadRetirement(ActionEvent event) throws IOException {
		if(normalClient!=null) {
			if(!normalClient.getTarjet().getType().equals(Tarjet.CREDIT)) {
				FXMLLoader fL = new FXMLLoader(getClass().getResource("RetirementInterface.fxml"));
				fL.setController(this);
				Parent pane;
				pane = fL.load();
				menuOptionsPane.getChildren().clear();
				menuOptionsPane.setCenter(pane);
				txtAmount.setText(normalClient.getAmount()+"");
			}
		}
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
		if(normalClient!=null) {
			FXMLLoader fL = new FXMLLoader(getClass().getResource("informationUserInterface.fxml"));
			fL.setController(this);
			Parent pane;
			pane = fL.load();
			menuOptionsPane.getChildren().clear();
			menuOptionsPane.setCenter(pane);
			txtNameUser.setText(normalClient.getName());
			txtLastNameUser.setText(normalClient.getLastName());
			txtIDuser.setText(normalClient.getId());
			txtAccountBankUser.setText(normalClient.getTarjet().getIdAccount());
			if(normalClient.getTarjet().getType().equals(Tarjet.AHORROS)||normalClient.getTarjet().getType().equals(Tarjet.BOTH)) {
				tgTarjetDebitUser.setSelected(true);
			}
			if(normalClient.getTarjet().getType().equals(Tarjet.CREDIT)||normalClient.getTarjet().getType().equals(Tarjet.BOTH)) {
				tgTarjetCreditUser.setSelected(true);
			}
			txtDayPayUser.setValue(normalClient.getTarjet().getDateUpdateCredit());
			txtDayAccesBankUser.setValue(normalClient.getDateJoinedBank());
		}
		
	}

	// undo

	@FXML
	void undoAction(ActionEvent event) {
		int confirm = 0;
		JOptionPane.showConfirmDialog(null, "¿Deshacer cambios?");

		if (JOptionPane.OK_OPTION == confirm) {
			bank.undo(false);
		}else
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
		menuOptionsPane.getChildren().clear();
		menuOptionsPane.setCenter(pane);
	}

	@FXML
	void retirementAction(ActionEvent event) throws ValuesIsEmptyException, NoUserException, IOException {
		if(txtRetirement.getText().isEmpty()) {
			throw new ValuesIsEmptyException();
		}
		try {
			double amount = Double.parseDouble(txtRetirement.getText());
			if(amount<=normalClient.getAmount()) {
				bank.retirement(amount, normalClient.getId());
				JOptionPane.showMessageDialog(null, "Retiro Confirmada");
			}else {
				JOptionPane.showMessageDialog(null, "No hay dinero suficiente");
			}
			loadMenuRetirement(event);
		}catch(NumberFormatException e) {
			throw new ValuesIsEmptyException();
		}
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
	void confirmPay(ActionEvent event) throws ValuesIsEmptyException, IOException {
		if(txtAmountPay.getText().isEmpty() || (!rbEfective.isSelected()&&!rbAC.isSelected())) {
			throw new ValuesIsEmptyException();
		}
			
		try{
			double amount = Double.parseDouble(txtAmountPay.getText());
			if(rbAC.isSelected()) {
				if(amount<=normalClient.getAmount()) {
					JOptionPane.showMessageDialog(null, "Pago Confirmado");
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setHeaderText("No tiene sufuciente dinero");
					alert.show();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Pago Confirmado");
			}
			loadMenuPay(event);
		}catch(NumberFormatException e) {
			throw new ValuesIsEmptyException();
		}
	}

	@FXML
	void loadMenuPay(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPane.getChildren().clear();
		menuOptionsPane.setCenter(pane);
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
	void consignationAction(ActionEvent event) throws ValuesIsEmptyException, NoUserException, IOException {
		String value = txtMoneytoConsinement.getText();
		double amount=0;
		if(value=="") {
			throw new ValuesIsEmptyException();
		}
		try {
			amount = Double.parseDouble(value);
			double valueActual=bank.consignment(amount, normalClient.getId());
			JOptionPane.showMessageDialog(null, "Consignacion Confirmada, su saldo actual es: "+valueActual);
		}catch(NumberFormatException e) {
			throw new ValuesIsEmptyException();
		}
		loadMenuConsignation(event);
		
	}

	@FXML
	void loadMenuConsignation(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPane.getChildren().clear();
		menuOptionsPane.setCenter(pane);
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
	void cancelAccountAction(ActionEvent event) throws ValuesIsEmptyException, IOException {
		if(txtAreaMotiveofCancel.getText().isEmpty()) {
			throw new ValuesIsEmptyException();
		}
		boolean delated =bank.cancelAccount(normalClient.getId(), txtAreaMotiveofCancel.getText());
		if(delated) {
			JOptionPane.showMessageDialog(null, "Cancelacion Confirmada");
			
		}else {
			JOptionPane.showMessageDialog(null, "Usuario no existente");
		}
		
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPane.getChildren().clear();
		menuOptionsPane.setCenter(pane);
		nextuser(event);
	}

	@FXML
	void loadMenuCancel(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPane.getChildren().clear();
		menuOptionsPane.setCenter(pane);
	}
	//MenuOptionesPriority
	
	
	
	
	
	
	
	
	
	
	
//  interfaz de CancelAccounterInterP prioritaria 
	
    @FXML
    private Button btConfirnCancelP;

    @FXML
    private TextArea txtAreaMotiveofCancelP;

    @FXML
    private DatePicker txtDayofcancelationP;

    @FXML
    private Button btPreviuosCancelP;

    @FXML
    void cancelAccountActionP(ActionEvent event) throws ValuesIsEmptyException, IOException {
    	if(txtAreaMotiveofCancelP.getText().isEmpty()) {
			throw new ValuesIsEmptyException();
		}
		boolean delated = bank.cancelAccount(priorityClient.getId(), txtAreaMotiveofCancelP.getText());
		if(delated) {
			JOptionPane.showMessageDialog(null, "Cancelacion Confirmada");
			System.out.println("CANCELACION CONFIRMADA");
		}else{
			JOptionPane.showMessageDialog(null, "Este usuario no existe");
		}
		
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptionsP.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPaneP.getChildren().clear();
		menuOptionsPaneP.setCenter(pane);
		nextUserP(event);
		
    }

    @FXML
    void loadMenuCancelP(ActionEvent event) throws IOException {
    	FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptionsP.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPaneP.getChildren().clear();
		menuOptionsPaneP.setCenter(pane);
		
    }
  

    
    // interfaz consignacion prioritaria 
    
    
    @FXML
    private TextField txtMoneytoConsinementP;

    @FXML
    private TextField txtIDAccountConsignementP;

    @FXML
    private Button btConsignementBillP;

    @FXML
    private Button btPreviousConsignemeentP;

    @FXML
    void consignationActionP(ActionEvent event) throws ValuesIsEmptyException, NoUserException, IOException {
    	String value = txtMoneytoConsinementP.getText();
		double amount=0;
		if(value=="") {
			throw new ValuesIsEmptyException();
		}
		try {
			amount = Double.parseDouble(value);
			double valueActual=bank.consignment(amount, priorityClient.getId());
			JOptionPane.showMessageDialog(null, "Consignacion Confirmada, su saldo actual es: "+valueActual);
		}catch(NumberFormatException e) {
			throw new ValuesIsEmptyException();
		}
		loadMenuConsignationP(event);
    }

    @FXML
    void loadMenuConsignationP(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptionsP.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPaneP.getChildren().clear();
		menuOptionsPaneP.setCenter(pane);
		
    }
    
    
  // interfa pago de tarjeta prioritaria 
    
    
    @FXML
    private TextField txtAmountPayP;

    @FXML
    private RadioButton rbEfectiveP;

    @FXML
    private ToggleGroup tgTypePayP;

    @FXML
    private RadioButton rbACP;

    @FXML
    private Button btpreviousPayP;

    @FXML
    void confirmPayP(ActionEvent event) throws ValuesIsEmptyException, IOException {
    	if(txtAmountPayP.getText().isEmpty() || (!rbEfectiveP.isSelected()&&!rbACP.isSelected())) {
			throw new ValuesIsEmptyException();
		}
			
		try{
			double amount = Double.parseDouble(txtAmountPayP.getText());
			if(rbACP.isSelected()) {
				if(amount<=priorityClient.getAmount()) {
					JOptionPane.showMessageDialog(null, "Pago Confirmado");
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setHeaderText("This user does not have enough money");
					alert.show();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Pago Confirmado");
			}
			
		}catch(NumberFormatException e) {
			throw new ValuesIsEmptyException();
		}
		loadMenuPayP(event);
	}
    

    @FXML
    void loadMenuPayP(ActionEvent event) throws IOException {
    	FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptionsP.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPaneP.getChildren().clear();
		menuOptionsPaneP.setCenter(pane);
		
    }

    
    // RETIRO PRIORITARIO
    
    @FXML
    private TextField txtAmountP;

    @FXML
    private TextField txtRetirementP;

    @FXML
    private Button btpreviousRetirementP;

    @FXML
    private Button btConfirmRetirementP;

    @FXML
    void loadMenuRetirementP(ActionEvent event) throws IOException {
    	FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptionsP.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPaneP.getChildren().clear();
		menuOptionsPaneP.setCenter(pane);
    }

    @FXML
    void retirementActionP(ActionEvent event) throws ValuesIsEmptyException, NoUserException, IOException {
		if(txtRetirementP.getText().isEmpty()) {
			throw new ValuesIsEmptyException();
		}
		try {
			double amount = Double.parseDouble(txtRetirementP.getText());
			if(amount<=priorityClient.getAmount()) {
				bank.retirement(amount, priorityClient.getId());
				JOptionPane.showMessageDialog(null, "Retiro Confirmada");
			}
			
		}catch(NumberFormatException e) {
			throw new ValuesIsEmptyException();
		}
		loadMenuRetirementP(event);
    }
   
    
    
    // MENU DE OPCIONES PRIOTARIO CAMBIO DE FUNCIONES
    
    
    
    
    
    @FXML
	void loadCancelAcountP(ActionEvent event) throws IOException {
    	if(priorityClient!=null) {
    		FXMLLoader fL = new FXMLLoader(getClass().getResource("CancelAccountInterP.fxml"));
    		fL.setController(this);
    		Parent pane;
    		pane = fL.load();
    		menuOptionsPaneP.getChildren().clear();
    		menuOptionsPaneP.setCenter(pane);
    		
    		txtDayofcancelationP.setValue(LocalDate.now());
    	}
	}

	@FXML
	void loadConsignationP(ActionEvent event) throws IOException {
		if(priorityClient!=null) {
			if(!priorityClient.getTarjet().getType().equals(Tarjet.CREDIT)) {
				FXMLLoader fL = new FXMLLoader(getClass().getResource("ConsignmentInterfaceP.fxml"));
				fL.setController(this);
				Parent pane;
				pane = fL.load();
				menuOptionsPaneP.getChildren().clear();
				menuOptionsPaneP.setCenter(pane);
				
				txtIDAccountConsignementP.setText(priorityClient.getTarjet().getIdAccount());
			}
		}
	}

	@FXML
	void loadPayTarjetP(ActionEvent event) throws IOException {
		if(priorityClient!=null) {
			if(!priorityClient.getTarjet().getType().equals(Tarjet.AHORROS)) {
				FXMLLoader fL = new FXMLLoader(getClass().getResource("PayTarjetInterfaceP.fxml"));
				fL.setController(this);
				Parent pane;
				pane = fL.load();
				menuOptionsPaneP.getChildren().clear();
				menuOptionsPaneP.setCenter(pane);
			}
		}
	}

	@FXML
	void loadRetirementP(ActionEvent event) throws IOException {
		if(priorityClient!=null) {
			if(!priorityClient.getTarjet().getType().equals(Tarjet.CREDIT)) {
				FXMLLoader fL = new FXMLLoader(getClass().getResource("RetirementInterfaceP.fxml"));
				fL.setController(this);
				Parent pane;
				pane = fL.load();
				menuOptionsPaneP.getChildren().clear();
				menuOptionsPaneP.setCenter(pane);
				txtAmountP.setText(priorityClient.getAmount()+"");
			}
		}
	}
    
    
    @FXML
    void loadSearchUserP(ActionEvent event) throws IOException {
    	if(priorityClient!=null) {
			FXMLLoader fL = new FXMLLoader(getClass().getResource("informationUserInterfaceP.fxml"));
			fL.setController(this);
			Parent pane;
			pane = fL.load();
			menuOptionsPaneP.getChildren().clear();
			menuOptionsPaneP.setCenter(pane);
			txtNameUserP.setText(priorityClient.getName());
			txtLastNameUserP.setText(priorityClient.getLastName());
			txtIDuserP.setText(priorityClient.getId());
			txtAccountBankUserP.setText(priorityClient.getTarjet().getIdAccount());
			if(priorityClient.getTarjet().getType().equals(Tarjet.AHORROS)||priorityClient.getTarjet().getType().equals(Tarjet.BOTH)) {
				tgTarjetDebitUserP.setSelected(true);
			}
			if(priorityClient.getTarjet().getType().equals(Tarjet.CREDIT)||priorityClient.getTarjet().getType().equals(Tarjet.BOTH)) {
				tgTarjetCreditUserP.setSelected(true);
			}
			txtDayPayUserP.setValue(priorityClient.getTarjet().getDateUpdateCredit());
			txtDayAccesBankUserP.setValue(priorityClient.getDateJoinedBank());
		}
    }

    @FXML
    void undoActionP(ActionEvent event) {
    	int confirm = 0;
		JOptionPane.showConfirmDialog(null, "¿Deshacer cambios?");

		if (JOptionPane.OK_OPTION == confirm) {
			bank.undo(true);
		}else
			System.out.println("Seguir normal");
    }
    //SearchIDP
    @FXML
    void btAtrasP(ActionEvent event) throws IOException {
    	FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuPOptions.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPaneP.getChildren().clear();
		menuOptionsPaneP.setCenter(pane);
    }

    @FXML
    void btSearchIDtoOptionsP(ActionEvent event) throws ValuesIsEmptyException {
    	if(txtidP.getText()=="") {
    		throw new ValuesIsEmptyException();
    	}else {
    		
    	}
    }
    
    // INTERFAZ DE TABLA 
	@FXML
	private TableView<Client> TableP;

	@FXML
	private TableColumn<Client, String> TcNombreP;

	@FXML
	private TableColumn<Client, String> TcCedulaP;

	@FXML
	private TableColumn<Client,LocalDate> TcVinculacionP;

	@FXML
	private TableColumn<Client, Double> TcMontoP;

    @FXML
    private Button BtSelecitionP;

    @FXML
    private Button btHeapsortP;

    @FXML
    private Button btMergesortP;

    @FXML
    private Button btquicksortP;

    @FXML
    private Button btatrasTableP;

    @FXML
    private ComboBox<String> cbSortValueP;

    @FXML
    private CheckBox isAcendingP;

    @FXML
    private Button btnDisorderP;

    @FXML
    private Label labelTimeP;
    
    @FXML
    void loadMenuOptionsINformationUserP(ActionEvent event) throws IOException {
    	FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptionsP.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPaneP.getChildren().clear();
		menuOptionsPaneP.setCenter(pane);
    }

    @FXML
    void loadTableInformationUserP(ActionEvent event) throws IOException {
    	
    	FXMLLoader fL = new FXMLLoader(getClass().getResource("TableInterfaceP.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPaneP.getChildren().clear();
		menuOptionsPaneP.setCenter(pane);
		ObservableList<Client> observableList;
		cbSortValueP.getItems().removeAll(cbSortValueP.getItems());
		cbSortValueP.getItems().addAll(Client.NAME,Client.ID,Client.DATE,Client.AMOUNT);
		cbSortValueP.getSelectionModel().select(Client.NAME);
		observableList = FXCollections.observableArrayList(bank.sortList("Unsorted", Client.NAME, true));
		TableP.setItems(observableList);
		
		TcCedulaP.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		TcNombreP.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		TcVinculacionP.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dateJoinedBank"));
		TcMontoP.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
		
    }
    
    // TABLA P 

    @FXML
    void LoadMergesortP(ActionEvent event) {
    	double initialTime = System.currentTimeMillis();
		boolean ascendancy = isAcendingP.isSelected();
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(bank.sortList(ListSorts.MERGE, cbSortValueP.getValue(), ascendancy));
		TableP.setItems(observableList);
		
		TcCedulaP.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		TcNombreP.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		TcVinculacionP.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dateJoinedBank"));
		TcMontoP.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
		double finalTime = System.currentTimeMillis();
		labelTimeP.setText((finalTime-initialTime)/1000+"sg");
    }

    @FXML
    void atrasTableInterfaceP(ActionEvent event) throws IOException {
    	FXMLLoader fL = new FXMLLoader(getClass().getResource("MenuOptionsP.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		menuOptionsPaneP.getChildren().clear();
		menuOptionsPaneP.setCenter(pane);
    }

    @FXML
    void btnDisorderP(ActionEvent event) {
    	boolean ascendancy = isAcendingP.isSelected();
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(bank.sortList("Unsorted", "unsorted", ascendancy));
		TableP.setItems(observableList);
		
		TcCedulaP.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		TcNombreP.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		TcVinculacionP.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dateJoinedBank"));
		TcMontoP.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
    }

    @FXML
    void loadHeapsortP(ActionEvent event) {
    	double initialTime = System.currentTimeMillis();
		boolean ascendancy = isAcendingP.isSelected();
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(bank.sortList(ListSorts.HEAP, cbSortValueP.getValue(), ascendancy));
		TableP.setItems(observableList);
		
		TcCedulaP.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		TcNombreP.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		TcVinculacionP.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dateJoinedBank"));
		TcMontoP.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
		double finalTime = System.currentTimeMillis();
		labelTimeP.setText((finalTime-initialTime)/1000+"sg");
    }

    @FXML
    void loadQuikcsortP(ActionEvent event) {
    	double initialTime = System.currentTimeMillis();
		boolean ascendancy = isAcendingP.isSelected();
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(bank.sortList(ListSorts.QUICK, cbSortValueP.getValue(), ascendancy));
		TableP.setItems(observableList);
		
		TcCedulaP.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		TcNombreP.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		TcVinculacionP.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dateJoinedBank"));
		TcMontoP.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
		double finalTime = System.currentTimeMillis();
		labelTimeP.setText((finalTime-initialTime)/1000+"sg");
    }

    @FXML
    void loadSelectionSortP(ActionEvent event) {
    	double initialTime = System.currentTimeMillis();
		boolean ascendancy = isAcendingP.isSelected();
		ObservableList<Client> observableList;
		observableList = FXCollections.observableArrayList(bank.sortList(ListSorts.SELECTION, cbSortValueP.getValue(), ascendancy));
		TableP.setItems(observableList);
		
		TcCedulaP.setCellValueFactory(new PropertyValueFactory<Client, String>("id"));
		TcNombreP.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
		TcVinculacionP.setCellValueFactory(new PropertyValueFactory<Client, LocalDate>("dateJoinedBank"));
		TcMontoP.setCellValueFactory(new PropertyValueFactory<Client, Double>("amount"));
		double finalTime = System.currentTimeMillis();
		labelTimeP.setText((finalTime-initialTime)/1000+"sg");
    }
    @FXML
    private Label txtCurrentShift;
    
    @FXML
    private Label txtCurrentShiftP;
    //Next
    @FXML
    void nextuser(ActionEvent event) {
    	bank.nextNormalClient();
    	txtNormalQueue.setText(bank.normalShift());
    	normalClient = bank.normalCurrent();
    	if(normalClient!=null) {
    		txtCurrentShift.setText("TURNO ACTUAL: "+normalClient.getName()+" "+normalClient.getLastName());
    	}else {
    		txtCurrentShift.setText("TURNO ACTUAL: Null");
    	}
    }
    @FXML
    void nextUserP(ActionEvent event) {
    	
    	bank.nextPriorityClient();
    	txtPriorityQueue.setText(bank.priorityShift());
    	priorityClient = bank.priorityCurrent();
    	if(priorityClient!=null) {
    		txtCurrentShiftP.setText("TURNO ACTUAL: "+priorityClient.getName()+" "+priorityClient.getLastName());
    	}else {
    		txtCurrentShiftP.setText("TURNO ACTUAL: Null");
    	}
    }
 	
}
