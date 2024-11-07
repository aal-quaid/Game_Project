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
        Item key = new Item("key", "A gold key");
        Item shoes = new Item("shoes", "Black pair of shoes");
        Item ball = new Item("baseball", "Dirty baseball");

        Combination combination = new Combination("combination", "combination for the black safe");
        Safe safe = new Safe("safe", "It's an impressive safe!");




        schoolHall.addExit(frontDoor, 's'); //School Hall
        schoolHall.addExit(gym, 'w');
        schoolHall.addExit(cafeteria, 'e');
        schoolHall.addExit(janitorCloset, 'n');
        schoolHall.addExit(secondFloor, 'u');
        schoolHall.addExit(storageRoom, 'd');
        schoolHall.setLock(false);

        frontDoor.addExit(schoolHall, 'n'); //Front door(exit)
        frontDoor.setLock(true);


        gym.addExit(schoolHall, 'e'); // Gym/lockers
        gym.addExit(lockerRoom, 'n');
        gym.setLock(false);

        lockerRoom.addExit(gym, 's');

        lockerRoom.addItem("bottle", bottle);             // Bottle item
        lockerRoom.addItem("shoes", shoes);             // show item
        lockerRoom.addItem("baseball", ball);             // baseball item

        lockerRoom.setLock(false);

        cafeteria.addExit(schoolHall, 'w'); // Cafeteria/Kitchen
        cafeteria.addExit(kitchen, 'e');
        cafeteria.setLock(false);
        kitchen.addExit(cafeteria, 'w');
        kitchen.setLock(false);

        janitorCloset.addExit(schoolHall, 's'); // Janitor's closet
        janitorCloset.setLock(false);

        janitorCloset.addItem("plunger", plunger);                   // plunger item

        secondFloor.addExit(schoolHall, 'd'); // Upstaris/rooms
        secondFloor.addExit(scienceRoom, 'w');
        secondFloor.setLock(false);
        scienceRoom.addExit(secondFloor, 'e');
        scienceRoom.setLock(false);

        scienceRoom.addItem("combination", combination); // combination

        secondFloor.addExit(principalOffice, 'e');
        principalOffice.addExit(secondFloor, 'w');
        principalOffice.setLock(false);

        principalOffice.addItem("key",key);               // Key item

        secondFloor.addExit(restRoom, 'n');
        restRoom.addExit(secondFloor, 's');
        restRoom.setLock(false);

        storageRoom.addExit(schoolHall, 'u'); // Storage room
        storageRoom.addItem("safe", safe); // safe
        storageRoom.setLock(true);


        return schoolHall; // Starting Room
    }
}