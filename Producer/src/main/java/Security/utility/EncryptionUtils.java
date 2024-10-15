package Security.utility;

import lombok.experimental.UtilityClass;

import javax.crypto.Cipher;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;

@UtilityClass
public class EncryptionUtils {
    // Constant for the certificate path
    private static final String CERTIFICATE_PATH = "certificate.crt"; // Ensure this is the correct path

    public static String encrypt(String data) throws Exception {
        // Load the X.509 certificate
        X509Certificate certificate = loadCertificate();

        // Get the public key from the certificate
        PublicKey publicKey = certificate.getPublicKey();

        // Encrypt the data using the public key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private X509Certificate loadCertificate() throws Exception {
        CertificateFactory factory = CertificateFactory.getInstance("X.509");

        // Load the certificate from the resources
        try (InputStream inputStream = EncryptionUtils.class.getClassLoader().getResourceAsStream(CERTIFICATE_PATH)) {
            if (inputStream == null) {
                throw new RuntimeException("Certificate file not found in resources");
            }
            return (X509Certificate) factory.generateCertificate(inputStream);
        }
    }

}
