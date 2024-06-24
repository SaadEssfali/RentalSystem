package com.system.RentalSystemSpringboot.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_user')")
    public String userTestEndpoint() {
        return "Hello User";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_admin')")
    public String adminTestEndpoint() {
        return "Hello Admin";
    }
}
