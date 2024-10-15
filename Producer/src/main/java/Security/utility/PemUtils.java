package Security.utility;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class PemUtils {
    public static PublicKey getPublicKey(ClassPathResource resource) throws Exception {
        // Load the certificate from the provided resource
        CertificateFactory factory = CertificateFactory.getInstance("X.509");

        try (InputStream inputStream = resource.getInputStream()) {
            X509Certificate certificate = (X509Certificate) factory.generateCertificate(inputStream);
            return certificate.getPublicKey();  // Extract the public key from the certificate
        } catch (Exception e) {
            throw new RuntimeException("Failed to load public key from certificate", e);
        }
    }
}
