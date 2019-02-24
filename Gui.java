import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Gui extends Application {
	//containers
	private BorderPane mainWindow = new BorderPane();;
	private VBox controls;
	private VBox properties;
	private StackPane viewer = new StackPane();
	private Pane grid = new Pane();
	private Pane objects = new Pane();
	private HBox x_location = new HBox();
	private HBox y_location = new HBox();
	private HBox floor = new HBox();
	private HBox fileControl;
	private GridPane nameRoomType = new GridPane();
	private GridPane xyFloor = new GridPane();
	
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
	private Rectangle spacer = new Rectangle(20, 1);
	private boolean addOpen = false;
	private double xLastTranslate = 0;
	private double yLastTranslate = 0;
	private double xMouseClick = 0;
	private double yMouseClick = 0;

	// Design variables
    final Font titleFont = Font.font("Bookman", FontWeight.BOLD, FontPosture.REGULAR, 25);
    final Font subtitleFont = Font.font("Bookman", FontWeight.BOLD, FontPosture.REGULAR, 22);
    final Font labelFont = Font.font("Bookman", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 20);
    final Background whiteBackground = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
    final Color lightestGray = new Color(0.3, 0.3, 0.3, 0.3);
    
    // Data Variables
    public Object[][] gridObjects = new Object[300][300];
    
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {		
		setupViewer();
		setupText();
		setupTextFields();
		setupAddObject();
		setupPropertyGridPanes();
		setupPropertyContainers();
		setupSaveLoadButtons();
		setupProperties();
		setupFileControls();
		setupControls();
		setupGeneral();
		
		// Final changes
		Scene primaryScene = new Scene(mainWindow, 1280, 720);
		primaryScene.setFill(Color.WHITE);
		primaryStage.setMinWidth(850);
		primaryStage.setMinHeight(500);
		primaryStage.setScene(primaryScene);
		primaryStage.setTitle("WWHC 2019 Project");
		primaryStage.show();
	}
	
	private void setupViewer() {
		// setup viewer
		viewer.minWidthProperty().bind(mainWindow.widthProperty().multiply(0.7));
		viewer.maxWidthProperty().bind(mainWindow.widthProperty().multiply(0.7));
		
		viewer.getChildren().addAll(grid, objects);
		viewer.requestFocus();
		viewer.setOnKeyPressed(event -> {
			System.out.println("key pressed");
		});
		
		//grid lines in grid
		for (int i = -5000; i <= 5000; i+= 25) {
			Line line = new Line(i, -5000, i, 5000);
			Line line2 = new Line(-5000, i, 5000, i);
			
			line.setStroke(lightestGray);
			line2.setStroke(lightestGray);
			
			grid.getChildren().addAll(line, line2);
		}
		
		//setupViewerDrag();

		
		//temporary
		viewer.setStyle("-fx-border-color: black; -fx-border-width: 3");
	}
	
	private void setupViewerDrag() {
//		viewer.setOnMousePressed(null);
//		viewer.setOnMouseDragged(null);
//		viewer.setOnMouseReleased(null);
//		viewer.setOnMouseClicked(null);
//		viewer.setOnMouseMoved(null);
//		viewer.setOnKeyPressed(null);
//
//		
//		viewer.setOnMousePressed(event -> {
//			System.out.println("mouse pressed");
//			
//			xMouseClick = event.getX();
//			yMouseClick = event.getY();
//			
//			System.out.println(xMouseClick + "    " + yMouseClick);
//			
//			viewer.setOnMouseDragged(mouse -> {
//				//System.out.println("mousemoved");
//				viewer.setTranslateX((xLastTranslate - (xMouseClick - mouse.getX())) / 1.1);
//				viewer.setTranslateY((yLastTranslate - (yMouseClick - mouse.getY())) / 1.1);
//			});
//		});
//		
//		viewer.setOnMouseReleased(event -> {
//			System.out.println("mouse released");
//
//			viewer.setOnMouseMoved(null);
//			xLastTranslate = viewer.getTranslateX();
//			yLastTranslate = viewer.getTranslateY();
//		});
//		
//		viewer.requestFocus();

	}
	
	private void setupControls() {
		//setup controls
		controls = new VBox();
		controls.getChildren().addAll(addObject, properties, fileControl);
		controls.setSpacing(25);
		controls.setPadding(new Insets(10, 0, 15, 0));
		controls.minWidthProperty().bind(mainWindow.widthProperty().multiply(0.3));
		controls.maxWidthProperty().bind(mainWindow.widthProperty().multiply(0.3));
		controls.setBackground(whiteBackground);
	}
	
	private void setupFileControls() {
		fileControl = new HBox();
		fileControl.setSpacing(30);
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
		properties.getChildren().addAll(propertyTitle, nameRoomType, locationTitle, xyFloor);
		properties.setSpacing(5);
		properties.minWidthProperty().bind(mainWindow.widthProperty().multiply(0.3));
		properties.maxWidthProperty().bind(mainWindow.widthProperty().multiply(0.3));
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
		
		locationTitle = new Label("Location");
		locationTitle.setFont(subtitleFont);
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
		x_location.getChildren().addAll(xText, xField);
		y_location.getChildren().addAll(yText, yField);
		floor.getChildren().addAll(floorText, floorField);
		
		nameRoomType.add(nameText, 0, 0);
		nameRoomType.add(nameField, 1, 0);
		nameRoomType.add(roomText, 0, 1);
		nameRoomType.add(roomField, 1, 1);
		nameRoomType.add(typeText, 0, 2);
		nameRoomType.add(typeField, 1, 2);
		
		xyFloor.add(xText, 0, 0);
		xyFloor.add(xField, 1, 0);
		xyFloor.add(yText, 0, 1);
		xyFloor.add(yField, 1, 1);
		xyFloor.add(floorText, 0, 2);
		xyFloor.add(floorField, 1, 2);
	}
	
	private void setupPropertyGridPanes() {
		nameRoomType.setPadding(new Insets(3, 3, 3, 10));
		nameRoomType.setHgap(8);
		nameRoomType.setVgap(10);
		//nameRoomType.setGridLinesVisible(true);
		
		xyFloor.setPadding(new Insets(3, 3, 3, 10));
		xyFloor.setHgap(8);
		xyFloor.setVgap(10);
		//xyFloor.setGridLinesVisible(true);
	}
	
	private void setupGeneral() {
		// set up general areas
		mainWindow.setLeft(viewer);
		mainWindow.setCenter(spacer);
		mainWindow.setRight(controls);
		mainWindow.setBackground(whiteBackground);
		
		spacer.heightProperty().bind(mainWindow.heightProperty());
		spacer.setFill(Color.WHITE);
		
	}
	
	private void setupAddObject() {
		addObject.getItems().addAll("Room", "Walkway", "Door", "Wall");
		addObject.setPromptText("Add Object");
		addObject.setOnAction(event -> addObjectSelected());
		addObject.setStyle("-fx-font: lighter 14px \"Bookman\"; ");
	}
	
	private void addObjectSelected() {
		if (addObject.getValue().equals("Room")) {
			System.out.println("Selected room");
		}
		else if (addObject.getValue().equals("Walkway")) {
			if(!addOpen) {
				createNextWalkway(0, 0);
			}
			
		}
		else if (addObject.getValue().equals("Door")) {
			System.out.println("Selected Door");
		}
		else if (addObject.getValue().equals("Wall")) {
			System.out.println("Selected Wall");
			if(!addOpen) {
				createNextWall(0, 0);
			}
		}
		
		createNewAddObject();
	}
	
	private void createNewAddObject() {
		controls.getChildren().remove(addObject);
		
		addObject = new ComboBox<>();
		addObject.getItems().addAll("Room", "Walkway", "Door", "Wall");
		addObject.setPromptText("Add Object");
		addObject.setOnAction(event -> addObjectSelected());
		addObject.setStyle("-fx-font: lighter 14px \"Bookman\"; ");
		controls.getChildren().add(0, addObject);
	}
	
	private void createNextWall(int x, int y)
	{
		addOpen = true;
		
		Walls wall = new Walls(x, y);
		Rectangle nextWall = wall.getShape();
		objects.getChildren().add(nextWall);
		
//		viewer.setOnMousePressed(null);
//		viewer.setOnMouseDragged(null);
//		viewer.setOnMouseReleased(null);
//		viewer.setOnKeyPressed(null);

		
		viewer.setOnMouseMoved(mouse -> {
			if (mouse.getX() % 25 == 0) {
				nextWall.setX(mouse.getX());
			}
			
			if (mouse.getY() % 25 == 0) {
				nextWall.setY(mouse.getY());
			}
		});
		
		viewer.setOnMouseClicked(event -> {
			if (gridObjects[(int) (nextWall.getX() / 25)][(int) (nextWall.getY() / 25)] == null) {
				System.out.println("Wall placed");
				
				gridObjects[(int) (nextWall.getX() / 25)][(int) (nextWall.getY() / 25)] = nextWall;
				
				viewer.setOnMouseMoved(null);
				viewer.setOnMouseClicked(null);
				
				createNextWall((int) nextWall.getX(), (int) nextWall.getY());
			} else {
				System.out.println(gridObjects[(int) nextWall.getX() / 25][(int) nextWall.getY() / 25].toString());
				System.out.println("Not valid area");
			}
		});
		
//		viewer.setOnKeyPressed(event -> {
//			if (event.getCode() == KeyCode.ESCAPE) {
//				objects.getChildren().remove(nextWall);
//				viewer.setOnMouseMoved(null);
//				viewer.setOnMouseClicked(null);
//				viewer.setOnKeyPressed(null);
//				addOpen = false;
//				//setupViewerDrag();
//			}
//		});
	}
	
	private void createNextWalkway(int x, int y) {
		addOpen = true;
		
		Floors nextFloor = new Floors(x, y);
		Rectangle nextWalkway = nextFloor.getShape();
		objects.getChildren().add(nextWalkway);
		
//		viewer.setOnMousePressed(null);
//		viewer.setOnMouseDragged(null);
//		viewer.setOnMouseReleased(null);
//		viewer.setOnKeyPressed(null);
		
		viewer.setOnMouseMoved(mouse -> {
			if (mouse.getX() % 25 == 0) {
				nextWalkway.setX(mouse.getX());
			}
			
			if (mouse.getY() % 25 == 0) {
				nextWalkway.setY(mouse.getY());
			}
		});
		
		
		viewer.setOnMouseClicked(event -> {
			if (gridObjects[(int) (nextWalkway.getX() / 25)][(int) (nextWalkway.getY() / 25)] == null) {
				System.out.println("Walkway placed");
				
				gridObjects[(int) (nextWalkway.getX() / 25)][(int) (nextWalkway.getY() / 25)] = nextWalkway;
				
				viewer.setOnMouseMoved(null);
				viewer.setOnMouseClicked(null);
				
				createNextWalkway((int) nextWalkway.getX(), (int) nextWalkway.getY());
			} else {
				System.out.println(gridObjects[(int) nextWalkway.getX() / 25][(int) nextWalkway.getY() / 25].toString());
				System.out.println("Not valid area");
			}
		});
		
//		viewer.setOnKeyPressed(event -> {
//			System.out.println("pressedkey");
//			
//			if (event.getCode() == KeyCode.ESCAPE) {
//				objects.getChildren().remove(nextWalkway);
//				viewer.setOnMouseMoved(null);
//				viewer.setOnMouseClicked(null);
//				viewer.setOnKeyPressed(null);
//				addOpen = false;
//				//setupViewerDrag();
//			}
//		});
	}
}
