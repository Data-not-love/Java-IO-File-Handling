package File_Handling.Basic_Handling;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class copyContent {

    public void copyText (String movePath,String destinationPath){
        try (FileInputStream fis = new FileInputStream(movePath);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[1024]; // Tạo buffer 1KB
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) { // Đọc từng phần của file
                fos.write(buffer, 0, bytesRead); // Ghi vào file đích
            }

            System.out.println("Moving context from " + movePath + " to " + destinationPath + " is done ");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
