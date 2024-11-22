public class Robot extends Item{
    public Robot(String name, String description){
        super("robot", "a small robot with a shape of a diamond on top");
    }

    
    @Override
    public void use(){
        if(Game.getItemInventory("diamond") == null){
            Game.print("You can't use the robot because you don't have the item to activate it.\n");
        }

        else{
            Game.print("Use the diamond to activate the robot");
        }
    }
}
