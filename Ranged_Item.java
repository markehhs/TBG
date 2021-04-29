public class Ranged_Item extends Item{
    public int atk_buff;
    public Ranged_Item(String name, String description, int price, int atk_buff) {
        super(name, description, price, atk_buff, false);
        this.atk_buff = atk_buff;
    }

    //getters
    public int getAtk_buff() { return atk_buff; }
    //setters
    public void setAtk_buff(int atk_buff) { this.atk_buff = atk_buff; }

}
