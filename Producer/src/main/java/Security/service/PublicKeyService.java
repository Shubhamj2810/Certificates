package Security.service;

import Security.utility.PemUtils;
import org.springframework.core.io.ClassPathResource;

import java.security.PublicKey;

public class PublicKeyService {
    public PublicKey getPublicKeyForUser(String userId) throws Exception {
        ClassPathResource resource = new ClassPathResource("certificate.crt");
        return PemUtils.getPublicKey(resource);
    }
}
