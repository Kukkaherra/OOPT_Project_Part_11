package learningTool;

/**
 * LUT OOPT, Spring 2017
 * Authors:
 * Jere Kaplas 0403105
 * Sakari Laine 0418598
 * Eetu Heimala 0388819
 * Oskari Jahkola 0403082
 */



import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Mainclass extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}

	public static void main(String[] args) throws IOException {
		launch(args);
	}
}
