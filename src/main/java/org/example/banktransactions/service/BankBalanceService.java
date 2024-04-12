package org.example.banktransactions.service;

import org.example.banktransactions.model.BankBalance;
import org.example.banktransactions.repository.BankBalanceRepository;
import org.springframework.stereotype.Service;

@Service
public class BankBalanceService {

    private final BankBalanceRepository bankBalanceRepository;

    public BankBalanceService(BankBalanceRepository bankBalanceRepository) {
        this.bankBalanceRepository = bankBalanceRepository;
    }

    public BankBalance getBankBalance(Long bankBalanceId) {
        return bankBalanceRepository.find(bankBalanceId);
    }
}