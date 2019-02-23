
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Walls extends Rectangle {
	
	private Rectangle customWall;
	private buildingBlocks info;
	private boolean traversable;
	
	public Walls(int x, int y)
	{
		traversable = false;
		customWall = new Rectangle(x, y, 25, 25);
		customWall.setStroke(Color.RED);
		customWall.setFill(Color.TRANSPARENT);
		customWall.setStrokeWidth(3);
		info = new buildingBlocks("Wall", x, y, 1);
	}
	
	public Walls(int x, int y, int width, int height)
	{
		traversable = false;
		customWall = new Rectangle(x, y, width, height);
		customWall.setStroke(Color.RED);
		customWall.setFill(Color.TRANSPARENT);
		customWall.setStrokeWidth(3);
		info = new buildingBlocks("Wall", x, y, 1);
	}
	
	public int getXAxe()
	{
		return (int)customWall.getX();
	}
	
	public int getYAxe()
	{
		return (int)customWall.getY();
	}
	
	public int getWid()
	{
		return (int)customWall.getWidth();
	}
	
	public int getHei()
	{
		return (int)customWall.getHeight();
	}
	
	public buildingBlocks write()
	{
		return info;
	}
	
	public Rectangle getShape()
	{
		return customWall;
	}
	
	public boolean getTravel()
	{
		return traversable;
	}
	
	public void setTraversable(boolean maybe)
	{
		traversable = maybe;
	}

}
