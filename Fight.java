import java.util.Random;
import java.util.Scanner;
public class Fight {
    static Scanner input = new Scanner(System.in);
    private Player player;
    /*
     *
     *
     *
     * this class will handle everything regarding fights. for now it takes in a player and maybe also a villian
     * or we can just spawn villians here?
     */

    public Fight() {

    }

    public Fight(Player player) {
        this.player = player;
    }

    public Player spawnEnemy() {
        Player enemy = new Player();
        //String name, int attack, int defense, int health, int level, int gold, Item equippedItem
        //for now lets just make an easy one...
        Item rustySword = new Mele_Item("Rusty Sword", "Starter item.", 0, 2);
        //int enemyLvl = player.getLevel() + 1;
        enemy.setName("Foe n Em");
        enemy.setAttack(5);
        enemy.setDefense(0);
        enemy.setHealth(50);
        enemy.setLevel(2);
        enemy.setGold(20);
        enemy.setEquippedItem(rustySword);
        return enemy;

    }


    public void battle(Player player, Player enemy) {
        //Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean battle = true;
        while (battle == true) {
            if (player.getHealth() == 0) {
                System.out.println("You lost!");
                player.setHealth(player.getMaxHealth());
                battle = false;
            } else if (enemy.getHealth() <= 0) {
                //you won!
                int enemyXP = enemy.getLevel() * 5;
                player.setHealth(player.getMaxHealth());
                System.out.println("You were awarded: " + enemy.getGold() + " gold and " + enemyXP + " xp.");
                player.setGold(player.getGold() + enemy.getGold());
                if (player.getXP() >= 100) {
                    player.setLevel(player.getLevel() + 1);
                    System.out.println("You leveled up to: " + player.getLevel());
                    player.setXP(0);
                }
                battle = false;
            }
            System.out.println("Your health: " + player.getHealth());
            System.out.println("Enemy health: " + enemy.getHealth());
            System.out.println("Make your move: ");
            System.out.println("1: Fight");
            System.out.println("2: Take Potion");
            System.out.println("3: Switch Item");
            while (!input.hasNextInt()) {
                System.out.println("Your health: " + player.getHealth());
                System.out.println("Enemy health: " + enemy.getHealth());
                System.out.println("Make your move: ");
                System.out.println("1: Fight");
                System.out.println("2: Take Potion");
                System.out.println("3: Switch Item");
                input.nextLine();
            }
            int choice = input.nextInt();
            if (choice == 1) {
                //call the fight function
                //fight();
                //first check each players health...
                if (player.getHealth() <= 0) {
                    System.out.println("You lost!");
                    player.setHealth(player.getMaxHealth());
                    battle = false;
                } else if (enemy.getHealth() <= 0) {
                    //you won!
                    int enemyXP = enemy.getLevel() * 5;
                    player.setHealth(player.getMaxHealth());
                    System.out.println("You were awarded: " + enemy.getGold() + " gold and " + enemyXP + " xp.");
                    player.setGold(player.getGold() + enemy.getGold());
                    if (player.getXP() >= 100) {
                        player.setLevel(player.getLevel() + 1);
                        System.out.println("You leveled up to: " + player.getLevel());
                        player.setXP(0);
                    }
                    battle = false;
                } else {
                    //both are still alive so lets fight...
                    int randomNum = random.nextInt(10);
                    if (randomNum >= 2) {
                        //player gets to attack first...
						/*
						Item equippedItem = player.getEquippedItem();
						enemy.setHealth(enemy.getHealth() - equippedItem.getAtk_buff());
						System.out.println("You attacked doing: " + equippedItem.getAtk_buff() + " damage.");
						Item enemy_equipped_item = enemy.getEquippedItem();
						player.setHealth(player.getHealth() - enemy_equipped_item.getAtk_buff());
						System.out.println(enemy.getName() + " did: " + enemy_equipped_item.getAtk_buff() + " damage.");
						*/
                        attack(player, enemy);
                    } else {
                        attack(enemy, player);
                        //enemy gets to attack first...
						/*
						Item enemy_equipped_item = enemy.getEquippedItem();
						player.setHealth(player.getHealth() - enemy_equipped_item.getAtk_buff());
						System.out.println(enemy.getName() + " did: " + enemy_equipped_item.getAtk_buff() + " damage.");
						Item equippedItem = player.getEquippedItem();
						enemy.setHealth(enemy.getHealth() - equippedItem.getAtk_buff());
						System.out.println("You attacked doing: " + equippedItem.getAtk_buff() + " damage.");
						*/
                    }
                    System.out.println("Your health: " + player.getHealth());
                    System.out.println("Enemy health: " + enemy.getHealth());

                }
            } else if (choice == 2) {
                //take a potion
                player.takePotion();
            } else if (choice == 3) {
                //swap item
                itemSwap(player);
            } else {
                System.out.println("Invalid selection.");
            }

        }
    }

    public void attack(Player player, Player enemy) {
        Item equippedItem = player.getEquippedItem();
        enemy.setHealth(enemy.getHealth() - equippedItem.getAtk_buff());
        System.out.println("You attacked doing: " + equippedItem.getAtk_buff() + " damage.");
        Item enemy_equipped_item = enemy.getEquippedItem();
        player.setHealth(player.getHealth() - enemy_equipped_item.getAtk_buff());
        System.out.println(enemy.getName() + " did: " + enemy_equipped_item.getAtk_buff() + " damage.");

    }

    public void itemSwap(Player player) {
        System.out.println("Equipped Item: " + player.getEquippedItem().getName());
        player.displayInventory();
        System.out.println("-----------------------------");
        System.out.println("Enter the number of the item to swap: ");
        while (!input.hasNextInt()) {
            System.out.println("Equipped Item: " + player.getEquippedItem().getName());
            player.displayInventory();
            System.out.println("-----------------------------");
            System.out.println("Enter the number of the item to swap: ");
            input.nextLine();
        }
        int choice = input.nextInt();
        if (choice > player.inventoryCount()) {
            System.out.println("Invalid item number.");
            itemSwap(player);
        } else if ( choice < 0) {
            System.out.println(" Invalid Item number;");
            itemSwap(player);
        } else {
            player.setEquippedItem(player.getItemAt(choice));
            System.out.println("Swapped...");
        }

    }

}
