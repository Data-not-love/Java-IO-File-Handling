package File_Handling.Basic_Handling;

import java.io.File;
public class deletePath {



    public void delete(String deletePath){
        File file = new File(deletePath);
    if (file.exists()) { // Check if file exists
        if (file.delete()) { // Attempt to delete file
            System.out.println(deletePath + " deleted successfully.");
        } else {
            System.out.println("Failed to delete the file.");
        }
    } else {
        System.out.println("File does not exist.");
    }
    }
}
