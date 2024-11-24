public class Costume extends Item {
    public Costume(String name, String description){
        super("costume", "A were-wolf costume. Appears to be in your size.");
    }

    @Override
    public void use(){
        Game.print("You decide to wear the costume. It's a little tight in some places, but it fits. You look very scary now.\n");
        Game.wear = true;
    }
}

