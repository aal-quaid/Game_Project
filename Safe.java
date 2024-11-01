public class Safe extends Item{
    public Safe(String name, String description){
        super("Safe", "A black safe");
    }

    @Override
    public void open(){
        boolean bool = false;

        for(Item c : super.inventory){
            if(c.getName().equals("Combination")){
                Game.print("Using the combination, you open the safe and find a diamond inside! Naturally, you pocket the diamond.");
                Item diamond = new Item("diamond", "A sparkley diamond");
                inventory.add(diamond);
                bool = true;
            }
        }

        if(bool == false)
            Game.print("The safe is locked and you don't have the combination");

    }
    
}

