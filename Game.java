import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        runGame();
    }

    public static void print(Object obj){
        System.out.println(obj.toString());
    }

    static Room currentRoom = World.buildWorld();

    public static Room getCurrentRoom(){
        return currentRoom;
    }

    public static Item getItemInventory(String name){
        for(Item c : inventory){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    static ArrayList<Item> inventory = new ArrayList<Item>();


    public static void runGame(){
        Scanner input = new Scanner(System.in);

        String command; // Player's command
        do{
            System.out.println(currentRoom);
            System.out.print("Where do you want to go? ");
            command = input.nextLine();
            String[] words = command.split(" ");

            switch(words[0]){
            case "e":
            case "w":
            case "n":
            case "s":
            case "u":
            case "d":
            
                Room nextRoom = currentRoom.getExit(command.charAt(0));

                if(nextRoom == null)
                    System.out.println("You can't go that way.");

                else if(nextRoom.getLock() == true){
                    System.out.println("This room is locked");
                }
                else
                    currentRoom = nextRoom;
                break;

            case "x":
                System.out.println("Thanks for walking thorugh my game");
                break;

            case "take":
                System.out.println("You are trying to take the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) == null)
                    System.out.println("No items found\n");

                else{
                    inventory.add(currentRoom.getItem(words[1]));
                    System.out.println("You picked up the " + currentRoom.getItem(words[1]).getName() + "\n");
                    currentRoom.addItem(words[1],null);
                    //currentRoom.removeItem(words[1]);
                }
                break;

            case "i":
                if(inventory.size() == 0)
                    System.out.println("You are carrying nothing\n");

                else{
                    for(Item i : inventory){
                        System.out.println(i);
                    }
                    System.out.println();
                }
                break;
            
            case "look":

                if(currentRoom.getItem(words[1]) != null){
                    System.out.println(currentRoom.getItem(words[1]).getDescription() + "\n");
                }


                else{
                    boolean found = false;

                    for(Item c : inventory){
                        if(c.getName().equals(words[1])){
                            System.out.println(c.getDescription() + "\n");
                            found = true;
                        }
                    }

                    if(found == false)
                        System.out.println("There is no such item.\n");
                }

                break;
            
            case "use":

                System.out.println("You are trying to use the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).use();
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        System.out.println("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).use();
                        System.out.println();
                    }
                }

                break;
            
            case "open":

                System.out.println("You are trying to open the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).open();
                    System.out.println();
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        System.out.println("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).open();
                        System.out.println();
                    }
                }

                break;

            default:
                System.out.println("I dont know what that means\n");
            }


        } while(!command.equals("x"));

        input.close();
    }
}
