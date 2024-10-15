package Security.service;

import Security.utility.EncryptionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EncryptionService {
    public String encryptFile(MultipartFile file) throws Exception {
        // Read the content of the uploaded file
        String data = new String(file.getBytes());

        // Encrypt the data using the certificate
        return EncryptionUtils.encrypt(data);
    }
}
