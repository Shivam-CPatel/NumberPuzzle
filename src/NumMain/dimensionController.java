package NumMain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * controller user action in puzzle
 * @author Owner : Class for 3x3 dimension puzzle
 *
 */
public class dimensionController {
	
	/**
	 * Default Constructor
	 */
	public dimensionController(){}
	/**
	 * keep a record of game points
	 */
	private int gamePoints = 1;
	/**
	 * keep a record of how many moves 
	 */
	private int numberOfMoves = 1;
	@FXML
	/**
	 * GridPane variable
	 */
	private GridPane gpane = new GridPane();
	@FXML
	/**
	 * puzzle buttons 2 dimensional array
	 */
	private Button puzzleButtons[][];
	@FXML
	/**
	 * select again button if user got to alert stage
	 */
	private Button selectAgain = new Button();
	@FXML
	/**
	 * text puzzle
	 */
	private TextField textInPuzzle = new TextField();
	@FXML
	/**
	 * button to set text in puzzle 
	 */
	private Button setText = new Button();
	@FXML
	/**
	 * Button to go back to main stage
	 */
	private Button goBack = new Button();
	@FXML
	/**
	 * move labels
	 */
	private Label moves = new Label();
	@FXML
	/**
	 * point label
	 */
	private Label points = new Label();
	
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
	
    
    /**
     * boolean for game is finished or not
     */
	private boolean win = false;
    
	/**
	 * create buttons for number type puzzle
	 * @param event: user action event
	 * @param row: row count in puzzle dimension
	 * @param col: column count in puzzle dimension
	 */
    public void numberTypeGridPane(ActionEvent event, int row, int col) {
    	
    	puzzleButtons = new Button[row][col];
    	
    	for (int i = 0; i < row; i++) {
    		for (int j = 0; j < col; j++) {
    			puzzleButtons[i][j] = new Button();
    			gpane.add(puzzleButtons[i][j], j, i);
    			puzzleButtons[i][j].setPrefHeight(100);
    			puzzleButtons[i][j].setPrefWidth(100);
    		}
    	}
    	
    	numberTypePuzzleGeneration(event, puzzleButtons, row, col);
    }
    
    /**
     * generate button with number text
     * @param event: user action type
     * @param boxButtons: 2D array of puzzle buttons
     * @param row: row count in puzzle dimension
	 * @param col: column count in puzzle dimension
     */
    public void numberTypePuzzleGeneration(ActionEvent event, Button boxButtons[][], int row, int col){
    	win = false;
    	
    	int size = row*col;
    	int number = 1;
    	int numberIndex = 0;
    	ArrayList<Integer> box = new ArrayList<Integer>();
    	
    	for (int i = 0; i < size; i++) {
    		box.add(number);
    		number++;
    	}
    	
    	Collections.shuffle(box);
    	
    	for (int j = 0; j < row; j++) {
    		for (int k = 0; k < col; k++) {    			
    			if (box.get(numberIndex) == size) {
    				boxButtons[j][k].setText("");
    				boxButtons[j][k].setId("blackButton");
    			}else {    				
    				boxButtons[j][k].setText(Integer.toString(box.get(numberIndex)));
    				boxButtons[j][k].setId("numberButton");
    			}
				numberIndex++;
    		}
    	}
    	
    	
    	for (int x = 0; x < row; x++) {
    		for (int y = 0; y < col; y++) {
    			int x1 = x;
    			int y1 = y;
    			boxButtons[x][y].setOnAction(e -> Slide(event, boxButtons, x1, y1, row, col));
    		}
    	}
    	    	
    }
    
    /**
     * generate text type puzzle
     * @param event: user action
     * @param puzzleText: text user entered
     * @param row: row count in puzzle dimension
	 * @param col: column count in puzzle dimension
     */
    public void textTypeGridPane(ActionEvent event, String puzzleText, int row, int col) {
    	System.out.println("rows1: "+row);
		System.out.println("columns1: "+col);
    	puzzleButtons = new Button[row][col];
    	
    	for (int i = 0; i < row; i++) {
    		for (int j = 0; j < col; j++) {
    			puzzleButtons[i][j] = new Button();
    			gpane.add(puzzleButtons[i][j], j, i);
    			puzzleButtons[i][j].setPrefHeight(100);
    			puzzleButtons[i][j].setPrefWidth(100);
    		}
    	}
    	
    	textTypePuzzleGeneration(event, puzzleText, puzzleButtons, row, col);
    }
    
    /**
     * 
     * generate button with number text
     * @param event: user action type
     * @param puzzleButtons: 2D array of puzzle buttons
     * @param row: row count in puzzle dimension
	 * @param col: column count in puzzle dimension
     */
    private void textTypePuzzleGeneration(ActionEvent event, String puzzleText, Button[][] puzzleButtons, int row, int col) {
		win = false;
		
		int size = row*col;
    	int numberIndex = 0;
		
		puzzleText = textInPuzzle.getText();
		
		char[] storeInChar = puzzleText.toCharArray();
		ArrayList<Character> textToChar = new ArrayList<Character>();
		System.out.println("rows2: "+row);
		System.out.println("columns2: "+col);
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			if (i >= puzzleText.length() || i == size) {
				System.out.println(i);
				textToChar.add(' ');
			}else {
				System.out.println(storeInChar[i]);
				textToChar.add(storeInChar[i]);
			}
		}
		
