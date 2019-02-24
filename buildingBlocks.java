
public class buildingBlocks
{

	// This is what the user names the room, so it can be the name of their class or something else.
	String name;
	
	// Says if the object type is a room, door, hallway, or something else.
	String type;
	
	// If the object is a room it will get the room number, which we're assuming will have a letter on the front.
	String rmNum;
	
	// Stores this information, so the user will be able to locate where the room is.
	int x;
	int y;
	
	public buildingBlocks(buildingBlocks koop)
	{
		name = koop.getName();
		type = koop.getType();
		rmNum = koop.getRoomNumber();
		x = koop.getX();
		y = koop.getY();
		
	}
	// If the type is room it will have the extra string calling this constructor.
	public buildingBlocks(String n, String t, String room, int xa, int ya)
	{
		name = n;
		type = t;
		rmNum = room;
		x = xa;
		y = ya;
	}
	
	// For any type that isn't a room.
	public buildingBlocks(String n, String t, int xa, int ya)
	{
		name = n;
		type = t;
		x = xa;
		y = ya;
		rmNum = " ";
	}
	
	// For any type that isn't a room and doesn't have a name.
	public buildingBlocks(String t, int xa, int ya)
	{
		name = " ";
		type = t;
		x = xa;
		y = ya;
		rmNum = " ";
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	// Can't edit the type because we don't want errors.
	public String getType()
	{
		return type;
	}
	
	public String getRoomNumber()
	{
		return rmNum;
	}
	
	public void setRoomNumber(String rum)
	{
		rmNum = rum;
	}
	
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
