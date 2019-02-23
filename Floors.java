import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Floors {
	
	Rectangle theFloor;
	buildingBlocks info;
	
	public Floors(int x, int y)
	{
		theFloor.setX(x);
		theFloor.setY(y);
		theFloor.setFill(Color.ALICEBLUE);
		
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
}