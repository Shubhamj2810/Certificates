package Security.service;

import Security.utils.EncryptionUtils;
import Security.utils.PemUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;

@Service
public class DecryptionService {
    public String decryptFile(MultipartFile file) throws Exception {
        // Read the encrypted file content from MultipartFile
        String encryptedData = new String(file.getBytes(), StandardCharsets.UTF_8);

        // Load the private key from the resources folder (fixed path to private.pem)
        ClassPathResource resource = new ClassPathResource("private_key.pem");
        PrivateKey privateKey = PemUtils.getPrivateKey(resource);

        // Decrypt the data
        return EncryptionUtils.decrypt(encryptedData, privateKey);
    }
}
