package com.example.card.account.presentention;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/account")
@RestController
public class accountController {
private Acountservice acountservice;

@Autowired public accountController(AccountService accountService){
    this.accountService = accountService;

}
}
