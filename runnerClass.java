package Game2;

import java.util.ArrayList;

public class runnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
		// Build rooms
        final int WIDTH = 2;
        final int HEIGHT = 2;
        Room[][] room = new Room[WIDTH][HEIGHT];
        Rooms.build(room, WIDTH, HEIGHT);
        int x = 0;
        int y = 0;
        int score = 0;

        // Load inventory
        ArrayList<String> inventory = new ArrayList<>();
        
        // Title Screen
    	System.out.println("+-------------------------------+");
    	System.out.println("|  Text Adventure: Oh yeah...   |");
    	System.out.println("+-------------------------------+");
    	System.out.println("You awaken and groggily shift about, gently feeling the ground below yourself");
		System.out.println("Where am I? What is going on?");
		System.out.println("Your head feels fuzzy and you can barely open your eyes...");
		System.out.println("You can just about make out that you're lying on a pile of straw");
		System.out.println("You struggle to remmber ANYTHING. What's your name?");
		String playerName = Input.getInput();
		System.out.print("Welcome, " + playerName);
		System.out.print(" to... ...The Barren Moors! Mu ha ha ha hah...");
		System.out.println("\n---------------------------------------------------------");
    	System.out.println("Type help to see common commands");
  	
    	// Print starting room description
    	Rooms.print(room, x, y);

        // Start game loop
        boolean playing = true;
        while (playing) {

        	// Get user input
            String input = Input.getInput();

            // Movement commands
            if (input.equals("n") || input.equals("north")) {
                if (y > 0) {
                    y--;
                    Rooms.print(room, x, y);
                } else {
                    System.out.println("You can't go that way.");
                }
            } else if (input.equals("s") || input.equals("south")) {
                if (y < HEIGHT - 1) {
                    y++;
                    Rooms.print(room, x, y);
                } else {
                    System.out.println("You can't go that way.");
                }
            } else if (input.equals("e") || input.equals("east")) {
                if (x > 0) {
                    x--;
                    Rooms.print(room, x, y);
                } else {
                    System.out.println("You can't go that way.");
                }
            } else if (input.equals("w") || input.equals("west")) {
                if (x < WIDTH - 1) {
                    x++;
                    Rooms.print(room, x, y);
                } else {
                    System.out.println("You can't go that way.");
                }
            }

            // Look commands
            else if (input.equals("look")) {
                Rooms.print(room, x, y);
            }

            // Get commands
            else if (input.length() > 4  && input.substring(0, 4).equals("get ")) {
            	if (input.substring(0, input.indexOf(' ')).equals("get")) {
            		if (input.substring(input.indexOf(' ')).length() > 1) {
            			String item = input.substring(input.indexOf(' ') + 1);
                    	score = Inventory.checkItem(x, y, item, inventory, room, score);
            		}	
            	}
            }

            // Inventory commands
            else if (input.equals("i") || input.equals("inv")
                    || input.equals("inventory")) {
                Inventory.print(inventory);
            }
            
            else if (input.equals("score")) {
            	System.out.println("Score: " + score + "/500");
            }
            
            else if (input.equals("restart")) {
            	System.out.println();
            	runnerClass.main(args);
            }
            
            else if (input.equals("help")) {
            	System.out.println("Type 'n'/'e'/'s'/'w' to move around");
            	System.out.println("Type 'look' for a description of the room you're in");
            	System.out.println("Type 'get' + the item to get something");
            	System.out.println("Type 'i' to view your inventory");
            	System.out.println("Type 'score' to view your score");
            	System.out.println("Type 'restart' to restart the game");
            	System.out.println("Type 'quit' to quit the game");
            }
            
            // Quit commands
            else if (input.equals("quit")) {
                System.out.println("Goodbye!");
                playing = false;
            } else if (input.equals("exit")) {
                	System.out.println("You're not allowed to exit! Ha ha ha!");
            // Catch-all for invalid input
            } else {
                System.out.println("You can't do that.");
            }
        }
        System.exit(0);
    }
}

	


