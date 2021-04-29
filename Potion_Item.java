public class Potion_Item extends Item{
    private int healthIncrease;
    public Potion_Item(String name, String description, int price, int healthIncrease) {
        super(name, description, price, 0, true);
        this.healthIncrease = healthIncrease;
    }

    //getters
    public int getHealth_buff() { return healthIncrease; }
    //setters
    public void setHealth_buff(int atk_buff) { this.healthIncrease = healthIncrease; }

    //methods...
    public void takePotion(Player player, Potion_Item potion) {
        //first check to make sure they are missing health.
        int currHealth = player.getHealth();
        int maxHealth = player.getMaxHealth();
        player.setHealth(currHealth + potion.getHealth_buff());
        if (player.getHealth() >= maxHealth) {
            player.setHealth(maxHealth);
        }
        System.out.println("Potion taken, health: " + player.getHealth());

    }

}
