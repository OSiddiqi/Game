package Game2;

import java.util.ArrayList;

class Rooms {

    public static void build(Room[][] room, final int WIDTH, final int HEIGHT) {

    	// Initialise rooms
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                room[i][j] = new Room(i, "", "", null);
            }
        }

        room[0][0].setNumber(1);
        room[0][0].setName("Starting Room");
        room[0][0].setDescription("You are in a dimly lit room.");
        room[0][0].setItems("rusty knife");
        room[0][0].setItems("piece of paper");

        room[0][1].setNumber(2);
        room[0][1].setName("Dark, Damp Room");
        room[0][1].setDescription("You are in a grungy utility room. There is a cupboard in the corner. The cupboard is slightly ajar.");
        room[0][1].setItems("coat");
        room[0][1].setItems("flashlight");

        room[1][0].setNumber(3);
        room[1][0].setName("Kitchen");
        room[1][0].setDescription("You are in a room resembling a kitchen, only filthier than shared student accomodation.");
        room[1][0].setItems("eggs");
        room[1][0].setItems("soda");

        room[1][1].setNumber(4);
        room[1][1].setName("Never Cleaned Bathroom");
        room[1][1].setDescription("You are in a disgusting bathroom.");
        room[1][1].setItems("toilet paper");
        room[1][1].setItems("magazine");
    }

    public static void print(Room[][] room, int x, int y) {

    	System.out.println();
        System.out.println(room[x][y].getDescription());
        System.out.println("You see: " + room[x][y].getItems());
    }

    // Remove item from room when added to inventory
    public static void removeItem(Room[][] room, int x, int y, String item) {
    	
    	room[x][y].deleteItem(item);
    }
}

class Room {

    private int number;
    private String name;
    private String description;
    public ArrayList<String> items = new ArrayList<>();

    public Room(int number, String name, String description,
            ArrayList<String> items) {
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setItems(String item) {
        this.items.add(item);
    }

    public void deleteItem(String item) {
        this.items.remove(item);
    }

    public ArrayList<String> getItems() {
        return this.items;
    }
}