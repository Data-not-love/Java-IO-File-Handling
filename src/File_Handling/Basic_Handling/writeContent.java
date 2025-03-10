package File_Handling.Basic_Handling;

import java.io.FileWriter;
import java.io.IOException;

public class writeContent {

    public void writeContent(String absolutePath,String content) {

        try {
            FileWriter writer = new FileWriter(absolutePath, true); // true = append mode
            writer.write(content + "\n"); // Write content to the file
            writer.close(); // Close the writer
            System.out.println("Content written successfully to " + absolutePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();

        }
    }

}