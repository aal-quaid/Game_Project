public class Software extends Item {
    public Software(String name, String description){
        super("software", "a system that can unlock the front door");

    }

    @Override
    public void use(){
        if(currentRoom.getExit('s') == null){
            Game.print("Try using it to unlock the front door\n");
        }
        else if(currentRoom.getExit('s').getRoomName().equals("Front Door")){
            Game.print("You used the system to open the Front Door\n");
            currentRoom.getExit('s').setLock(false);
            
        }
        else
            Game.print("Try using it to unlock the front door\n");
    }
}
