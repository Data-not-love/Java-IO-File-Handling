package File_Handling.Basic_Handling;

import java.io.FileWriter;
import java.io.IOException;


public class overwriteContent {

    public void overWrite (String overWritePath,String overwriteContent){
        try {
            FileWriter writer = new FileWriter(overWritePath, false); // false = ghi đè
            writer.write(overwriteContent); // Ghi nội dung mới vào file
            writer.close(); // Đóng file
            System.out.println("\u001B[32m" + "Successfully Overwrite." + "\u001B[0m");
        } catch (IOException e) {
            System.out.println("Error in Overwriting!");
            e.printStackTrace();
        }
    }
}
