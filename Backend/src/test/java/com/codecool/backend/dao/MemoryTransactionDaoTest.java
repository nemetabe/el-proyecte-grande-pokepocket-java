package com.codecool.backend.dao;

import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.dao.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryTransactionDaoTest {
    private MemoryTransactionDao memoryTransactionDao;

    @BeforeEach
    void setUp() {
        memoryTransactionDao = new MemoryTransactionDao();
    }

    @Test
    void getTransactionById_returnsCorrectTransaction() {
        NewTransactionDto transactionDto = new NewTransactionDto("Shopping", 1, 1000 );
        int transactionId = memoryTransactionDao.createTransaction(transactionDto);

        Transaction expected = new Transaction(transactionDto);
        Transaction actual = memoryTransactionDao.getTransactionById(transactionId);

        assertEquals(expected.getId(), actual.getId());
    }

    @Test
    void getTransactionById_returnsNullIfTransactionDoesNotExist() {
        Transaction actual = memoryTransactionDao.getTransactionById(1);
        assertNull(actual);
    }

    @Test
    void getAllTransactions_returnsAllTransactions() {
        NewTransactionDto newTransactionDto1 = new NewTransactionDto("Shopping", 1, 1000 );
        Transaction transaction1 = new Transaction(newTransactionDto1);
        transaction1.setId(0);
        memoryTransactionDao.createTransaction(newTransactionDto1);

        NewTransactionDto newTransactionDto2 = new NewTransactionDto("Shopping", 2, 1000 );
        Transaction transaction2 = new Transaction(newTransactionDto2);
        transaction2.setId(1);
        memoryTransactionDao.createTransaction(newTransactionDto2);

        List<Transaction> transactionsExpected = List.of(transaction1, transaction2);
        List<Transaction> transactionsActual;

        try {
            transactionsActual = memoryTransactionDao.getAllTransactions();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        assertEquals(transactionsExpected.size(), transactionsActual.size());
    }

    @Test
    void getAllTransactions_returnsEmptyListIfTransactionDoesNotExist() {
        assertThrowsExactly(SQLException.class, () -> memoryTransactionDao.getAllTransactions());
    }

    @Test
    void updateTransactionById_updatesTransaction() {

        String name = "Shopping";
        int categoryId = 1;
        int amount = 1000;
        NewTransactionDto newTransactionDto1 = new NewTransactionDto(name, categoryId, amount );

        int transactionId = memoryTransactionDao.createTransaction(newTransactionDto1);
        Transaction expected = new Transaction(newTransactionDto1);
        expected.setId(transactionId);

        String newName = "Groceries";
        int newCategoryId = 2;
        int newAmount = 100;

        expected.setName(newName);
        expected.setCategoryId(newCategoryId);
        expected.setAmount(newAmount);
        memoryTransactionDao.updateTransaction(expected);

        Transaction actual = memoryTransactionDao.getTransactionById(transactionId);

        assertEquals(expected, actual);
    }

    @Test
    void deleteTransactionById_returnsFalse_whenNoTransaction() {

        assertFalse(memoryTransactionDao.deleteTransaction(1));
    }

    @Test
    void deleteTransactionById_deletesTransaction() {
        NewTransactionDto newTransactionDto1 = new NewTransactionDto("Shopping", 1, 1000 );

        int transactionId = memoryTransactionDao.createTransaction(newTransactionDto1);
        assertTrue(memoryTransactionDao.deleteTransaction(transactionId));
    }

    @Test
    void getTransactionsByCategory_returnsCorrectTransactions() {
        NewTransactionDto newTransactionDto1 = new NewTransactionDto("Shopping", 1, 1000 );
        int transactionId1 = memoryTransactionDao.createTransaction(newTransactionDto1);

        NewTransactionDto newTransactionDto2 = new NewTransactionDto("Shopping", 2, 1000 );
        int transactionId2 = memoryTransactionDao.createTransaction(newTransactionDto2);

        assertEquals(1000, memoryTransactionDao.getSumOfTransactionByCategoryId(1));
    }

    @Test
    void getAvrgSpendingByCategoryId_returnsCorrectAvrgSpending() {
        NewTransactionDto newTransactionDto1 = new NewTransactionDto("Shopping", 1, 1000 );
        int transactionId1 = memoryTransactionDao.createTransaction(newTransactionDto1);

        NewTransactionDto newTransactionDto2 = new NewTransactionDto("Shopping", 1, 200 );
        int transactionId2 = memoryTransactionDao.createTransaction(newTransactionDto2);

        assertEquals(600, memoryTransactionDao.getAvrgSpendingByCategoryId(1));
    }

}