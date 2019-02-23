import javafx.scene.shape.Rectangle;

public class Rooms {
	
	
	/*
	 * Inner class that stores all of the info on the door.
	 */
	public class Door
	{
		public boolean isEnterable;
		public boolean locked;
		
		/*
		 * Gives the location of the door object.
		 */
		public void location()
		{
			return;
		}
		
		/*
		 * Gives the texture of the door object.
		 */
		public void texture()
		{
			return; 
		}
	}
	
	// Will be used to make the room
	Rectangle walls;
	
	/*
	 * Gives the location of the room object.
	 */
	public int[] location()
	{
		// Point is an array that will store the x and y values of the grid. 
		int[] point = new int[2];
		// The width and height of each grid pane is 25 and the rooms are automatically going to fit within them.
		point[0] = (int)walls.getX()/25;
		point[1] = (int)walls.getY()/25;
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
		return (int) walls.getWidth();
	}
	
	/*
	 * Gives the height of the room.
	 * The height is measured in pixels.
	 */
	public int height()
	{
		return (int) walls.getHeight();
	}
}
