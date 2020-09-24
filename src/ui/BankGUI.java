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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	private ToggleGroup grupoTipocliente;

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
		// TODO Auto-generated constructor stub
	}

	public void init(ActionEvent event) throws IOException {

		FXMLLoader fL = new FXMLLoader(getClass().getResource("turnoInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);

		/*
		 * FXMLLoader f= new FXMLLoader(getClass().getResource("CreateUser1.fxml"));
		 * f.setController(this); Parent root= f.load(); Stage st=new Stage();
		 * 
		 * sc.getStylesheets().add(getClass().getResource("iconos.css").toExternalForm()
		 * ); st.initModality(Modality.APPLICATION_MODAL);
		 * st.initStyle(StageStyle.DECORATED); st.setScene(sc);
		 * 
		 * st.show();
		 * 
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

	// Boton de Crear el usuario
	@FXML
	void createUser(ActionEvent event) throws IOException {

		FXMLLoader fL = new FXMLLoader(getClass().getResource("turnoInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
	}

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

	@FXML
	void addUser(ActionEvent event) throws IOException {

		FXMLLoader fL = new FXMLLoader(getClass().getResource("CreateUser1.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);

	}

	@FXML
	void createShift(ActionEvent event) throws IOException {
		FXMLLoader fL = new FXMLLoader(getClass().getResource("reportQueue.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);
	}

	@FXML
	void loadInformationClient(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TableInterface.fxml"));
		fxmlLoader.setController(this);
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.show();
	}

	// Tabla de ordenamientos

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

		FXMLLoader fL = new FXMLLoader(getClass().getResource("turnoInterface.fxml"));
		fL.setController(this);
		Parent pane;
		pane = fL.load();
		myPane.getChildren().clear();
		myPane.setCenter(pane);

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

	// Botones del menu de opciones.

	@FXML
	private Button btconsignacion;

	@FXML
	private Button btPagoTarjeta;

	@FXML
	private Button btRetiro;

	@FXML
	private Button btBacktoShift;

	@FXML
	private Button btCancelAccount;

	@FXML
	void loadCancelAcount(ActionEvent event) {

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
	void loadbacktoinit(ActionEvent event) {

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


}
