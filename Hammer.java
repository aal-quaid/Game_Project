public class Hammer extends Item {
    public Hammer(String name, String description){
        super("hammer", "A strong hammer");
    }

    @Override
    public void use(){

        if(Game.getItemInventory("bottle") == null){
            Game.print("You don't have anything to use the hammer on.\n");
        }

        else{
            Game.print("Using the hammer, you break the bottle and you find some cash and a combination");
            Item cash = new Item("cash", "A wad of cash");
            Combination combination = new Combination("conbination", "Combination to the black safe");
            Game.inventory.add(cash);
            Game.inventory.add(combination);
            Game.inventory.remove(Game.getItemInventory("bottle"));
    
        }
    }
}
