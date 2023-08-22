package com.example.card.Email.presentation;

import com.example.card.Email.business.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SendEmail")
public class SendEmailController {

     private SendEmailService sendEmailService;
     @Autowired
    public SendEmailController(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

    @PostMapping("/seller/register")
    public ResponseEntity<String> registerSeller(@Valid @ResponseBody SellerRegisterDto sellerRegisterDto){
         return userDaoService.registerSeller(sellerRegisterDto);
    }
}
