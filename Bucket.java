public class Bucket extends Item {
    public Bucket(String name, String description){
        super("bucket", "A blue, large bucket");
    }

    @Override
    public void use(){
        if(Game.currentRoom.getRoomName().equals("Roof Top")){
            if(Game.getItemInventory("filledBucket") != null){
                Game.print("Try to fill up the bathtub");
            }
            else{
                Game.print("Try to fill the bucket with somthing");
            }
        }

        else{
            if(Game.getItemInventory("filledBucket") != null){
                Game.print("Try to use the bucket to fill somthing up");
            }
            else{
                Game.print("Try to fill the bucket with somthing");
            }
            
        }
        
    }

    @Override
    public void fill(){
        if(Game.currentRoom.getRoomName().equals("Kitchen_A")){
            Game.print("You used the sink to fill the bucket");
            Game.getItemInventory("bucket").setName("filledBucket");
            Game.getItemInventory("filledBucket").setDescription("A blue, large bucket filled with water");
            Game.processCommand("x");
        }
        else{
            Game.print("You can't fill up the bucket here");
        }
    }
}
