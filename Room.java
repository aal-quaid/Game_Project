import java.util.HashMap;
import java.io.Serializable;


public class Room implements Serializable {
    private String name;
    private String desc_label;
    private Room east;
    private Room west;
    private Room north;
    private Room south;
    private Room up;
    private Room down;
    private HashMap<String, Item> items = new HashMap<String, Item>();
    private HashMap<String, NPC> npc = new HashMap<String, NPC>();

    private boolean lock;

    public Room(String n){
        name = n;
        Game.roomObjects.put(n, this);
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
        String s = this.getDescription(name);
        return s;
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

    public String getDescription(String n){
        for(String s : Game.rooms.keySet()){
            if(s.equals(n)){
                return Game.rooms.get(s);
            }
        }
        return null;
    }


    public void addNPC(String name, NPC x){
        npc.put(name, x);
    }

    public NPC getNPC(String name){
        return npc.get(name);
    }

    public void removeNPC(String name){
        npc.remove(name);
    }

}


