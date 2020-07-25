package cn.baeldung.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin/test")
    public String adminRole() {
        return "{}";
    }

    @GetMapping("/my-error-page")
    public String error() {
        return "my-error-page";
    }
}
