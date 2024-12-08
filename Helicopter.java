public class Helicopter extends Item {
    public Helicopter(String name, String description) {
        super("helicopter", "A mini helicopter");
    }

    @Override
    public void use(){
        if(Game.getItemInventory("gas") != null){
            Game.print("You used the gas to fill up the helicopter. You then fly the hell out of there.\n");
        }

        else{
            Game.print("You can't use it yet, it has no gas\n");
        }
    }
}
