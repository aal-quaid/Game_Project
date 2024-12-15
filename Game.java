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
        gui = new GUI();
        Game.print(currentRoom);
    }

    private static GUI gui = new GUI();

    static ArrayList<Item> inventory = new ArrayList<Item>();       // Array list of the items in inventory
    static HashMap<String, String> rooms = new HashMap<String, String>();   // Hash map that store info about the room
    static HashMap<String, Room> roomObjects = new HashMap<String, Room>();     // Hash map that stores the room name and the room object

    public static Scanner input = new Scanner(System.in);           // public scanner
    static Room currentRoom = World.buildWorld();                   // public current room/ builds world

    public static boolean wear = false;

    public static void print(Object obj){
        gui.textArea.append((obj.toString()) + "\n");
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



    public static void processCommand(String command){


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
                    Game.print("You can't go that way.");

                else if(nextRoom.getLock() == true){
                    Game.print("This room is locked");
                }
                else{
                    currentRoom = nextRoom;
                    Game.print(currentRoom);
                }
                break;

            case "x":
                Game.print("Thanks for walking thorugh my game");
                break;

            case "take":
                Game.print("You are trying to take the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) == null)
                    Game.print("No items found\n");

                else if(words[1].equals("bathtub")){
                    Game.print("You can't take the bathtub. Are you crazy!?\n");
                }

                else if(words[1].equals("helicopter")){
                    Game.print("You can't pickup the helicopter. Are you crazy!?\n");
                }

                else if(words[1].equals("safe")){
                    Game.print("You can't pickup the safe, it's sooo heavy.");
                }

                else if(words[1].equals("computer")){
                    Game.print("I don't think so, it's one of those big PCs");
                }

                else{
                    inventory.add(currentRoom.getItem(words[1]));
                    Game.print("You picked up the " + currentRoom.getItem(words[1]).getName() + "\n");
                    currentRoom.addItem(words[1],null);
                    currentRoom.setRoomName(currentRoom.getRoomName()+"_A"); // changes the room description after the player picks an item up
                    //currentRoom.removeItem(words[1]);
                }
                break;

            case "i":
                if(inventory.size() == 0)
                    Game.print("You are carrying nothing\n");

                else{
                    for(Item i : inventory){
                        Game.print(i);
                    }
                    Game.print("\n");
                }
                break;
            
            case "look":

                if(currentRoom.getItem(words[1]) != null){
                    Game.print(currentRoom.getItem(words[1]).getDescription() + "\n");
                }


                else{
                    boolean found = false;

                    for(Item c : inventory){
                        if(c.getName().equals(words[1])){
                            Game.print(c.getDescription() + "\n");
                            found = true;
                        }
                    }

                    if(found == false)
                        Game.print("There is no such item.\n");
                }

                break;
            
            case "use":

                Game.print("You are trying to use the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).use();
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        Game.print("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).use();
                        Game.print("\n");
                    }
                }

                break;
            
            case "open":

                Game.print("You are trying to open the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).open();
                    Game.print("\n");
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        Game.print("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).open();
                        Game.print("\n");
                    }
                }

                break;
            
            case "fill":
                Game.print("You are trying to fill the " + words[1] + ".");
                
                if(currentRoom.getItem(words[1]) != null){
                    currentRoom.getItem(words[1]).fill();
                    Game.print("\n");
                }

                else{

                    if (getItemInventory(words[1]) == null){
                        Game.print("There is no such item");
                    }

                    else{
                        getItemInventory(words[1]).fill();
                        Game.print("\n");
                    }
                }

                break;

            case "talk":
                Game.print("You are trying to talk to the " + words[1] + ".");

                if(currentRoom.getNPC(words[1]) != null){
                    currentRoom.getNPC(words[1]).talk();
                    Game.print("\n");
                }

                else{
                    Game.print("There is no such thing!\n");
                }

                break;

            case "give":
                Game.print("You are tyring to give the " + words[1] + " to the " + words[3]);

                if(currentRoom.getNPC(words[3]) != null){
                    if(getItemInventory(words[1]) != null)
                    currentRoom.getNPC(words[3]).give(getItemInventory(words[1]));

                    else
                        Game.print("You don't have " + words[1]);
                }

                else{
                    Game.print("There is no such thing");
                }

                break;
            
            case "save":
                saveGame(words[1]);

                break;
            
            case "load":
                loadGame(words[1]);

                break;


            default:
                Game.print("I dont know what that means\n");
            }

    }
}
