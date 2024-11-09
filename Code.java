public class Code extends Item {
    public Code(String name, String description){
        super("code", "Code: 56964");
    }

    @Override
    public void use(){
        Game.print("If you find a device, try opening it!\n");
    }
}
