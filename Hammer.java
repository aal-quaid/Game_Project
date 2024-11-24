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
            Game.print("Using the hammer, you break the bottle and you find some cash");
            Item cash = new Item("cash", "A wad of cash");
            Game.inventory.add(cash);
            Game.inventory.remove(Game.getItemInventory("bottle"));
    
        }
    }
}
