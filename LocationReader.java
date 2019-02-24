import java.util.Scanner;

import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;

public class LocationReader {

    int number = 0;
    private Pane pane;
    private ArrayList<buildingBlocks> info;

    public LocationReader() {
        pane = new Pane();
        info = new ArrayList<buildingBlocks>();
    }

    public void loadLocations(String filename) {


        File file = new File(filename);
        if(!file.exists())
        {
        	throw new RuntimeException("File not found: " + filename);
        }
        Scanner scan = null;

        try
        {
            scan = new Scanner(file);
            
            while(scan.hasNext())
            {
            	String command = scan.next();
            	{
            		if(command.equalsIgnoreCase("room"))
            		{
            			int x = scan.nextInt();
            			int y = scan.nextInt();
            			int width = scan.nextInt();
            			int height = scan.nextInt();
            			String name = scan.next();
            			Rooms room = new Rooms(x, y, width, height, name);
            			info.add(room.write());
            			pane.getChildren().addAll(room.getFloor(), room.getWall());
            		}
            		else if(command.equalsIgnoreCase("door"))
            		{
            			int x = scan.nextInt();
            			int y = scan.nextInt();
            			Doors door = new Doors(x, y);
            			info.add(door.write());
            			pane.getChildren().add(door.getShape());
            		}
            		else if (command.equalsIgnoreCase("wall"))
            		{
            			int x = scan.nextInt();
            			int y = scan.nextInt();
            			Walls wall = new Walls(x, y);
            			info.add(wall.write());
            			pane.getChildren().add(wall.getShape());
            		}
            		else if (command.equalsIgnoreCase("floor"))
            		{
            			int x = scan.nextInt();
            			int y = scan.nextInt();
            			Floors floor = new Floors(x, y);
            			info.add(floor.write());
            			pane.getChildren().add(floor.getShape());
            		}
            	}
            }
        }
        catch(FileNotFoundException e)
        {
        	e.printStackTrace();
        }
        finally
        {
        	if(scan != null)
        		scan.close();
        }
    }


    public void writeLocations(String filename) {

        File file = new File(filename);

        try (PrintWriter output = new java.io.PrintWriter(file)) {
        	for(int i = 0; i < info.size(); i++)
        	{
        		buildingBlocks shape = new buildingBlocks(info.get(i));
        		output.write(shape.getType());
        		output.write(shape.getRoomNumber());
        		output.write(shape.getName());
        		output.write(shape.getX());
        		output.write(shape.getY());
        	}

        	output.close();
        } 
        catch (FileNotFoundException e) {

            e.printStackTrace();

        }

    }
    
    public ArrayList<buildingBlocks> getInfo()
    {
    	return info;
    }
    
    public void addToInfo(buildingBlocks moreInfo)
    {
    	info.add(moreInfo);
    }
    
    public void overwriteInfo(ArrayList<buildingBlocks> newInfo)
    {
    	info = newInfo;
    }
    
    public Pane getPane()
    {
    	return pane;
    }

}
