package com.cydeo.banksimulation.controller;

import com.cydeo.banksimulation.model.Account;
import com.cydeo.banksimulation.model.Transaction;
import com.cydeo.banksimulation.service.AccountService;
import com.cydeo.banksimulation.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class TransactionController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    public TransactionController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }


    @GetMapping("/make-transfer")
    public String retrieveTransactionForm(Model model) {
        model.addAttribute("account", accountService.listAllAccount());
        model.addAttribute("transaction", Transaction.builder().build());//sending an empty object
        model.addAttribute("lastTransactionList", transactionService.retrieveLastTransaction());

        return "transaction/make-transfer";
    }

    @PostMapping("/transfer")
    public String makeTransfer(@ModelAttribute("transaction") Transaction transaction){

        Account receiver = accountService.retriverById(transaction.getReceiver());
        Account sender = accountService.retriverById(transaction.getSender());
        transactionService.makeTransfer(transaction.getAmount(), new Date(), sender, receiver, transaction.getMessage());
        return "redirect:/make-transfer";

    }
}
