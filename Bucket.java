//import java.util.Iterator;
public class Bucket extends Item {
    public Bucket(String name, String description){
        super("bucket", "A blue, large bucket");
    }

    @Override
    public void use(){
        if(currentRoom.getRoomName().equals("Roof Top")){
            if(getItemInventory("filledBucket") != null){
                Game.print("Try to fill up the bathtub");
            }
            else{
                Game.print("Try to fill the bucket with somthing");
            }
        }

        else{
            if(getItemInventory("filledBucket") != null){
                Game.print("Try to use the bucket to fill somthing up");
            }
            else{
                Game.print("Try to fill the bucket with somthing");
            }
            
        }
        
    }

    @Override
    public void fill(){
        if(currentRoom.getRoomName().equals("Kitchen")){
            Game.print("You used the sink to fill the bucket");
            getItemInventory("bucket").setName("filledBucket");
            getItemInventory("filledBucket").setDescription("A blue, large bucket filled with water");
        }
        else{
            Game.print("You can't fill up the bucket here");
        }
    }
}
