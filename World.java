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

        Room roofTop = new Room("Roof Top","You are on the roof top.");

        Room scienceRoom  = new Room("Science Room","You are in the science lab room.");

        Room principalOffice  = new Room("Principal Office", "You are in the principal's office.");

        Room restRoom  = new Room("Rest Room","You are in the rest room."); 

        Room storageRoom  = new Room("Storage Room","You are in the storage room."); 

        Item bottle = new Item("bottle", "Empty beer bottle");
        Item plunger = new Item("plunger", "Nasty plunger");
        Item shoes = new Item("shoes", "Black pair of shoes");
        Item ball = new Item("baseball", "Dirty baseball");

        Bucket bucket = new Bucket("bucket", "A blue large bucket");
        BathTub bathtub = new BathTub("bathtub", "A large empty bathtub");

        Computer computer = new Computer("computer", "the principal's computer");
        Robot robot = new Robot("robot", "a small robot");

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
        roofTop.setLock(true);
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
        kitchen.addItem("bucket", bucket);
        

        janitorCloset.addExit(schoolHall, 's'); // Janitor's closet
        janitorCloset.addItem("plunger", plunger);                   // plunger item

        secondFloor.addExit(schoolHall, 'd'); // Upstaris/rooms
        secondFloor.addExit(scienceRoom, 'w');
        secondFloor.addExit(roofTop, 'u');

        roofTop.addExit(secondFloor, 'd');
        roofTop.addItem("bathtub", bathtub);

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
        storageRoom.addItem("robot", robot);;       //robot item
        
        return schoolHall; // Starting Room
    }

    public static Room buildDreamWorld(){       // this creates the dream world and its' rooms.
        Room dreamWorld = new Room("Dream World", "You are in the dream world");

        Room gasStation = new Room("Gas Station", "You are in the gas station");

        dreamWorld.setLock(false);
        gasStation.setLock(false);

        Item container = new Item("container", "a huge fuel container");

        BathTub bathtub = new BathTub("bathtub", "A large bathtub filled with water that is hooked up to a machine");

        dreamWorld.addExit(gasStation, 'n');
        gasStation.addExit(dreamWorld, 's');

        dreamWorld.addItem("container", container);
        dreamWorld.addItem("bathtub", bathtub);

        return dreamWorld;
    }
}