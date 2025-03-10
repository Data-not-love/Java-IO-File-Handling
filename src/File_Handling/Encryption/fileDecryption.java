package File_Handling.Encryption;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;


public class fileDecryption {
    public void decryptFile(String encryptedFilePath,String userInputKey) throws IOException {
        File encryptedFile = new File(encryptedFilePath);
        if (!encryptedFile.exists()) {
            throw new IOException("❌ Encrypted file not found!");
        }
        if (!encryptedFilePath.endsWith(".encrypted")) {
            throw new IOException("❌ This file is not encrypted!");
        }

        // Validate key trước khi giải mã
        String correctKey = readKeyFromFile();

        while (true) {

            if (userInputKey.equals(correctKey)) {
                System.out.println("\u001B[32m" + "Key matched! Proceeding with decryption..." + "\\u001B[37m");
                break; // Thoát vòng lặp khi key đúng
            }
        }

        // Tạo file đầu ra sau khi giải mã (bỏ đuôi .encrypted)
        String decryptedFilePath = encryptedFilePath.replace(".encrypted", "");
        File decryptedFile = new File(decryptedFilePath);

        try {
            byte[] keyBytes = correctKey.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            try (FileInputStream fis = new FileInputStream(encryptedFile);
                 CipherInputStream cis = new CipherInputStream(fis, cipher);
                 FileOutputStream fos = new FileOutputStream(decryptedFile)) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = cis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("\u001B[32m" + "Decryption successful: " + decryptedFile.getAbsolutePath() + "\\u001B[37m");
            encryptedFile.delete(); // Xóa file mã hóa sau khi giải mã
        } catch (Exception e) {
            throw new IOException("\u001B[31m" + "Error decrypting file" + "\u001B[0m", e );
        }
    }

    // Hàm đọc key từ file
    private String readKeyFromFile() throws IOException {
        File keyFile = new File("F:/aes256key.txt");
        if (!keyFile.exists()) {
            throw new IOException("\u001B[31m" + "AES-256 key file not found!" + "\u001B[0m");
        }

        try (FileInputStream fis = new FileInputStream(keyFile)) {
            byte[] keyBytes = new byte[32]; // AES-256 cần key 32 bytes
            if (fis.read(keyBytes) != 32) {
                throw new IOException("\u001B[31m" + "Invalid AES-256 key length!" + "\u001B[0m");
            }
            return new String(keyBytes).trim();
        }
    }


}
