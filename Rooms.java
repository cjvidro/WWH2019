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
	int width;
	int height;
	int x;
	int y;

	public Rooms(int width, int height)
	{
		this.width = width;
		this.height = height;
		Rectangle[][] room = new Rectangle[width/25][height/25];
		outerWalls = new Walls(25, 25);
		innerArea = new Floors(25, 25);
		pane = new Group();
		x = 0;
		y = 0;
		info = new buildingBlocks("Room", x, y);
		for(int r = 0; r < width/25; r++)
		{
			for(int c = 0; c < height/25; c++)
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
	
	public Rooms(int x, int y, int width, int height, String name)
	{
		this.width = width;
		this.height = height;
		Rectangle[][] room = new Rectangle[width/25][height/25];
		outerWalls = new Walls(25, 25);
		innerArea = new Floors(25, 25);
		this.x = x;
		this.y = y;
		pane = new Group();
		info = new buildingBlocks("Room", 0, 0);
		for(int r = 0; r < width/25; r++)
		{
			for(int c = 0; c < height/25; c++)
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
	 * Gives the width of the room.
	 * The width is measured in pixels.
	 */
	public int width()
	{
		return width;
	}
	
	/*
	 * Gives the height of the room.
	 * The height is measured in pixels.
	 */
	public int height()
	{
		return height;
	}
	
	public buildingBlocks write()
	{
		return info;
	}
	
	public void setName(String name)
	{
		info.setName(name);
	}
	
	public String getName()
	{
		return info.getName();
	}
	
	public void setRoomNum(String num)
	{
		info.setRoomNumber(num);
	}
	
	public String getRoomNum()
	{
		return info.getRoomNumber();
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
	
	public int getX()
	{
		return x;
	}
	
	public void setX(int x)
	{
		info.setX(x);
		this.x = x;
	}
	
	public int getY()
	{
		return y;
	}
	
	
	public void setY(int y)
	{
		info.setY(y);
		this.y = y;
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

