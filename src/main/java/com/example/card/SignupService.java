package com.example.card;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class SignupService {

    private final UserRepository userRepository;
    private final JavaMailSender emailSender;

    String signup(String email) {

        List<User> userList = userRepository.findByEmail(email);

        if (!userList.isEmpty()) {
            throw new RuntimeException("User with this email had signup");
        }

        String otp = generateOtp();

        sendOtpToMail(email, otp);

        return "Check your email";
    }

    private void sendOtpToMail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(email);
        message.setSubject("test1");
        message.setText(otp);
        emailSender.send(message);
    }

    private String generateOtp() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }

}
