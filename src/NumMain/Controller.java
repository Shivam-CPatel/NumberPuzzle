package NumMain;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Class to control user action
 * @author Owner : Controller Class
 *
 */
public class Controller {
	
	/**
	 * Default Constructor
	 */
	public Controller() {}
	/**
	 * row variable used to create number puzzle
	 */
	private int row;
	/**
	 * col variable used to create number puzzle
	 */
	private int col;
	/**
	 * textRow variable used to create text puzzle
	 */
	private int textRow;
	/**
	 * textCol variable used to create text puzzle
	 */
	private int textCol;
	@FXML
	/**
	 * dimension dimension button
	 */
	private MenuButton dimensionMenuButton = new MenuButton("dimension");
	@FXML
	/**
	 * type dimension button
	 */
	private MenuButton typeMenuButton = new MenuButton("type");
	@FXML
	/**
	 * difficulty dimension button
	 */
	private MenuButton difficultyMenuButton = new MenuButton("difficulty");
	@FXML
	/**
	 * text puzzle
	 */
	private TextField textInPuzzle = new TextField();
	@FXML
	/**
	 * 3x3 dimension item
	 */
	private MenuItem dim3 = new MenuItem("3x3");
	@FXML
	/**
	 * 4x4 dimension item
	 */
	private MenuItem dim4 = new MenuItem("4x4");
	@FXML
	/**
	 * 5x5 dimension item
	 */
	private MenuItem dim5 = new MenuItem("5x5");
	@FXML
	/**
	 * 6x6 dimension item
	 */
	private MenuItem dim6 = new MenuItem("6x6");
	@FXML
	/**
	 * 6x6 dimension item
	 */
	private MenuItem dim7 = new MenuItem("7x7");
	@FXML
	/**
	 * 6x6 dimension item
	 */
	private MenuItem dim8 = new MenuItem("8x8");
	@FXML
	/**
	 * 6x6 dimension item
	 */
	private MenuItem dim9 = new MenuItem("9x9");
	@FXML
	/**
	 * Number type menu item
	 */
	private MenuItem NumberPuzzle = new MenuItem("Numbers");
	@FXML
	/**
	 * Text type menu item
	 */
	private MenuItem TextPuzzle = new MenuItem("Text");
	@FXML
	/**
	 * Easy type menu item
	 */
	private MenuItem easy = new MenuItem("Easy");
	@FXML
	/**
	 * Medium type menu item
	 */
	private MenuItem medium = new MenuItem("Medium");
	@FXML
	/**
	 * Hard type menu item
	 */
	private MenuItem hard = new MenuItem("Hard");
	
	/**
	 * dimension affect
	 * @param event - method to store select dimension in selectedDimension array 
	 */
	public void dimensionSelection(ActionEvent event) {
		String srcId = ((MenuItem) event.getSource()).getText();
		dimensionMenuButton.setText(srcId);
	}
	
	/**
	 * type affect
	 * @param event - method to store select dimension in selectedType array  
	 */
	public void typeSelection(ActionEvent event) {
		String srcId = ((MenuItem) event.getSource()).getText();
		typeMenuButton.setText(srcId);
	}
	
	/**
	 * difficulty affect
	 * @param event - method to store select dimension in selectedDifficulty array 
	 */
	public void difficultySelection(ActionEvent event) {
		String srcId = ((MenuItem) event.getSource()).getText();
		difficultyMenuButton.setText(srcId);
	}
	
