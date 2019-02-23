
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Floors extends Rectangle {
	
	private Rectangle theFloor;
	private buildingBlocks info;
	private boolean traversable;
	
	public Floors(int x, int y)
	{
		traversable = true;
		theFloor = new Rectangle(x, y, 25, 25);
		theFloor.setFill(Color.GREEN);
		
		info = new buildingBlocks("Floor", x, y, 1);
	}
	
	
	public Floors(int x, int y, int width, int height)
	{
		traversable = true;
		theFloor = new Rectangle(x, y, width, height);
		theFloor.setFill(Color.GREEN);
		
		info = new buildingBlocks("Floor", x, y, 1);
	}
	public int floorX()
	{
		return (int)theFloor.getX();
	}
	
	public int floorY()
	{
		return (int)theFloor.getY();
	}
	
	public buildingBlocks write()
	{
		return info;
	}
	
	public Rectangle getShape()
	{
		return theFloor;
	}
	
	public boolean getTravel()
	{
		return traversable;
	}
}