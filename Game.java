import java.util.Scanner;
public class Game {
    private Player player;
    static Scanner input = new Scanner(System.in);
    public Game(Player player) {
        this.player = player;
        main();
    }

    public void main() {
        System.out.println("Welcome, " + player.getName() + ". Level: " + player.getLevel() + " Gold: " + player.getGold());
        choices();
    }

    public void choices() {
        System.out.println("Hello, " + player.getName() + " Gold: " + player.getGold() + "\nwhat would you like to do?");
        System.out.println("1: Fight");
        System.out.println("2: Shop");
        System.out.println("3: Save");
        System.out.println("4: Exit");
        while (!input.hasNextInt()) {
            System.out.println("Hello, " + player.getName() + " Gold: " + player.getGold() + "\nwhat would you like to do?");
            System.out.println("1: Fight");
            System.out.println("2: Shop");
            System.out.println("3: Save");
            System.out.println("4: Exit");
            input.nextLine();
        }
        int choice = input.nextInt();
        if (choice == 1) {
            //call the fight function
            fight();
        } else if (choice == 2) {
            //call the shop function...
            shop();
        } else if (choice == 3) {
            //call the save function...
            save();

        } else if (choice == 4) {
            //call the exit and save function...
        } else {
            System.out.println("Invalid selection.");
            choices();
        }

    }

    public Item[] createItems() {
        //this function will create 10 items and place them into the
        //Item[] shopItems = new Item[8];
        //now create each item...
        Mele_Item rustySword = new Mele_Item("Rusty Sword", "Starter item.", 0, 2);
        Ranged_Item woodenBow = new Ranged_Item("Wooden Bow", "A wooden bow.", 10, 5);
        Potion_Item smallHealthPot = new Potion_Item("Small Health Potion", "A small health potion worth 10 points.", 5, 10);
        Mele_Item filler1 = new Mele_Item("Filler Item1", "A filler item.", 5, 10);
        Mele_Item filler2 = new Mele_Item("Filler Item2", "A filler item2.", 5, 10);
        Mele_Item metalSword = new Mele_Item("Metal Sword", "Metal sword, very shiny", 20, 12);
        Mele_Item godSword = new Mele_Item("God Sword", "Very op", 0, 100);
        Ranged_Item godBow = new Ranged_Item("God Bow", "Also very op", 0, 100);
        Item[] shopItems = {rustySword, woodenBow, smallHealthPot, filler1, filler2, metalSword, godSword, godBow};
        return shopItems;


    }

    public void fight() {
        Fight fight = new Fight();
        //fight.spawnEnemy();
        fight.battle(player, fight.spawnEnemy());
        choices();

    }

    public void shop() {
        Item[] items = createItems().clone();

        Shop shop = new Shop(createItems());
        System.out.println("Items up for sale:");
        System.out.println(shop.listItems());
        System.out.println("----------------------------");
        player.displayInventory();
        System.out.println("Gold: " + player.getGold());
        System.out.println("Enter an item # to purchase(99 to exit): ");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println(shop.listItems());
            player.displayInventory();
            System.out.println("Gold: " + player.getGold());
            System.out.print("Enter an item # to purchase: ");
            System.out.println("Enter an item # to purchase(99 to exit): ");
            input.nextLine();
        }
        int choice = input.nextInt();
        if (choice == 99) {
            //exit
            choices();
        } else if (choice >= 0 && choice <= 10) {
            shop.buyItem(player, items[choice]);
            player.displayInventory();
            shop();
        } else {
            shop();
        }

    }

    public void save() {
        Save save = new Save(player);
        save.save();
    }

    public void exit() {

    }

}
