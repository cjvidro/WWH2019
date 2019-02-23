import javafx.scene.shape.Rectangle;

public class Rooms{
	
	// This is used to show where the grid walls are.
	Walls outerWalls;
	Floors innerArea;
	String roomNumber;
	buildingBlocks info;
	
	public Rooms(int x, int y, String num)
	{
		outerWalls = new Walls(x, y);
		innerArea = new Floors(x, y);
		roomNumber = num;
		info = new buildingBlocks(" ", roomNumber, "Room", x, y, 1);
	}
	
	public Rooms(int x, int y, int width, int height, String num)
	{
		outerWalls = new Walls(x, y, width, height);
		innerArea = new Floors(x, y, width, height);
		roomNumber = num;
		info = new buildingBlocks(" ", roomNumber, "Room", x, y, 1);
	}
	/*
	 * Gives the location of the room object.
	 */
	public int[] location()
	{
		// Point is an array that will store the x and y values of the grid. 
		int[] point = new int[2];
		// The width and height of each grid pane is 25 and the rooms are automatically going to fit within them.
		point[0] = outerWalls.getXAxe()/25;
		point[1] = outerWalls.getYAxe()/25;
		return point;
	}
	
	/*
	 * Gives the texture of the room object.
	 */
	public void texture()
	{
		return;
	}
	
	/*
	 * Gives the width of the room.
	 * The width is measured in pixels.
	 */
	public int width()
	{
		return outerWalls.getWid();
	}
	
	/*
	 * Gives the height of the room.
	 * The height is measured in pixels.
	 */
	public int height()
	{
		return outerWalls.getHei();
	}
	
	public buildingBlocks write()
	{
		return info;
	}
	
	public void setName(String name)
	{
		info.setName(name);
	}
	
	public Rectangle getFloor()
	{
		return innerArea.getShape();
	}
	
	public Rectangle getWall()
	{
		return outerWalls.getShape();
	}
	
}
