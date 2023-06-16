package NumMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class
 * @author Owner : Main Class
 *
 */
public class NumPuzzMain extends Application {
	
	/**
	 * Default Constructor
	 */
	public NumPuzzMain() {}
	
	/**
	 * main method
	 * @param args : Main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	/**
	 * First Stage Method
	 */
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("mainStage.fxml"));
		primaryStage.setTitle("NumPuzz: Number Game");
		Scene scene = new Scene(root, 300, 400);
		scene.getStylesheets().add(getClass().getResource("mainStageDesign.css").toExternalForm());
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
