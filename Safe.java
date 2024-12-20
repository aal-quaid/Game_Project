public class Safe extends Item{
    public Safe(String name, String description){
        super("safe", "A black safe");
    }

    @Override
    public void open(){

        if(Game.getItemInventory("combination") == null){
            Game.print("The safe is locked and you don't have the combination");
        }

        else{
            Game.print("Using the combination, you open the safe and find a diamond inside! Naturally, you pocket the diamond.");
            
            if(Game.getItemInventory("diamond") == null){
                Diamond diamond = new Diamond("diamond", "A sparkley diamond");
                Game.inventory.add(diamond);
            }
    
        }
    }
}

