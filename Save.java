import java.io.FileNotFoundException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import java.io.PrintWriter;

public class Save {
    private Player player;
    public Save(Player player) {
        this.player = player;
    }

    public void main() {
        save();
        System.out.println("Game Saved!");
    }

    public void save() {
        try {
            FileWriter writer = new FileWriter("save.txt");
            writer.write(player.writeToSave());
            writer.close();
            System.out.println("Saveed!!!!");
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }



    //all this class does is save the data to the save file...takes in player to save the data


}
