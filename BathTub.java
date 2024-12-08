public class BathTub extends Item {
    public BathTub(String name, String description){
        super("bathtub", "A large empty bathtub with lots of wires, looks like a machine");
    }

    @Override
    public void fill(){
        if(Game.getItemInventory("filledBucket") != null){
            Game.print("You used the bucket of water to fill the bathtub\n");
            Game.currentRoom.getItem("bathtub").setDescription("A large bathtub filled with water that is hooked up to a machine");
        }
        else{
            Game.print("You have nothing to fill the bathtub with.\n");
        }
    }

    @Override
    public void use(){
        if(Game.currentRoom.getItem("bathtub").getDescription().equals("A large bathtub filled with water that is hooked up to a machine") && Game.currentRoom.getRoomName().equals("Roof Top")){
            Game.print("You go in the bathtub and submerge yourself under water. You hear the machine power up and everything goes black.\nYou wake up and find yourself in an unknown area\n");
            Game.currentRoom = Game.currentRoom.getExit('d').getExit('d').getExit('s').getExit('s');      // This will take the player to the dream world
            Game.print(Game.currentRoom);
        }

        else if(Game.currentRoom.getRoomName().equals("Dream World")){
            Game.print("You use the bathtub again and submerged yourself underwater. You hear the machine power up and everything goes black.\nYou wake up and find yourself back on the roof top.\n");
            Game.currentRoom = Game.currentRoom.getExit('s').getExit('n').getExit('u').getExit('u');
            Game.print(Game.currentRoom);
        }
        else{
            Game.print("You cannot use the bathtub quite yet. The perperations have not been completed.\n");
        }
    }


}
