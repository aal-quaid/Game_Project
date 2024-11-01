public class Combination extends Item{
    public Combination(String name, String description){
        super("Combination", "Combination to the black safe");
    }

    @Override
    public void use(){
        Game.print("If you find a safe, try opening it!");
    }
}
