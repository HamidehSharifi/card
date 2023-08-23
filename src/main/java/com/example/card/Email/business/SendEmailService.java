package com.example.card.Email.business;

import org.springframework.stereotype.Service;

@Service
public interface SendEmailService {
    void sendSimpleMessage(String to, String subject , String message);

}
