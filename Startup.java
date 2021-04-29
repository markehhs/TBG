import java.util.Scanner;
import java.util.ArrayList;
public class Startup {
    public Startup() {
        main();
    }

    //this class will be called when the game opens up.
    //user can choose to either load/new game
    public void main() {
        //lets get the user input and call the necessary function...
        System.out.println("Welcome! Please make a selection.\nNew Game: 1\nLoad Game: 2");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("Please enter either 1 or 2.");
            input.nextLine();
        }
        int choice = input.nextInt();
        if (choice == 1) {
            newGame();
        } else if (choice == 2) {
            loadGame();
        } else {
            System.out.println("Invalid selection.");
            main();
        }


    }

    public void newGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("You chose a new game.");
        //get input and call the Player class with the data...
        System.out.println("Enter your name: ");
        String name = input.next();
        Item[] inventory = new Item[10];
        Item rustySword = new Mele_Item("Rusty Sword", "Starter item.", 0, 2);
        Player player = new Player(name, 10, 10, 100, 10, 0, 1, inventory, 100, 100, rustySword, 0);
        player.setInventoryAt(0, rustySword);
        Game game = new Game(player);

    }

    public void loadGame() {
        //wont be done for awhile...
        System.out.println("You chose to load the game.");
        Load load = new Load();
        ArrayList<String> playerData = new ArrayList<String>();
        ArrayList<String> itemData = new ArrayList<String>();
        //now use the data below to start the game.
        //first handle the data..load function returns a string 1st line is the play any additional lines are inventory items.
        String[] values = load.load().split("\n");
        for (int i = 0; i < values.length; i++) {
            //now split this by commas...
            String[] cvalues = values[i].split(",");
            //tricky here but simple just looping through each csv here...
            for (int j = 0; j < cvalues.length; j++) {
                //now check to see if i is greater than 0 if it is we are on an inventory item
                if (i >= 1) {
                    //inventory item...
                    //System.out.println(cvalues[j]);
                    itemData.add(cvalues[j]);

                } else {
                    //player data here...
                    //System.out.println(cvalues[j]);
                    playerData.add(cvalues[j]);

                }
            }

        }
        //now start the game with the data...<---------HERERERERHEHREHRHERHEHREHRHERHE
        Item[] inventory = new Item[10];
        Item rustySword = new Mele_Item("Rusty Sword", "Starter item.", 0, 2);
        //String name, int attack, int defense, int health, int stamina, double xp, int level, Item[] inventory, int gold, int maxHealth, int potionCount)
        //string saveString = name + "," + attack + "," + defense + "," + health + "," + stamina + "," + xp + "," + level + "," + gold + "," + maxHealth + "," + potionCount;
        //System.out.println(playerData.get(0) + " " + playerData.get(1) + " " + playerData.get(2) + " " + playerData.get(3) + " " + playerData.get(4) + " " + playerData.get(5) + " " + playerData.get(6) + " " + playerData.get(7) + " " + playerData.get(8) + " " + playerData.get(10));
        Player player = new Player(playerData.get(0), Integer.parseInt(playerData.get(1)), Integer.parseInt(playerData.get(2)), Integer.parseInt(playerData.get(3)), Integer.parseInt(playerData.get(4)), Double.parseDouble(playerData.get(5)), Integer.parseInt(playerData.get(6)), Integer.parseInt(playerData.get(7)), Integer.parseInt(playerData.get(8)), Integer.parseInt(playerData.get(10)), inventory);
        //now for items every 6 elements in the arrayList is an item (0-5)
        for (int i = 0; i < itemData.size(); i+=6) {
            //Item item = new Item(itemData.get(i), itemData.get(i + 2), Integer.parseInt(itemData.get(i + 1)), Integer.parseInt(itemData.get(i + 3)), Boolean.parseBoolean(itemData.get(i + 4)));
            //now add the item to the inventory
            Item item = new Item();
            System.out.println("Name: " + itemData.get(i) + " Description " + itemData.get(i + 2) + " Price " + Integer.parseInt(itemData.get(i + 1)) + " Atk" + Integer.parseInt(itemData.get(i + 3)) + " " + Boolean.parseBoolean(itemData.get(i + 4)));
            item.setName(itemData.get(i));
            item.setDescription(itemData.get(i+2));
            item.setAtk_buff(Integer.parseInt(itemData.get(i + 3)));
            item.setPrice(Integer.parseInt(itemData.get(i + 1)));
            item.setIsConsumable(Boolean.parseBoolean(itemData.get(i + 4)));
            player.setInventory(item);
            player.setEquippedItem(item);
        }
        System.out.println("Game succesfully loaded!");
        Game game = new Game(player);

    }


}

