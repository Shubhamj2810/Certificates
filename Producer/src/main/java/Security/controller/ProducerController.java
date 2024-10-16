package Security.controller;

import Security.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private EncryptionService encryptionService;

    @PostMapping("/encrypt")
    public ResponseEntity<String> encryptFile(@RequestParam("file") MultipartFile file) {
        try {
            // Encrypt the file content
            String encryptedData = encryptionService.encryptFile(file);

            // Return the encrypted data as a plain string
            return ResponseEntity.ok(encryptedData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Encryption failed: " + e.getMessage());
        }
    }
}
