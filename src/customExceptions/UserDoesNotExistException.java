package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

@SuppressWarnings("serial")
public class UserDoesNotExistException extends Exception{
	public UserDoesNotExistException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("NotExist");
		alert.setHeaderText("BANK");
		alert.setContentText("This User does not exist");

		alert.showAndWait();
	}
}
