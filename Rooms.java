
public class Rooms {
	
	// This is used to show where the grid walls are.
	Walls outerWalls;
	String roomNumber;
	buildingBlocks info;
	
	public Rooms(int x, int y, String num)
	{
		outerWalls = new Walls(x, y);
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
		point[0] = outerWalls.getX()/25;
		point[1] = outerWalls.getY()/25;
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
		return outerWalls.getWidth();
	}
	
	/*
	 * Gives the height of the room.
	 * The height is measured in pixels.
	 */
	public int height()
	{
		return outerWalls.getHeight();
	}
	
	public buildingBlocks write()
	{
		return info;
	}
	
	public void setName(String name)
	{
		info.setName(name);
	}
}
