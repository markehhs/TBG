public class Item {


    private String name;
    private String description;
    private int price;
    private int atk_buff;
    private boolean isConsumable;

    public Item() {

    }

    public Item(String name, String description, int price, int atk_buff, boolean isConsumable) {
        // TODO Auto-generated constructor stub
        this.name = name;
        this.description = description;
        this.price = price;
        this.isConsumable = isConsumable;
    }

    //getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
    public int getAtk_buff() { return atk_buff; }
    public boolean getIsConsumable() { return isConsumable; }

    //setters
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(int price) { this.price = price; }
    public void setAtk_buff(int atk_buff) { this.atk_buff = atk_buff; }
    public void setIsConsumable(boolean isConsumable) { this.isConsumable = isConsumable; }

}
