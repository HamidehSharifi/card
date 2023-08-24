package com.example.card;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/signup")
public class SignupController {

    private final SignupService signupService;

    @GetMapping("/email")
    String sign(@RequestParam String email) {
        return signupService.signup(email);
    }

}
