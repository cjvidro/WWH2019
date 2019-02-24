import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class testArea extends Application{
	
	public static void main(String args[])
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		Rooms room = new Rooms(75, 75);
		Doors door = new Doors(100, 0);
		Walls wall = new Walls(100, 100);
		Floors floor = new Floors((int)200, 200);
		pane.getChildren().addAll(room.pane, wall.getShape(), floor.getShape());
		
		Scene scene = new Scene(pane, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Test");
		primaryStage.show();
		
	}

}
