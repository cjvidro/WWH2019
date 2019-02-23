import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Gui extends  Application {
	//containers
	private BorderPane mainWindow;
	private VBox controls;
	private VBox properties;
	private Pane viewer;
	private HBox name = new HBox();
	private HBox room = new HBox();
	private HBox type = new HBox();
	private HBox x_location = new HBox();
	private HBox y_location = new HBox();
	private HBox floor = new HBox();
	private HBox fileControl;
	
	// elements / nodes
	private Button saveButton;
	private Button loadButton;
	private ComboBox<String> addObject = new ComboBox<>();
	private Label propertyTitle;
	private Label locationTitle;
	private Label nameText;
	private TextField nameField;
	private Label roomText;
	private TextField roomField;
	private Label typeText;
	private TextField typeField;
	private Label xText;
	private TextField xField;
	private Label yText;
	private TextField yField;
	private Label floorText;
	private TextField floorField;

	// Design variables
    Font titleFont = Font.font("Bookman", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 20);
    Font labelFont = Font.font("Bookman", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 16);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		setupViewer();
		setupText();
		setupTextFields();
		setupPropertyContainers();
		setupSaveLoadButtons();
		setupProperties();
		setupFileControls();
		setupControls();
		
		// set up general areas
		mainWindow = new BorderPane();
		mainWindow.setLeft(viewer);
		mainWindow.setRight(controls);

		// Final changes
		Scene primaryScene = new Scene(mainWindow, 1280, 720);
		primaryStage.setScene(primaryScene);
		primaryStage.setTitle("WWHC 2019 Project");
		primaryStage.show();
	}
	
	private void setupViewer() {
		// setup viewer
		viewer = new Pane();
//		viewer.minWidthProperty().bind(mainWindow.widthProperty().multiply(0.7));
//		viewer.maxWidthProperty().bind(mainWindow.widthProperty().multiply(0.7));
		//temporary
		//viewer.setStyle("-fx-border-color: black; -fx-border-width: 3");
	}
	
	private void setupControls() {
		//setup controls
		controls = new VBox();
		controls.getChildren().addAll(properties, fileControl);
//		controls.minWidthProperty().bind(mainWindow.widthProperty().multiply(0.3));
//		controls.maxWidthProperty().bind(mainWindow.widthProperty().multiply(0.3));
	}
	
	private void setupFileControls() {
		fileControl = new HBox();
		fileControl.getChildren().addAll(saveButton, loadButton);
	}
	
	private void setupSaveLoadButtons() {
		// setup saveButton
		saveButton = new Button("Save");
		
		//setup loadButton
		loadButton = new Button("Load");
	}
	
	private void setupProperties() {
		// setup properties
		properties = new VBox();
		properties.getChildren().addAll(name, room, type, x_location, y_location, floor);
//		properties.minWidthProperty().bind(mainWindow.widthProperty().multiply(0.3));
//		properties.maxWidthProperty().bind(mainWindow.widthProperty().multiply(0.3));
	}
	
	private void setupText() {
		//setup Texts
		propertyTitle = new Label("Properties");
		propertyTitle.setFont(titleFont);
		propertyTitle.setTextFill(Color.BLACK);
		
		nameText = new Label("Name");
		nameText.setFont(labelFont);
		nameText.setTextFill(Color.BLACK);
		
		roomText = new Label("Room");
		roomText.setFont(labelFont);
		roomText.setTextFill(Color.BLACK);
		
		typeText = new Label("Type");
		typeText.setFont(labelFont);
		typeText.setTextFill(Color.BLACK);
		
		locationTitle = new Label("Locataion");
		locationTitle.setFont(titleFont);
		locationTitle.setTextFill(Color.BLACK);
		
		xText = new Label("X");
		xText.setFont(labelFont);
		xText.setTextFill(Color.BLACK);
		
		yText = new Label("Y");
		yText.setFont(labelFont);
		yText.setTextFill(Color.BLACK);
		
		yText = new Label("Y");
		yText.setFont(labelFont);
		yText.setTextFill(Color.BLACK);
		
		floorText = new Label("Floor");
		floorText.setFont(labelFont);
		floorText.setTextFill(Color.BLACK);
	}
	
	private void setupTextFields() {
		//setup TextFields
		nameField = new TextField();
		nameField.setEditable(true);
		nameField.setPromptText("Enter a room name");
		
		roomField = new TextField();
		roomField.setEditable(true);
		roomField.setPromptText("Enter the room number");
 
		
		typeField = new TextField();
		typeField.setEditable(false);
		
		xField = new TextField();
		xField.setEditable(false);
		
		yField = new TextField();
		yField.setEditable(false);
		
		floorField = new TextField();
		floorField.setEditable(false);
	}
	
	private void setupPropertyContainers() {
		name.getChildren().addAll(nameText, nameField);
		room.getChildren().addAll(roomText, roomField);
		type.getChildren().addAll(typeText, typeField);
		x_location.getChildren().addAll(xText, xField);
		y_location.getChildren().addAll(yText, yField);
		floor.getChildren().addAll(floorText, floorField);
	}
}
