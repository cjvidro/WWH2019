import javafx.scene.shape.Rectangle;

public class Doors {

	private Walls door;
	private buildingBlocks info;
	private int x;
	private int y;
	
	public Doors(int x, int y) {
		door = new Walls(x, y, "door");
		this.x = x;
		this.y = y;
		door.setTraversable(true);
		info = new buildingBlocks("Door", x, y);
	}
	
	public int getX()
	{
		if(x == door.getXAxe())
		{
			return door.getXAxe();
		}
		return x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getY()
	{
		if(y == door.getYAxe())
		{
			return door.getYAxe();
		}
		return y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getWidth()
	{
		return door.getWid();
	}
	
	public void setWidth(int width)
	{
		door.setWid(width);
	}
	
	public int getHeight()
	{
		return door.getHei();
	}
	
	public void setHeight(int height)
	{
		door.setHei(height);
	}
	
	public buildingBlocks getInfo()
	{
		return info;
	}
	
	public boolean getTravel()
	{
		return door.getTravel();
	}
	
	public Rectangle getShape()
	{
		return door.getShape();
	}
	
	public buildingBlocks write()
	{
		return info;
	}

}
