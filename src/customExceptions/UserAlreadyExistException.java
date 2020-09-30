package customExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

@SuppressWarnings("serial")
public class UserAlreadyExistException extends Exception{
	public UserAlreadyExistException() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Already Exist");
		alert.setHeaderText("BANK");
		alert.setContentText("This User account already Exist");
		alert.showAndWait();
	}
}
