
public class buildingBlocks
{

	// This is what the user names the room, so it can be the name of their class or something else.
	String name;
	
	// Says if the object type is a room, door, hallway, or something else.
	String type;
	
	// If the object is a room it will get the room number, which we're assuming will have a letter on the front.
	String rmNum;
	
	// Stores this information, so the pathfinder class and the user will be able to locate where the room is.
	int x;
	int y;
	int floor;
	
	public buildingBlocks(buildingBlocks koop)
	{
		name = koop.getName();
		type = koop.getType();
		rmNum = koop.getRoomNumber();
		x = koop.getX();
		y = koop.getY();
		floor = koop.getFloor();
		
	}
	// If the type is room it will have the extra string calling this constructor.
	public buildingBlocks(String n, String t, String room, int xa, int ya, int level)
	{
		name = n;
		type = t;
		rmNum = room;
		x = xa;
		y = ya;
		floor = level;
	}
	
	// For any type that isn't a room.
	public buildingBlocks(String n, String t, int xa, int ya, int level)
	{
		name = n;
		type = t;
		x = xa;
		y = ya;
		floor = level;
		rmNum = " ";
	}
	
	// For any type that isn't a room and doesn't have a name.
	public buildingBlocks(String t, int xa, int ya, int level)
	{
		name = " ";
		type = t;
		x = xa;
		y = ya;
		floor = level;
		rmNum = " ";
	}
	
	public String getName()
	{
		return name;
	}
	
	// Name is the only thing the user can edit, and this method will allow them to edit it.
	public void setName(String newName)
	{
		name = newName;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getRoomNumber()
	{
		return rmNum;
	}
	
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}

	public int getFloor()
	{
		return floor;
	}
}