		Collections.shuffle(textToChar);
		
		for (int j = 0; j < row; j++) {
    		for (int k = 0; k < col; k++) {    			
    			if (textToChar.get(numberIndex) == size) {
    				puzzleButtons[j][k].setText("");
    				puzzleButtons[j][k].setId("blackButton");
    			}else {    				
    				puzzleButtons[j][k].setText(Character.toString(textToChar.get(numberIndex)));
    				puzzleButtons[j][k].setId("numberButton");
    			}
				numberIndex++;
    		}
    	}
		
		for (int x = 0; x < row; x++) {
    		for (int y = 0; y < col; y++) {
    			int x1 = x;
    			int y1 = y;
    			puzzleButtons[x][y].setOnAction(e -> Slide(event, puzzleButtons, x1, y1, row, col));
    		}
    	}
		
		
	}
    
    /**
     * puzzle playing
     * @param event: user action
     * @param slideBox: puzzle 2D array
     * @param x: which button is a row is pressed
     * @param y: which button in a column is pressed
     * @param row: row count in puzzle dimension
	 * @param col: column count in puzzle dimension
     */
	public void Slide(ActionEvent event, Button slideBox[][], int x, int y, int row, int col) {
    	if (!win) {
    		if (x > 0) {
    			if (slideBox[x-1][y].getText().equals("")) {
    				slideBox[x-1][y].setText(slideBox[x][y].getText());
    				slideBox[x-1][y].setId("numberButton");
    				slideBox[x][y].setText("");
    				slideBox[x][y].setId("blackButton");
    				winChecking(event, slideBox, row, col);
    			}
    		}
    		if(x < row-1) {
    			if(slideBox[x+1][y].getText().equals("")) {
    				slideBox[x+1][y].setText(slideBox[x][y].getText());
    				slideBox[x+1][y].setId("numberButton");
    				slideBox[x][y].setText("");
    				slideBox[x][y].setId("blackButton");
    				winChecking(event, slideBox, row, col);
    			}
    		}
    		if(y > 0) {
    			if(slideBox[x][y-1].getText().equals("")) {
    				slideBox[x][y-1].setText(slideBox[x][y].getText());
    				slideBox[x][y-1].setId("numberButton");
    				slideBox[x][y].setText("");
    				slideBox[x][y].setId("blackButton");
    				winChecking(event, slideBox, row, col);
    			}
    		}
    		if(y < col-1) {
    			if(slideBox[x][y+1].getText().equals("")) {
    				slideBox[x][y+1].setText(slideBox[x][y].getText());
    				slideBox[x][y+1].setId("numberButton");
    				slideBox[x][y].setText("");
    				slideBox[x][y].setId("blackButton");
    				winChecking(event, slideBox, row, col);
    			}
    		}
    	}
    }
    
	/**
	 * increment number of moves every time any button got pressed
	 * @param event: user action
	 */
	public void numberOfMoves(ActionEvent event) {
		moves.setText("Moves: "+ Integer.toString(numberOfMoves++));
	}
	
	/**
	 * * method to generate point
	 * @param event: user action
	 * @param puzzleNumber: Puzzle 2D array
     * @param row: row count in puzzle dimension
	 * @param col: column count in puzzle dimension
	 */
	public void pointGenerator(ActionEvent event, Button puzzleNumber[][], int row, int col) {
		int sortPuzzle = 1;
		int sortedNumberPuzzle[][] = new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sortedNumberPuzzle[i][j] = sortPuzzle;
				sortPuzzle++;
			}
		}
		
		for (int x = 0; x < row; x++) {
			for (int y = 0; y < col; y++) {
				if (puzzleNumber[x][y].getText().equals(Integer.toString(sortedNumberPuzzle[x][y]))) {
					points.setText("Points: "+ Integer.toString(gamePoints++));
				}
			}
		}
	}
	
	/**
	 * check the game is finished or not?
	 * @param event: user action
	 * @param puzzleBoxes: puzzle buttons stored in 2D array
     * @param row: row count in puzzle dimension
	 * @param col: column count in puzzle dimension
	 */
    public void winChecking(ActionEvent event, Button puzzleBoxes[][], int row, int col) {
		
    	numberOfMoves(event);
		gamePoints = 1;
    	pointGenerator(event, puzzleBoxes, row, col);
    	
		int k = 1;
		boolean winOrNot = true;
		
		for(int i = 0; i < 3; i++) {
			
			for(int j = 0; j < 3; j++, k++) {
				if(k == 9) {
					if(!puzzleBoxes[i][j].getText().equals(""))
						winOrNot = false;
				}
				else {
					if(!puzzleBoxes[i][j].getText().equals(Integer.toString(k)))
						winOrNot = false;
				}
			}
		}
		if (winOrNot) {
			try {
				winAccomplished(event);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    
    /**
     * take to win stage if the game is finished
     * @param event - user action
     * @throws IOException - check Input/out exception
     */
	private void winAccomplished(ActionEvent event) throws IOException {
		Parent dim3 = FXMLLoader.load(getClass().getResource("WinStage.fxml"));
		Scene scene = new Scene(dim3, 456, 197);
		Stage dimStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene.getStylesheets().add(getClass().getResource("dimensions.css").toExternalForm());
		dimStage.setTitle("NumPuzz: Number Game");
		dimStage.setScene(scene);
		dimStage.setResizable(false);
		dimStage.show();
	}
}
