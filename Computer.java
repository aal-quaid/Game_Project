public class Computer extends Item {
    public Computer(String name, String description){
        super("computer", "principal's computer");

    }

    public void open(){

        if(getItemInventory("code") == null){
            Game.print("You don't have the passcode to unlock this divice");
        }

        else{
            Game.print("Using the code you received from the robot, you unlock the computer.\n");
            Game.print("As you browse thorugh the laptop, you find the secruity system that can unlock the front door in the school hall");
            Game.print("You can now use the software");

            if(getItemInventory("software") == null){
                Software software = new Software("software", "a system that can unlock the front door");
                inventory.add(software);
            }
        }
    }
}
