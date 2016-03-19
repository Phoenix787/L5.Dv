package U2.L1.L2.ex2.model.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Ксения on 18.03.2016.
 */
public class PasswordHelper {

    private static PasswordHelper ph;
    private MessageDigest sha256;

    private PasswordHelper(){

    }

    public static PasswordHelper getInstance(){
        if (ph == null) {
            ph = new PasswordHelper();
        }
        return ph;
    }

    public byte[] getSha256Hash(String string) {
        try {
            sha256 = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return sha256.digest(string.getBytes());
    }
}
