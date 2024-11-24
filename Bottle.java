public class Bottle extends Item {
    public Bottle(String name, String description){
        super("bottle", "A glass bottle, There appears to be somthing inside");
    }

    @Override
    public void open(){ 
        Game.print("Try using somthing to open the bottle");
    }
}
