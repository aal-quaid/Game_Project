public class BathTub extends Item {
    public BathTub(String name, String description){
        super("bathtub", "A large empty bathtub with lots of wires, looks like a machine\n");
    }

    @Override
    public void fill(){
        if(getItemInventory("filledBucket") != null){
            Game.print("You used the bucket of water to fill the bathtub\n");
            currentRoom.getItem("bathtub").setDescription("A large bathtub filled with water that is hooked up to a machine");
        }
        else{
            Game.print("You have nothing to fill the bathtub with.\n");
        }
    }

    @Override
    public void use(){
        if(currentRoom.getItem("bathtub").getDescription().equals("A large bathtub filled with water that is hooked up to a machine")){
            Game.print("You go in the bathtub and submerge yourself under water. You hear the machine power up and everything goes black.\n You wake up and find yourslef in an unknown area\n");
            currentRoom = World.buildDreamWorld();      // This will take the player to the dream world
        }
        else{
            Game.print("You cannot use the bathtub quite yet. The perperations have not been completed.\n");
        }
    }


}
