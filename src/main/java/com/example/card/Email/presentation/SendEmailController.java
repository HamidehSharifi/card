package com.example.card.Email.presentation;

import com.example.card.Email.business.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SendEmail")
public class SendEmailController {

     private SendEmailService sendEmailService;
     @Autowired
    public SendEmailController(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

    @PostMapping("")
    public ResponseEntity<String> sedEmail(String to, String subject, String text){
         return sendEmailService.sendSimpleMessage(to,subject,text);
    }
}
