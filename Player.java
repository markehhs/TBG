public class Player {
    private String name;
    private int attack;
    private int defense;
    private int health;
    private int stamina;
    private double xp;
    private int level;
    private Item[] inventory;
    private int gold;
    private int maxHealth;
    private Item equippedItem;
    private int potionCount;

    public Player() {

    }

    public Player(String name, int attack, int defense, int health, int level, int gold, Item equippedItem) {
        //this is for enemies...
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.level = level;
        this.gold = gold;
        this.equippedItem = equippedItem;
    }

    public Player(String name, int attack, int defense, int health, int stamina, double xp, int level, Item[] inventory, int gold, int maxHealth, Item equippedItem, int potionCount) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.stamina = stamina;
        this.xp = xp;
        this.level = level;
        this.inventory = inventory;
        this.gold = gold;
        this.maxHealth = maxHealth;
        this.equippedItem = equippedItem;
        this.potionCount = potionCount;
    }

    public Player(String name, int attack, int defense, int health, int stamina, double xp, int level, int gold, int maxHealth, int potionCount, Item[] inventory) {
        //this is for LOADING in...gives rusty sword as equipped item.
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.stamina = stamina;
        this.xp = xp;
        this.level = level;
        this.gold = gold;
        this.maxHealth = maxHealth;
        this.potionCount = potionCount;
        this.inventory = inventory;
    }

    //getters for attributes.
    public String getName() { return name; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getHealth() { return health; }
    public int getStamina() { return stamina; }
    public double getXP() { return xp; }
    public int getLevel() { return level; }
    public Item[] getInventory() { return inventory; }
    public int getGold() { return gold; }
    public int getMaxHealth() { return maxHealth; }
    public Item getEquippedItem() { return equippedItem; }
    public Item getItemAt(int num) {
        Item ret = null;
        if (num > inventoryCount()) {
            System.out.println("Invalid number.");
        } else {
            Item items[] = getInventory();
            ret = items[num];
        }
        return ret;
    }
    public int getPotionCount() { return potionCount; }
    //public Mele_Item getEquippedItem() { return  eqippedItem; }

    //setters for attributes
    public void setName(String name) { this.name = name; }
    public void setAttack(int attack) { this.attack = attack; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setHealth(int health) { this.health = health; }
    public void setStamina(int stamina) { this.stamina = stamina; }
    public void setXP(double xp) { this.xp = xp; }
    public void setLevel(int level) { this.level = level; }
    public void setInventoryAt(int pos, Item item) { inventory[pos] = item; }
    public void setInventory(Item item) {
        //loop through the inventory for a null position and set the item there.
        int num = 0;
        boolean stop = false;
        while (getInventory()[num] != null && stop == false) {
            //its null so move on...
            num += 1;
            if (num == 9) {
                stop = true;
                System.out.println("Inventory full.");
            }
        }
        //come back to set the limit...
        if (stop == false) {
            setInventoryAt(num, item);
            System.out.println("Item set.");
        }

    }
    public void setGold(int gold) { this.gold = gold; }
    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }
    public void setEquippedItem(Item equippedItem) { this.equippedItem = equippedItem; }
    public void setPotionCount(int potionCount) { this.potionCount = potionCount; }

    //methods for the player
    public void displayInventory() {
        System.out.println("Your inventory.");
        //System.out.println(getInventory().length);
        for (int i = 0; i < getInventory().length; i++) {
            if (inventory[i] != null)
                System.out.println(i + " " + inventory[i].getName() + " " + inventory[i].getDescription());
        }
    }

    public int inventoryCount() {
        int count = 0;
        for (int i = 0; i < getInventory().length; i++) {
            if (inventory[i] != null)
                count++;
        }
        return count;
    }

    public void takePotion() {
        //first check to make sure the player health is not full.
        if (health == maxHealth) {
            //exit out.
            System.out.println("You have max health, can't take a potion.");
        } else {
            //take a potion if we have one...
            if (potionCount >= 0) {
                //take the potion and remove it...
                setHealth(health += (10 * level));
                if (health > maxHealth) {
                    health = maxHealth;
                }
                potionCount--;
            } else {
                //no potion you dont have any.
                System.out.println("You do not have any potions.");
            }

        }
    }

    public String writeToSave() {
        //this function retuns all necessary player data so we can easily write it to the save file.
        String saveString = name + "," + attack + "," + defense + "," + health + "," + stamina + "," + xp + "," + level + "," + gold + "," + maxHealth + "," + potionCount;

        //now lets handle the inventory by looping through the loop and printing each items detail
        for (int i = 0; i < inventoryCount(); i++) {
            saveString += "\n" + inventory[i].getName() + "," + inventory[i].getDescription() + "," + inventory[i].getPrice() + "," + inventory[i].getAtk_buff() + "," + inventory[i].getIsConsumable() + "," + inventory[i].getClass();
        }
        return saveString;
    }


}
