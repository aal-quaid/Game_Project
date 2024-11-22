public class Diamond extends Item {
    public Diamond(String name, String description){
        super("diamond", "a sparkly diamond");
    }

    @Override
    public void use(){

        if(Game.getItemInventory("robot") == null){
            Game.print("Try putting the diamond in somthing");
        }

        else{
            Game.print("Using the dimaond, you activated the robot. The robot begins to speak:\n\"Hello Player! I think you will find this code to be useful: 56964! \"");
            
            if(Game.getItemInventory("code") == null){
                Code code = new Code("code", "Code: 56964");
                Game.inventory.add(code);
            }
            
        }
    }
}
