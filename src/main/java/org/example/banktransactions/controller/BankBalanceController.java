package org.example.banktransactions.controller;

import org.example.banktransactions.model.BankBalance;
import org.example.banktransactions.service.BankBalanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank-balance")
public class BankBalanceController {

    private final BankBalanceService bankBalanceService;

    public BankBalanceController(BankBalanceService bankBalanceService) {
        this.bankBalanceService = bankBalanceService;
    }

    @GetMapping(value = "/{bankBalanceId}", produces = "application/json")
    public ResponseEntity<BankBalance> getBankBalance(@PathVariable("bankBalanceId") Long bankBalanceId) {
        var bankBalance = bankBalanceService.getBankBalance(bankBalanceId);
        return ResponseEntity.ok(bankBalance);
    }
}
