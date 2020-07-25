package cn.baeldung.demo;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("SpringSecurity")
public class SpringSecurityController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("preAuthorize")
    public String preAuthorize() {
        return "preAuthorize";
    }

    @PostAuthorize("hasRole('ROLE_USER')")
    @GetMapping("postAuthorize")
    public String postAuthorize() {
        return "postAuthorize";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("secured")
    public String secured() {
        return "secured";
    }
}
