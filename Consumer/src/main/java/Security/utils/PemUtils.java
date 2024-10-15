package Security.utils;

import lombok.experimental.UtilityClass;
import org.springframework.core.io.ClassPathResource;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@UtilityClass
public class PemUtils {
    public static PrivateKey getPrivateKey(ClassPathResource resource) throws Exception {
        // Read the private key from the resource InputStream
        byte[] keyBytes = resource.getInputStream().readAllBytes();
        String privateKeyPEM = new String(keyBytes);

        // Remove PEM headers and newlines
        privateKeyPEM = privateKeyPEM
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");  // Removes all whitespace

        // Decode the Base64 encoded key
        byte[] encoded = Base64.getDecoder().decode(privateKeyPEM);

        // Create a PrivateKey from the decoded key bytes
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }
}
