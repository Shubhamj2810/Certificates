package Security.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @PostMapping("/decryptFile")
    public String upload(@RequestParam("file") MultipartFile file) {
        return "upload successfully";
    }
}
