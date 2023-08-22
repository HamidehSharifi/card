package com.example.card.Email.business;

import com.example.card.Email.persistance.Role;
import com.example.card.Email.persistance.Seller;
import com.example.card.Email.persistance.SendEmail;
import com.example.card.customer.persistance.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class SendEmailServiceImpl implements SendEmailService{

private JavaMailSender javaMailSender;
private SendEmailService sendEmailService;
public CustomerRepository customerRepository;

    @Autowired
    public SendEmailServiceImpl(JavaMailSender javaMailSender, SendEmailService sendEmailService, CustomerRepository customerRepository) {
        this.javaMailSender = javaMailSender;
        this.sendEmailService = sendEmailService;
        this.customerRepository = customerRepository;
    }

    @Async
    @Override
    public void sendemail(String toEmail, String subject, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage() ;
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setFrom("h.sharifi.6776@gmail.com");
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);

    }
    public ResponseEntity<String> RegisterSeller(SellerRegisterDto sellerRegisterDto) {
        if (customerRepository.existByEmail(sellerRegisterDto.getEmail)){
            return new ResponseEntity<>("Email is already token" , HttpStatus.BAD_REQUEST);
        }
        Seller seller = new Seller();
        seller.setFirstName(sellerRegisterDto.getFistName);
        seller.setlastName(sellerRegisterDto.getLastName);
        seller.getMiddleName();
        Role role = rollRepository.findByAuthority(" Roll_seller").get;
        seller.setRolls(Collections.singletonList(role));
        sellerRepository.save(seller);
        String token =tokenService.generateRegisterToken(seller);
        String subject ="";
        String Email =seller.getEmail;
        String message = "Hi" + seller.getFirstName + "your seller account setup completed \n" +
                "wait for approval \n" + seller.getEmail;
        sendEmailService.sendemail(email,subject,message);
        return new ResponseEntity<>("seller registered succesfully . admin wil active your account" ,HttpStatus.CREATED)




        role.

    }


}
