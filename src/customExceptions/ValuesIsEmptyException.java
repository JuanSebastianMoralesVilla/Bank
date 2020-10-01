package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

@SuppressWarnings("serial")
public class ValuesIsEmptyException extends Exception{
	public ValuesIsEmptyException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("EMPTY");
		alert.setHeaderText("BANK");
		alert.setContentText("Incorrect information");

		alert.showAndWait();
	}
}
