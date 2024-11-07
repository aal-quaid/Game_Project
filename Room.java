import java.util.HashMap;

public class Room {
    private String description;
    private String name;
    private Room east;
    private Room west;
    private Room north;
    private Room south;
    private Room up;
    private Room down;
    private HashMap<String, Item> items = new HashMap<String, Item>();

    private boolean lock;

    public Room(String n, String desc){
        description = desc;
        name = n;
    }

    public Room getExit(char x){
        if (x == 'e')
            return east;
        
        else if (x == 'w')
            return west;
        
        else if (x == 'n')
            return north;
        
        else if (x == 's')
            return south;
        
        else if (x == 'u')
            return up;
        
        else if (x == 'd')
            return down;
        
        return null;
    }

    public void addExit(Room room, char direction){
        if(direction == 'e')
            east = room;

        else if(direction == 'w')
            west = room;
        
        else if(direction == 'n')
            north = room;
        
        else if(direction == 's')
            south = room;
        
        else if(direction == 'u')
            up = room;
        
        else if(direction == 'd')
            down = room;
        
    }

    public String toString(){
        return description;
    }


    public void addItem(String name, Item i){
        items.put(name, i);
    }

    public Item getItem(String name){
        return items.get(name);
    }

    public void removeItem(String name){
        items.remove(name);
    }

    public void setLock(boolean bool){
        lock = bool;
    }

    public boolean getLock(){
        return lock;
    }

    public void setRoomName(String n){
        name = n;
    }

    public String getRoomName(){
        return name;
    }

}


