public class Software extends Item {
    public Software(String name, String description){
        super("software", "a system that can unlock the front door");

    }

    @Override
    public void use(){
        if(Game.currentRoom.getExit('u') == null){
            Game.print("Try using it to unlock some place\n");
        }
        else if(Game.currentRoom.getExit('u').getRoomName().equals("Roof Top")){
            Game.print("You used the system. You can now access the roof top\n");
            Game.currentRoom.getExit('u').setLock(false);
            
        }

        else if(Game.currentRoom.getExit('s').getRoomName().equals("Front Door")){
            Game.print("It appears that you cannot use the system to unlock the front door.\n");
        }

        else
            Game.print("Try using it to unlock some place\n");
    }
}
