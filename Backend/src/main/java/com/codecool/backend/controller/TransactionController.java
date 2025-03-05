package com.codecool.backend.controller;

import com.codecool.backend.controller.dto.MemberDto;
import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.controller.dto.TransactionDto;
import com.codecool.backend.dao.model.Transaction;
import com.codecool.backend.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    List<TransactionDto> getAll() throws Exception {
        return transactionService.getAllTransactions();
    }
    @GetMapping("/{id}")
    TransactionDto getTransactionById(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/{id}/avrg")
    int getAverageTransactions(@PathVariable int id) {
        return transactionService.getAvrgSpendingByCategoryId(id);
    }

    @GetMapping("/{id}/sum")
    public int getSumOfTransactionByCategoryId(@PathVariable int id) {
      return transactionService.getSumOfTransactionByCategoryId(id);
    }

    @PostMapping("/add")
    int addTransaction(@RequestBody NewTransactionDto transactionDto) {
       return transactionService.createTransaction(transactionDto);
    }

    @PutMapping("")
    boolean updateTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionService.updateTransaction(transactionDto);
    }

    @DeleteMapping("/{id}")
    boolean deleteTransaction( @PathVariable int id) {
        return transactionService.deleteTransaction(id);
    }

}