	/**
	 * play button effect
	 * @param event - method to create another stage
	 * @throws IOException - input/output exception
	 */
    public void PlayButtonAction(ActionEvent event) throws IOException {
    	String typeText = typeMenuButton.getText();
    	String dimensionText = dimensionMenuButton.getText();
    	if (typeText.equals(NumberPuzzle.getText())) {    		
    		switch (dimensionText) {
    			case "3x3":
    				row = 3;
    				col = 3;
    				dimensionStages(event);
    			case "4x4":
    				row = 4;
    				col = 4;
    				dimensionStages(event);
    			case "5x5":
    				row = 5;
    				col = 5;
    				dimensionStages(event);
    			case "6x6":
    				row = 6;
    				col = 6;
    				dimensionStages(event);
    			case "7x7":
    				row = 7;
    				col = 7;
    				dimensionStages(event);
    			case "8x8":
    				row = 8;
    				col = 8;
    				dimensionStages(event);
    			case "9x9":
    				row = 9;
    				col = 9;
    				dimensionStages(event);
    			default:
    				AlertBox(event);
    		}
    	}else if (typeText.equals(TextPuzzle.getText())) {
    		switch (dimensionText) {
	    		case "3x3":
	    			textRow = 3;
	    			textCol = 3;
					textSet(event);
				case "4x4":
					textRow = 4;
					textCol = 4;
					textSet(event);
				case "5x5":
					textRow = 5;
					textCol = 5;
					textSet(event);
				case "6x6":
					textRow = 6;
					textCol = 6;
					textSet(event);
				case "7x7":
					textRow = 7;
					textCol = 7;
					textSet(event);
				case "8x8":
					textRow = 8;
					textCol = 8;
					textSet(event);
				case "9x9":
					textRow = 9;
					textCol = 9;
					textSet(event);
				default:
					AlertBox(event);
    		}
    	}else {
    		AlertBox(event);
    	}
    }
    
    /**
     * change to dimension stage
     * @param event - dimension stage
     * @throws IOException - input/output exception
     */
    public void dimensionStages(ActionEvent event) throws IOException {
    	FXMLLoader dimension = new FXMLLoader(getClass().getResource("dimensions.fxml"));
    	Parent root = dimension.load();
    	
    	Scene scene = new Scene(root, 400, 450);
    	Stage dimStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		dimensionController cntr = dimension.getController();
		cntr.numberTypeGridPane(event, row, col);
		scene.getStylesheets().add(getClass().getResource("dimensions.css").toExternalForm());
		
		dimStage.setTitle("NumPuzz: Number Game");
		dimStage.setScene(scene);
		dimStage.setResizable(false);
		dimStage.show();
    }
    
    /**
     * text for text type puzzle
     */
    String puzzleText = textInPuzzle.getText();
    /**
     * change to dimension stage
     * @param event - dimension stage
     * @throws IOException - input/output exception
     */
    public void textDimensionStages(ActionEvent event) throws IOException {
    	FXMLLoader dimension = new FXMLLoader(getClass().getResource("dimensions.fxml"));
    	Parent root = dimension.load();
    	
    	Scene scene = new Scene(root, 400, 450);
    	Stage dimStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		dimensionController cntr = dimension.getController();
		cntr.textTypeGridPane(event, puzzleText, textRow, textCol);
		scene.getStylesheets().add(getClass().getResource("dimensions.css").toExternalForm());
		
		dimStage.setTitle("NumPuzz: Number Game");
		dimStage.setScene(scene);
		dimStage.setResizable(false);
		dimStage.show();
    }
    
    
    /**
     * change to get text stage
     * @param event - Set text Stage for text type puzzle
     * @throws IOException - input/output exception
     */
    public void textSet(ActionEvent event) throws IOException {
    	Parent dim3 = FXMLLoader.load(getClass().getResource("whatText.fxml"));
		Scene scene = new Scene(dim3, 424, 194);
		Stage dimStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("dimensions.css").toExternalForm());
		dimStage.setTitle("NumPuzz: Number Game");
		dimStage.setScene(scene);
		dimStage.setResizable(false);
		dimStage.show();
    }
    
    /**
     * change to alert stage
     * @param event - AlertBox Stage
     * @throws IOException - input/output exception
     */
    public void AlertBox(ActionEvent event) throws IOException {
    	Parent dim3 = FXMLLoader.load(getClass().getResource("AlertBox.fxml"));
		Scene scene = new Scene(dim3, 434, 121);
		Stage dim3Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("dimensions.css").toExternalForm());
		dim3Stage.setTitle("NumPuzz: Number Game");
		dim3Stage.setScene(scene);
		dim3Stage.setResizable(false);
		dim3Stage.show();
    }
    
    /**
     * take back to main stage
     * @param event - main stage
     * @throws IOException - check Input/Output exception
     */
    public void mainStage(ActionEvent event) throws IOException {
    	Parent dim3 = FXMLLoader.load(getClass().getResource("mainStage.fxml"));
		Scene scene = new Scene(dim3, 300, 400);
		Stage dim3Stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("mainStageDesign.css").toExternalForm());
		dim3Stage.setTitle("NumPuzz: Number Game");
		dim3Stage.setScene(scene);
		dim3Stage.setResizable(false);
		dim3Stage.show();
    }
}
