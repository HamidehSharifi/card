package com.example.card.Email.business;

import com.example.card.Email.persistance.SendEmail;
import org.springframework.stereotype.Service;

@Service
public interface SendEmailService {
    void sendemail(String toEmail,String subject ,String message);

}
