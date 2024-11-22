public class World {
    // Builds the game world.
    // Returns the room the player starts in.
    public static Room buildWorld() {

        Room schoolHall = new Room("School Hall");

        Room frontDoor = new Room("Front Door");

        Room gym = new Room("Gym");

        Room lockerRoom = new Room("Locker Room");

        Room cafeteria = new Room("Cafeteria");

        Room kitchen = new Room("Kitchen");

        Room janitorCloset  = new Room("Janitor Closet");

        Room secondFloor  = new Room("Second Floor");

        Room roofTop = new Room("Roof Top");

        Room scienceRoom  = new Room("Science Room");

        Room principalOffice  = new Room("Principal Office");

        Room restRoom  = new Room("Rest Room"); 

        Room storageRoom  = new Room("Storage Room"); 

        Room dreamWorld = new Room("Dream World");

        Room gasStation = new Room("Gas Station");

        Item bottle = new Item("bottle", "Empty beer bottle");
        Item hammer = new Item("hammer", "a small hammer");
        Item costume = new Item("costume", "A were-wolf costume");

        Bucket bucket = new Bucket("bucket", "A blue large bucket");
        BathTub bathtub = new BathTub("bathtub", "A large empty bathtub");

        Computer computer = new Computer("computer", "the principal's computer");
        Robot robot = new Robot("robot", "a small robot");

        Combination combination = new Combination("combination", "combination for the black safe");
        Safe safe = new Safe("safe", "It's an impressive safe!");
        Key key = new Key("key", "A gold key");


        Puppy puppy = new Puppy("puppy", "A hideous puppy wags his tail.");


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

        frontDoor.addExit(dreamWorld, 's');

        dreamWorld.addExit(frontDoor, 'n');
        dreamWorld.addExit(gasStation, 's');    //Dream world
        dreamWorld.addItem("bathtub", bathtub);

        gasStation.addExit(dreamWorld, 'n');
        
        gym.addExit(schoolHall, 'e'); // Gym/lockers
        gym.addExit(lockerRoom, 'n');
    
        lockerRoom.addExit(gym, 's');
        lockerRoom.addItem("bottle", bottle);             // Bottle item
        lockerRoom.addItem("costume", costume);             // costume item

        

        cafeteria.addExit(schoolHall, 'w'); // Cafeteria/Kitchen
        cafeteria.addExit(kitchen, 'e');
        cafeteria.addNPC("puppy", puppy);
        
        kitchen.addExit(cafeteria, 'w');
        kitchen.addItem("bucket", bucket);
        

        janitorCloset.addExit(schoolHall, 's'); // Janitor's closet
        janitorCloset.addItem("hammer", hammer);                   // plunger item

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
}