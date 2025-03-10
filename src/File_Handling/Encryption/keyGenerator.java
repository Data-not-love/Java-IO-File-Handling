package File_Handling.Encryption;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class keyGenerator {
    private KeyGenerator keyGen; // AES-256

    public keyGenerator() throws NoSuchAlgorithmException {
        this.keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
    }

    public String generateKey() {
        SecretKey secretKey = keyGen.generateKey();
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        return encodedKey;
    }
}


