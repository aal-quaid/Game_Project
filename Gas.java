public class Gas extends Item {
    public Gas(String name, String description){
        super("gas", "A large gas tank");
    }

    @Override
    public void use(){
        if(Game.currentRoom.getRoomName().equals("Roof Top")){
            Game.print("You used the gas to fill up the helicopter. You then fly the hell out of there.\n");
        }

        else{
            Game.print("You can't use it here.\n");
        }
    }

    @Override
    public void open(){
        Game.print("Love the smell of gasoline.\n");
    }

}
