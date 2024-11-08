public class World {
    // Builds the game world.
    // Returns the room the player starts in.
    public static Room buildWorld() {

        Room schoolHall = new Room("School Hall","You are in the school hall.");

        Room frontDoor = new Room("Front Door","You are at the front door.");

        Room gym = new Room("Gym","You are in the gym.");

        Room lockerRoom = new Room("Locker Room","You are in the locker Room.");

        Room cafeteria = new Room("Cafeteria", "You are in the cafeteria.");

        Room kitchen = new Room("Kitchen","You are in the kitchen.");

        Room janitorCloset  = new Room("Janitor Closet","You are in the janitor's closet.");

        Room secondFloor  = new Room("Second Floor", "You are on the second floor.");

        Room scienceRoom  = new Room("Science Room","You are in the science lab room.");

        Room principalOffice  = new Room("Principal Office", "You are in the principal's office.");

        Room restRoom  = new Room("Rest Room","You are in the rest room."); 

        Room storageRoom  = new Room("Storage Room","You are in the storage room."); 

        Item bottle = new Item("bottle", "Empty beer bottle");
        Item plunger = new Item("plunger", "Nasty plunger");
        Item shoes = new Item("shoes", "Black pair of shoes");
        Item ball = new Item("baseball", "Dirty baseball");

        Item computer = new Item("computer", "the principal's computer");

        Combination combination = new Combination("combination", "combination for the black safe");
        Safe safe = new Safe("safe", "It's an impressive safe!");
        Key key = new Key("key", "A gold key");


        frontDoor.setLock(true);
        schoolHall.setLock(false);
        gym.setLock(false);
        lockerRoom.setLock(false);
        cafeteria.setLock(false);
        kitchen.setLock(false);
        janitorCloset.setLock(false);
        secondFloor.setLock(false);
        scienceRoom.setLock(false);
        principalOffice.setLock(false);
        restRoom.setLock(false);
        storageRoom.setLock(true);


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
        janitorCloset.addItem("plunger", plunger);                   // plunger item

        secondFloor.addExit(schoolHall, 'd'); // Upstaris/rooms
        secondFloor.addExit(scienceRoom, 'w');
        scienceRoom.addExit(secondFloor, 'e');
        

        scienceRoom.addItem("combination", combination); // combination

        secondFloor.addExit(principalOffice, 'e');
        principalOffice.addExit(secondFloor, 'w');
        
        principalOffice.addItem("key",key);               // Key item
        principalOffice.addItem("computer", computer);      // computer item

        secondFloor.addExit(restRoom, 'n');
        restRoom.addExit(secondFloor, 's');
        
        storageRoom.addExit(schoolHall, 'u'); // Storage room
        storageRoom.addItem("safe", safe); // safe
        
        return schoolHall; // Starting Room
    }
}