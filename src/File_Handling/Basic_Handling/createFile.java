package File_Handling.Basic_Handling;
import java.io.File;
import java.io.IOException;


public class createFile {

    public void createMultipleFile(int numberOfFile)

    {
        for (int i = 0; i <numberOfFile; i++){
        try {
            // Đường dẫn file muốn tạo
            File myFile = new File("F:/example("+i+").txt");

            // Kiểm tra nếu file chưa tồn tại, thì tạo file mới
            if (myFile.createNewFile()) {
                System.out.println("File đã được tạo: " + myFile.getAbsolutePath());
            } else {
                System.out.println("File đã tồn tại.");
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi tạo file.");
            e.printStackTrace();
        }
        }
    }
}