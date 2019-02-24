
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

public class Floors extends Rectangle {
	
	private Rectangle theFloor;
	private buildingBlocks info;
	private boolean traversable;
	
	// Constructor that only takes the x and y coordinates for setting up the position of the shape.
	@SuppressWarnings("deprecation")
	public Floors(int x, int y)
	{
		traversable = true;
		theFloor = RectangleBuilder.create().x(x).y(y).width(4/5*25).height(4/5*25).fill(new ImagePattern(new Image("file:25 by 25 Floor Wood.png"), 0, 0, 1, 1, true)).build();
		info = new buildingBlocks("Floor", x, y, 1);
	}
	
	// Constructor that takes width and height on top of x and y coordinates to allow for multiple blocks to be created at once.
	public Floors(int x, int y, int width, int height)
	{
		traversable = true;
		theFloor = RectangleBuilder.create().x(x).y(y).width(width).height(height).fill(new ImagePattern(new Image("file:25 by 25 Floor Wood.png"), 0, 0, 1, 1, true)).build();
		info = new buildingBlocks("Floor", x, y, 1);
	}
	
	public Floors(double width, double height) {
		traversable = true;
		theFloor = RectangleBuilder.create().width(width).height(height).fill(new ImagePattern(new Image("file:25 by 25 Floor Wood.png"), 0, 0, 1, 1, true)).build();
		info = new buildingBlocks("Floor", 0, 0, 1);
	}

	// Gets the x coordinate of the rectangle.
	public int floorX()
	{
		return (int)theFloor.getX();
	}
	
	// Gets the y coordinate of the rectangle.
	public int floorY()
	{
		return (int)theFloor.getY();
	}
	
	// Will be used to access the data for the properties window.
	public buildingBlocks write()
	{
		return info;
	}
	
	// Returns the shape of the floor allowing it to be placed into a pane.
	public Rectangle getShape()
	{
		return theFloor;
	}
	
	// Will help later to create the path finder class.
	public boolean getTravel()
	{
		return traversable;
	}
}