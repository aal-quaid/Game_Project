public class Key extends Item{
    public Key(String name, String description){
        super("key", "Storage key");
    }

    @Override
    public void use(){
        if(currentRoom.getExit('d').getRoomName().equals("Storage Room")){
            Game.print("You used the key to open the storage room");
            currentRoom.getExit('d').setLock(false);
            
        }
        else
            Game.print("Try using it to open the storage room ");
    }
}
