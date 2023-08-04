package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    private AccountService accountService;

    public DemoController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getInfo/{infoId}")
    public ResponseEntity<Object> getAccountInfo(@PathVariable String infoId) {
        Optional<Account> optionalAccount = accountService.getAccountById(infoId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
