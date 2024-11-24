import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Game{
    public static void main(String[] args) {
        textFile();
        runGame();
    }

    static ArrayList<Item> inventory = new ArrayList<Item>();       // Array list of the items in inventory
    static HashMap<String, String> rooms = new HashMap<String, String>();   // Hash map that store info about the room
    static HashMap<String, Room> roomObjects = new HashMap<String, Room>();     // Hash map that stores the room name and the room object

    public static Scanner input = new Scanner(System.in);           // public scanner
    static Room currentRoom = World.buildWorld();                   // public current room/ builds world

    public static boolean wear = false;

    public static void print(Object obj){
        System.out.println(obj.toString());
    }

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

    public static void textFile(){
        try {
            Scanner input = new Scanner(new File("Description.txt"));
            while(input.hasNextLine()) {
                String name = input.nextLine();
                String desc = input.nextLine();

                if(!name.equals("#") && !desc.equals("#")){
                    rooms.put(name, desc);
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
        }
    }

    public static void saveGame(String fileName) {
        File f = new File(fileName);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream stream = new ObjectOutputStream(fos);
            stream.writeObject(currentRoom);
            stream.writeObject(inventory);
            stream.writeObject(roomObjects);
            stream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File "+fileName+" not found.");
        } catch (IOException ex) {
            System.out.println("Bummers, man");
        }
    }

    public static void loadGame(String fileName) {
        File f = new File(fileName);
        try {
            FileInputStream fos = new FileInputStream(f);
            ObjectInputStream stream = new ObjectInputStream(fos);
            currentRoom = (Room) stream.readObject();
            inventory = (ArrayList) stream.readObject();
            roomObjects = (HashMap) stream.readObject();
            stream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File "+fileName+" not found.");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Bummers, man");
        } catch (ClassNotFoundException ex) {
            System.out.println("Not an object.");
        }
    }



    public static void runGame(){

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

                else if(words[1].equals("bathtub")){
                    System.out.println("You can't take the bathtub. Are you crazy!?\n");
                }

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
            
            case "fill":
                System.out.println("You are trying to fill the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).fill();
                    System.out.println();
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        System.out.println("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).fill();
                        System.out.println();
                    }
                }

                break;

            case "talk":
                System.out.println("You are trying to talk to the " + words[1] + ".");

                if(currentRoom.getNPC(words[1]) != null){
                    currentRoom.getNPC(words[1]).talk();
                    System.out.println();
                }

                else{
                    System.out.println("There is no such thing!\n");
                }

                break;
            
            case "save":
                saveGame(words[1]);

                break;
            
            case "load":
                loadGame(words[1]);

                break;


            default:
                System.out.println("I dont know what that means\n");
            }


        } while(!command.equals("x"));

        input.close();
    }
}
