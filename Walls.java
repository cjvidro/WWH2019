import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Walls {
	Rectangle customWall;
	buildingBlocks info;
	
	public Walls(int x, int y)
	{
		customWall.setX(x);
		customWall.setY(y);
		customWall.setStroke(Color.BLACK);
		
		info = new buildingBlocks("Wall", x, y, 1);
		
	}
	
	public int getX()
	{
		return (int)customWall.getX();
	}
	
	public int getY()
	{
		return (int)customWall.getY();
	}
	
	public int getWidth()
	{
		return (int)customWall.getWidth();
	}
	
	public int getHeight()
	{
		return (int)customWall.getHeight();
	}
	
	public buildingBlocks write()
	{
		return info;
	}
}
