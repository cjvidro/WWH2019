import javafx.scene.shape.Rectangle;

public class Doors {

	private Walls door;
	private buildingBlocks info;
	
	public Doors(int x, int y) {
		door = new Walls(x, y, "door");
		door.setTraversable(true);
		info = new buildingBlocks("Door", x, y, 1);
	}
	
	public int getX()
	{
		return door.getXAxe();
	}
	
	public int getY()
	{
		return door.getYAxe();
	}
	
	public int getWidth()
	{
		return door.getWid();
	}
	
	public int getHeight()
	{
		return door.getHei();
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
	

}
