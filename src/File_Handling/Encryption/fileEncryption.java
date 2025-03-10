package File_Handling.Encryption;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class fileEncryption {
    public void checkEncrypted (String encryptPath) throws IOException {
        File inputfile = new File(encryptPath);
        File encryptedFile = new File(inputfile + ".encrypted");

        if (inputfile.toString().endsWith(".encrypted")) {
            System.out.println("\u001B[31m" + "File is already encrypt" + "\u001B[0m");
        }

        else{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Want to encrypt it? [Y/N]");
            String choice = scanner.nextLine();
            switch (choice){
                case "Y":
                    System.out.println("\u001B[33m" + "You choose to encrypt this file" + "\u001B[0m");
                    encrypt(inputfile,encryptedFile);
                    break;
                case "N":
                    System.out.println("\u001B[33m" + "You choose not to encrypt this file" + "\u001B[0m");
                    break;
                default:
                    scanner.close();
                    System.out.println("\u001B[31m" + "Invalid Options." + "\u001B[0m");
            }
        }


    }
    private void encrypt(File inputFile, File encryptedFile) throws IOException {
        try {
            File keyFile = new File("F:/aes256key.txt");
            if (!keyFile.exists()) {
                throw new IOException("AES-256 key is not found!");
            }



            // 1. Đọc khóa AES-256 từ file
            byte[] keyBytes = new byte[32]; // AES-256 = 32 bytes
            try (FileInputStream keyFis = new FileInputStream(keyFile)) {
                if (keyFis.read(keyBytes) != 32) {
                    throw new IOException("Invalid AES-256 key length!");
                }
            }
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

            // 2. Khởi tạo Cipher AES-256
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey); // ✅ Sử dụng SecretKeySpec

            // 4. Đọc dữ liệu từ file gốc, mã hóa và ghi ra file mới
            try (FileInputStream fis = new FileInputStream(inputFile);
                 FileOutputStream fos = new FileOutputStream(encryptedFile);
                 CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    cos.write(buffer, 0, bytesRead);
                }
            }

            // 5. Xóa file gốc sau khi mã hóa
            inputFile.delete();
        } catch (Exception e) {
            throw new IOException("Error encrypting file", e);
        }
    }
}