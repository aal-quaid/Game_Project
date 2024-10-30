package Game;

//import java.util.HashMap;

public class World {
    // Builds the game world.
    // Returns the room the player starts in.
    public static Room buildWorld() {

        Room schoolHall = new Room("You are in the school hall.");

        Room frontDoor = new Room("You are at the front door.");

        Room gym = new Room("You are in the gym.");

        Room lockerRoom = new Room("You are in the locker Room.");

        Room cafeteria = new Room("You are in the cafeteria.");

        Room kitchen = new Room("You are in the kitchen.");

        Room janitorCloset  = new Room("You are in the janitor's closet.");

        Room secondFloor  = new Room("You are on the second floor.");

        Room scienceRoom  = new Room("You are in the science lab room.");

        Room principalOffice  = new Room("You are in the principal's office.");

        Room restRoom  = new Room("You are in the rest room."); 

        Room storageRoom  = new Room("You are in the storage room."); 

        Item bottle = new Item("bottle", "Empty beer bottle");
        Item plunger = new Item("plunger", "Nasty plunger");
        Item key = new Item("key", "A gold key");
        Item shoes = new Item("shoes", "Black pair of shoes");
        Item ball = new Item("baseball", "Dirty baseball");



        schoolHall.addExit(frontDoor, 's'); //School Hall
        schoolHall.addExit(gym, 'w');
        schoolHall.addExit(cafeteria, 'e');
        schoolHall.addExit(janitorCloset, 'n');
        schoolHall.addExit(secondFloor, 'u');
        schoolHall.addExit(storageRoom, 'd');

        frontDoor.addExit(schoolHall, 'n'); //Front door(exit)

        gym.addExit(schoolHall, 'e'); // Gym/lockers
        gym.addExit(lockerRoom, 'n');
        lockerRoom.addExit(gym, 's');

        lockerRoom.addItem("bottle", bottle);             // Bottle item
        lockerRoom.addItem("shoes", shoes);             // show item
        lockerRoom.addItem("baseball", ball);             // baseball item

        cafeteria.addExit(schoolHall, 'w'); // Cafeteria/Kitchen
        cafeteria.addExit(kitchen, 'e');
        kitchen.addExit(cafeteria, 'w');

        janitorCloset.addExit(schoolHall, 's'); // Janitor's closet

        janitorCloset.addItem("plunger",plunger);                   // plunger item

        secondFloor.addExit(schoolHall, 'd'); // Upstaris/rooms
        secondFloor.addExit(scienceRoom, 'w');
        scienceRoom.addExit(secondFloor, 'e');
        secondFloor.addExit(principalOffice, 'e');
        principalOffice.addExit(secondFloor, 'w');

        principalOffice.addItem("key",key);               // Key item

        secondFloor.addExit(restRoom, 'n');
        restRoom.addExit(secondFloor, 's');

        storageRoom.addExit(schoolHall, 'u'); // Storage room


        return schoolHall; // Starting Room
    }
}