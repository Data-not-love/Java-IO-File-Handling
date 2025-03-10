package File_Handling.Encryption;
import File_Handling.Basic_Handling.overwriteContent;
import java.security.NoSuchAlgorithmException;

public class writeKey {

    keyGenerator myKeyGenerator = new keyGenerator();

    public writeKey() throws NoSuchAlgorithmException {
        overwriteContent overWriteKey = new overwriteContent();
        overWriteKey.overWrite("F:/aes256key.txt",myKeyGenerator.generateKey());
        System.out.println("\u001B[32m" + "Done" + "\u001B[0m");
    }

    public static void main (String []args) throws NoSuchAlgorithmException {
        new writeKey();
    }

}
