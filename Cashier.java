public class Cashier extends NPC {
    public Cashier(String name, String description) {
        super("cashier", "A cashier with a mean face.");
    }

    int choice = 0;

    @Override
    public void talk() {
        if(Game.getItemInventory("gas") == null){

            if(Game.wear == false){
                say("Don't bother me! Can't you see that i'm watching a video!\n");
                String[] options = {
                    "Can't you just help me out? I just need some gas",
                    "What are you watching?"
                };
                getResponse(options);

                if(choice == 2){
                    String[] options2 = {
                        "Werewolves aren't real.",
                        "I've actually seen one around these parts before."
                    };
                    getResponse(options2);
                }
            }

            else{
                say("Don't bother me! Can't you see that i'm watching a- OH MY GOD!!!!");
                say("A REAL WEREWOLF! PLEASE DON'T EAT ME!!!\n");
                String[] options = {
                    "GRRR I order you to give me a tank full of gas",
                    "GRRRRRRRRRRRRRRRRRRR"
                };
                getResponse(options);

                if(choice == 2){
                    String[] options2 = {
                        "I demand a tank filled with gas. NOW!!!",
                        "Then you better give me a tank filled with gas before I change my mind and eat you! GRRR!."
                    };
                    getResponse(options2);
                }
            }

            choice = 0;

        }

        else{
            Game.print("We got what we need from him. Let's not give him another heart attack.\n");
        }
    }

    @Override
    public void response(int option) {
        if(Game.wear == false && choice == 0){
            switch(option) {
                case 1:
                    say("No can do. I'm currently on my break. Now get lost!\n");
                    choice = 1;
                break;
    
                case 2:
                    say("Wouldn't you like to know? I'm watching a video on these werewolf sightings. They look really scary.\n");
                    choice = 2;
                break;
            }   
        }

        else if(Game.wear == false && choice == 2){
            switch(option) {
                case 1:
                    say("Are you stupid? They are definitely real, there is plenty of evidence out there.");
                    say("What are you still doing here? Scram!\n");
    
                    break;
    
                case 2:
                    say("Nah Uh! You are such a liar. I would have heard about it by now.");
                    say("What are you still doing here? Scram!\n");
                break;
            } 
        }

        else if(Game.wear == true && choice == 0){
            switch(option) {
                case 1:
                    say("Yeah of course, anything you need!!");
                    Game.print("You recived a tank full of gas. Nice.\n");

                    Gas gas = new Gas("gas", "A tank filled with gas");
                    Game.inventory.add(gas);
                    choice = 1;
                break;
    
                case 2:
                    say("Please spare me. I have a family. You can take whatever you want.\n");
                    choice = 2;
                break;
            }
        }

        else if(Game.wear == true && choice == 2){

            if(option == 1 || option == 2){
                say("Yeah of course, anything you need!!");
                Game.print("You recived a tank full of gas. Nice.\n");

                Gas gas = new Gas("gas", "A tank filled with gas");
                Game.inventory.add(gas);
            }
        }

    }

    public void give(Item i){
        if(Game.getItemInventory(i.getName()) == null){
            Game.print("You dont have such item");
        }
        else if(i.getName() == "cash"){
            Game.print("You gave the " + i.getName() + " to the cashier");
            Game.print("The cashier takes your money and ignores you. What a douchebag. It's payback time.\n");
            Game.inventory.remove(i);
        }
        else{
            Game.print("You can't give the " + i.getName() + " to the cashier");
        }
    }
}

