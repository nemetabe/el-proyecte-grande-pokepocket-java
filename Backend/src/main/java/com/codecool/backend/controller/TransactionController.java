package com.codecool.backend.controller;

import com.codecool.backend.controller.dto.CategoryDto;
import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.controller.dto.TransactionDto;
import com.codecool.backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/categories/all")
    public List<CategoryDto> getAllCategories() {
        return transactionService.getAllCategories();
    }

    @GetMapping("/all")
    public List<TransactionDto> getAll() throws Exception {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{userId}/all")
    public List<TransactionDto> getAllByUser(@PathVariable int userId) {
        return transactionService.getAllByUser(userId);
    }

    @GetMapping("/{id}")
    public TransactionDto getTransactionById(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/{id}/avrg")
    public OptionalDouble getAverageTransactions(@PathVariable int id) {
        return transactionService.getAvrgSpendingByCategoryId(id);
    }

    @GetMapping("/{id}/sum")
    public int getSumOfTransactionByCategoryId(@PathVariable int id) {
      return transactionService.getSumOfTransactionByCategoryId(id);
    }

    @PostMapping("/add")
    public Long addTransaction(@RequestBody NewTransactionDto transactionDto) {
       return transactionService.createTransaction(transactionDto);
    }

    @PutMapping("")
    public boolean updateTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionService.updateTransaction(transactionDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTransaction( @PathVariable int id) {
        return transactionService.deleteTransaction(id);
    }

}
