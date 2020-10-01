package customExceptions;

import javafx.scene.control.Alert;

@SuppressWarnings("serial")
public class NoUserException extends Exception{
		public NoUserException() {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("No exist user in this Queue");
			alert.showAndWait();
		}
}
