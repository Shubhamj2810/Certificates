package Security.utils;

import lombok.experimental.UtilityClass;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.util.Base64;

@UtilityClass
public class EncryptionUtils {
    public static String decrypt(String encryptedData, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }
}
