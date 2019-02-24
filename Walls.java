
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

public class Walls extends Rectangle {
	
	private Rectangle customWall;
	private buildingBlocks info;
	private boolean traversable;
	
	// If they only choose one block of the grid the block will automatically be 25 in width and height.
	public Walls(int x, int y)
	{
		traversable = false;
		customWall = RectangleBuilder.create().x(x).y(y).width(25).height(25).fill(new ImagePattern(new Image("file:25 by 25 Grey Wall.png"), 0, 0, 1, 1, true)).build();;
		info = new buildingBlocks("Wall", x, y, 1);
	}
	
	// This is in case we have enough time to allow them to select multiple blocks at one time.
	public Walls(int x, int y, int width, int height)
	{
		traversable = false;
		customWall = RectangleBuilder.create().x(x).y(y).width(width).height(width).fill(new ImagePattern(new Image("file:25 by 25 Grey Wall.png"), 0, 0, 1, 1, true)).build();
		info = new buildingBlocks("Wall", x, y, 1);
	}
	
	public Walls(int x, int y, String wall)
	{
		traversable = true;
		customWall = RectangleBuilder.create().x(x).y(y).width(25).height(25).fill(new ImagePattern(new Image("file:25 by 25 Door.png"), 0, 0, 1, 1, true)).build();
		info = new buildingBlocks("Wall", x, y, 1);
	}
	
	public Walls(double width, double height)
	{
		traversable = false;
		customWall = RectangleBuilder.create().width(width).height(height).fill(new ImagePattern(new Image("file:25 by 25 Grey Wall.png"), 0, 0, 1, 1, true)).build();
		info = new buildingBlocks("Wall", 0, 0, 1);
	}
	
	// Returns x coordinate of of the upper left hand corner of the block.
	public int getXAxe()
	{
		return (int)customWall.getX();
	}
	
	// Returns y coordinate of of the upper left hand corner of the block.
	public int getYAxe()
	{
		return (int)customWall.getY();
	}
	
	// Returns the width of the block.
	public int getWid()
	{
		return (int)customWall.getWidth();
	}
	
	//Returns the height of the block.
	public int getHei()
	{
		return (int)customWall.getHeight();
	}
	
	// Will be used to so we can easily write the data into a text file.
	public buildingBlocks write()
	{
		return info;
	}
	
	// Returns the shape of the wall allowing it to be added to a pane.
	public Rectangle getShape()
	{
		return customWall;
	}
	
	// These methods will help out later when we setup path finding.
	// ==============================================================
	public boolean getTravel()
	{
		return traversable;
	}
	
	public void setTraversable(boolean maybe)
	{
		traversable = maybe;
	}
	// ==============================================================
}
