import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Load {

    public Load() {

    }


    public String load() {
        String s = "";
        //read from the load file and start the game...
        try {
            File f = new File("save.txt");
            Scanner scan = new Scanner(f);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                s += data + "\n";
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found please make sure save.txt is in the correct spot.");
        }

        return s;
    }


}
