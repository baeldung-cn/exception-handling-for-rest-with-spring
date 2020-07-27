package cn.baeldung.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @GetMapping("/my-error-page")
    public String error() {
        return "this is my-error-page";
    }
}
