
/*
 * Helper class to Justin's pathfinder.
 */
public class AvailablePath {
	
	/*
	 * Checks to see if the spot is available to walk onto.
	 */
	public boolean isWalkable()
	{
		return false;
	}
	
	/*
	 * Checks a change in elevation or a change in building floor.
	 */
	public boolean isStairs()
	{
		return false;
	}
	
	/*
	 * Checks if the spot is "enterable".
	 */
	public boolean isDoor()
	{
		return false;
	}
	
	/*
	 * If is on a snowy day, construction, etc.
	 * Checks if the spot is able to be walked on.
	 * 
	 * *Could be omitted*
	 */
	public boolean isClear()
	{
		return false;
	}
}
