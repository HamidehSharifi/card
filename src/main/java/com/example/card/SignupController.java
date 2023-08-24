package com.example.card;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/signup")
public class SignupController {

    private final SignupService signupService;

    @GetMapping("/{email}")
    String sign(@PathVariable String email) {
        return signupService.signup(email);
    }

}
