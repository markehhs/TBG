public class Shop {
    private Item[] availableItems = new Item[8];
    public Shop(Item[] availableItems) {
        this.availableItems = availableItems;
    }

    //getters
    public Item[] getAvailableItems() { return availableItems; }

    //setters
    public void setAvailableItems(Item[] availableItems) { this.availableItems = availableItems; }

    //methods for listing items, buying, and selling
    public String listItems() {
        String itemList = "";
        String str = "";
        for (int i = 0; i < availableItems.length; i++) {
            str = "[" + i + "] Name: " + availableItems[i].getName() + " Descrption: " + availableItems[i].getDescription() + " Price: " + availableItems[i].getPrice() + "\n";
            itemList += str;
        }
        return itemList;
    }

    public void buyItem(Player player, Item item) {
        //to buy an item first we need to check if the player has enough gold.
        int gold = player.getGold();
        int cost = item.getPrice();
        if (gold < cost) {
            System.out.println("You do not have enough gold!");
        } else {
            //buy the item.
            player.setGold(gold - cost);
            //now get the size of the inventory...
            int size = player.getInventory().length;
            player.setInventory(item);
            System.out.println("You purchased: " + item.getName());
        }
    }

}
