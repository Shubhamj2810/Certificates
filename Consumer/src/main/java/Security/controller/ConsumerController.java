package Security.controller;

import Security.service.DecryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private DecryptionService decryptionService;

    @PostMapping("/decryptFile")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        return decryptionService.decryptFile(file);
    }
}
