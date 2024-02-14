package com.microcompany.accountsservice.ontroller;

import com.microcompany.accountsservice.exception.AccountNotfoundException;
import com.microcompany.accountsservice.model.Account;
import com.microcompany.accountsservice.payload.ApiResponse;
import com.microcompany.accountsservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    private AccountService accountService;


    @GetMapping("")
    public ResponseEntity getAccount() {
        List<Account> accs = accountService.getAccounts();
        if (accs != null && accs.size() > 0) return ResponseEntity.status(HttpStatus.OK).body(accs);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Vacio", false));
    }

    @PostMapping("")
    public ResponseEntity<Account> createAccount(
            @RequestBody Account account
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.create(account));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(
            @PathVariable Long id
    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(accountService.getAccount(id));
        } catch (AccountNotfoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
