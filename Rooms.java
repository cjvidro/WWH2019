import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rooms{
	
	// This is used to show where the grid walls are.
	Walls outerWalls;
	Floors innerArea;
	String roomNumber;
	buildingBlocks info;
	Group pane;
	
	
	public Rooms(int width, int height)
	{
		Rectangle[][] room = new Rectangle[width/25][height/25];
		outerWalls = new Walls(25, 25);
		innerArea = new Floors(25, 25);
		pane = new Group();
		info = new buildingBlocks(" ", " ", "Room", 0, 0, 1);
		for(int r = 0; r < room.length; r++)
		{
			for(int c = 0; c < room.length; c ++)
			{
				if(r == 0 || r == room.length - 1 || c == 0 || c == room[r].length - 1)
				{
					room[r][c] = outerWalls.getShape();
					NodeWall node = new NodeWall(25*c, 25*r, 25, 25);
					pane.getChildren().addAll(node);
				}
					
				else
				{
					room[r][c] = innerArea.getShape();
					NodeFloor node = new NodeFloor(25*c, 25*r, 25, 25);
					pane.getChildren().addAll(node);
				}
			}
		}
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
	
	public Group getRoom() 
	{
		return pane;
	}
	
    public static class NodeFloor extends StackPane {

        public NodeFloor( int x, int y, double width, double height) {
            Floors floor = new Floors( width, height);
          

            // set position
            setTranslateX( x);
            setTranslateY( y);

            getChildren().addAll( floor.getShape());

        }

    }
    
    public static class NodeWall extends StackPane {

        public NodeWall( int x, int y, double width, double height) {
            Walls wall = new Walls( width, height);
          

            // set position
            setTranslateX( x);
            setTranslateY( y);

            getChildren().addAll( wall.getShape());

        }

    }
	
}

