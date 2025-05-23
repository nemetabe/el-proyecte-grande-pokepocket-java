package com.codecool.backend.service;

import com.codecool.backend.controller.dto.CategoryDto;
import com.codecool.backend.controller.dto.NewTransactionDto;
import com.codecool.backend.controller.dto.TransactionDto;
import com.codecool.backend.controller.exception.CategoryNotFoundException;
import com.codecool.backend.controller.exception.MemberNotFoundException;
import com.codecool.backend.controller.exception.TransactionNotFoundException;
import com.codecool.backend.model.transaction.Category;
import com.codecool.backend.model.transaction.Transaction;
import com.codecool.backend.model.user.Member;
import com.codecool.backend.repository.CategoryRepository;
import com.codecool.backend.repository.MemberRepository;
import com.codecool.backend.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepositoryMock;

    @Mock
    private MemberRepository memberRepositoryMock;

    @Mock
    private CategoryRepository categoryRepositoryMock;

    @BeforeEach
    public void setup() {
        transactionService = new TransactionService(transactionRepositoryMock, memberRepositoryMock, categoryRepositoryMock);
    }

    @Test
    public void getAllCategories_twoCategoriesExist_returnListOfTwoCategoryDto() {
        Category category1 = new Category();
        category1.setType(Category.CategoryType.BILLS);
        Category category2 = new Category();
        category2.setType(Category.CategoryType.CLOTHING);
        when(categoryRepositoryMock.findAll()).thenReturn(List.of(category1, category2));

        List<CategoryDto> expectedAnswer = Stream.of(category1, category2).map(CategoryDto::new).toList();
        List<CategoryDto> actualAnswer = transactionService.getAllCategories();

        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void getAllByUser_memberExistAndStartDateAdded_ReturnListOfTransactions() {
        when(memberRepositoryMock.findMemberByEmail(anyString())).thenReturn(Optional.of(new Member()));
        when(transactionRepositoryMock.getAllByMember(any())).thenReturn(Optional.of(generateTransactionList()));

        List<TransactionDto> expectedAnswer = generateTransactionList().stream().map(TransactionDto::new).toList();
        List<TransactionDto> actualAnswer = transactionService.getAllByUser("email", null);

        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void getAllByUser_memberNotExist_throwMemberNotFoundException() {
        when(memberRepositoryMock.findMemberByEmail(anyString())).thenReturn(Optional.empty());

        assertThrows(MemberNotFoundException.class, () -> transactionService.getAllByUser("email", null));
    }

    @Test
    public void getAllByUser_memberExistAndStartDateNotAdded_callGetAllByMember() {
        when(memberRepositoryMock.findMemberByEmail(anyString())).thenReturn(Optional.of(new Member()));
        when(transactionRepositoryMock.getAllByMember(any())).thenReturn(Optional.of(generateTransactionList()));

        transactionService.getAllByUser("email", null);

        verify(transactionRepositoryMock, times(1)).getAllByMember(any());
    }

    @Test
    public void getAllByUser_memberExistAndStartDateAdded_callGetAllByMEmberAndDateAfter() {
        when(memberRepositoryMock.findMemberByEmail(anyString())).thenReturn(Optional.of(new Member()));
        when(transactionRepositoryMock.getAllByMemberAndDateAfter(any(), any())).thenReturn(Optional.of(generateTransactionList()));

        transactionService.getAllByUser("email", LocalDate.now());

        verify(transactionRepositoryMock, times(1)).getAllByMemberAndDateAfter(any(), any());
    }

    @Test
    public void getAllByUser_memberExistAndNoTransaction_throwTransactionNotFoundException() {
        when(memberRepositoryMock.findMemberByEmail(anyString())).thenReturn(Optional.of(new Member()));
        when(transactionRepositoryMock.getAllByMember(any())).thenReturn(Optional.empty());

        assertThrows(TransactionNotFoundException.class, () -> transactionService.getAllByUser("email", null));
    }

    @Test
    public void createTransaction_memberNotExist_throwMemberNotFoundException() {
        when(memberRepositoryMock.findMemberByEmail(anyString())).thenReturn(Optional.empty());

        assertThrows(MemberNotFoundException.class, () -> transactionService.createTransaction("email", generateNewTransactionDto()));
    }

    @Test
    public void createTransaction_categoryNotExist_throwCategoryNotFoundException() {
        when(memberRepositoryMock.findMemberByEmail(anyString())).thenReturn(Optional.of(new Member()));
        when(categoryRepositoryMock.getCategoryById(anyLong())).thenReturn(Optional.empty());

        assertThrows(CategoryNotFoundException.class, () -> transactionService.createTransaction("email", generateNewTransactionDto()));
    }

    @Test
    public void createTransaction_happyCase_callSaveAndReturnTransactionId() {
        when(memberRepositoryMock.findMemberByEmail(anyString())).thenReturn(Optional.of(new Member()));
        when(categoryRepositoryMock.getCategoryById(anyLong())).thenReturn(Optional.of(new Category()));
        when(transactionRepositoryMock.save(any())).thenReturn(generateTransaction());

        Long expectedId = 1L;
        Long actualId = transactionService.createTransaction("email", generateNewTransactionDto());

        verify(transactionRepositoryMock, times(1)).save(any());
        assertEquals(expectedId, actualId);
    }

    @Test
    public void getTransactionsByCategory_transactionsNotExist_throwTransactionNotFoundException () {
        when(transactionRepositoryMock.getTransactionsByCategory(any())).thenReturn(Optional.empty());

        assertThrows(TransactionNotFoundException.class, () -> transactionService.getTransactionsByCategory(new Category()));
    }

    @Test
    public void getTransactionsByCategory_transactionsExist_returnListOfTransactionDto () {
        when(transactionRepositoryMock.getTransactionsByCategory(any())).thenReturn(Optional.of(generateTransactionList()));

        List<TransactionDto> expectedAnswer = generateTransactionList().stream().map(TransactionDto::new).toList();
        List<TransactionDto> actualAnswer = transactionService.getTransactionsByCategory(null);

        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void getTransactionById_transactionNotExist_throwNoSuchElementException () {
        when(transactionRepositoryMock.getTransactionById(anyInt())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> transactionService.getTransactionById(1));
    }

    @Test
    public void getTransactionById_transactionExist_returnTransactionDto () {
        when(transactionRepositoryMock.getTransactionById(anyInt())).thenReturn(Optional.of(generateTransaction()));

        TransactionDto expectedAnswer = new TransactionDto(generateTransaction());
        TransactionDto actualAnswer = transactionService.getTransactionById(1);

        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void updateTransaction_happyCase_callSaveMethod() {
        transactionService.updateTransaction(generateTransactionDto());

        verify(transactionRepositoryMock, times(1)).save(any());
    }

    @Test
    public void deleteTransaction_happyCase_callDeleteMethod() {
        transactionService.deleteTransaction(1);

        verify(transactionRepositoryMock, times(1)).deleteTransactionById(anyInt());
    }

    @Test
    public void getSumOfTransactionByCategoryId_noTransactions_throwTransactionNotFoundException () {
        when(transactionRepositoryMock.getAllByCategoryId(anyInt())).thenReturn(Optional.empty());

        assertThrows(TransactionNotFoundException.class, () -> transactionService.getSumOfTransactionByCategoryId(0));
    }

    @Test
    public void getSumOfTransactionByCategoryId_transactionsWithCategoryExist_returnSum () {
        when(transactionRepositoryMock.getAllByCategoryId(anyInt())).thenReturn(Optional.of(generateTransactionList()));

        int expectedAnswer = 60;
        int actualAnswer = transactionService.getSumOfTransactionByCategoryId(0);

        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void getAvgSpendingByCategory_noTransactions_throwTransactionNotFoundException () {
        when(transactionRepositoryMock.getAllByCategoryId(anyInt())).thenReturn(Optional.empty());

        assertThrows(TransactionNotFoundException.class, () -> transactionService.getAvgSpendingByCategoryId(0));
    }

    @Test
    public void getAvgSpendingByCategory_transactionsWithCategoryExist_returnAverage () {
        when(transactionRepositoryMock.getAllByCategoryId(anyInt())).thenReturn(Optional.of(generateTransactionList()));

        OptionalDouble expectedAnswer = OptionalDouble.of(20);
        OptionalDouble actualAnswer = transactionService.getAvgSpendingByCategoryId(0);

        assertEquals(expectedAnswer, actualAnswer);
    }

    private NewTransactionDto generateNewTransactionDto() {
        return new NewTransactionDto("newDto", 2L, 100);
    }

    private TransactionDto generateTransactionDto() {
        return new TransactionDto(1L, "name", null, 10, 1, null);
    }

    private Transaction generateTransaction() {
        Transaction transaction = new Transaction();
        transaction.setAmount(10);
        transaction.setName("tran1");
        transaction.setId(1L);
        transaction.setMember(new Member());

        return transaction;
    }

    private List<Transaction> generateTransactionList() {
        Transaction transaction1 = new Transaction();
        transaction1.setAmount(10);
        transaction1.setName("tran1");
        transaction1.setMember(new Member());
        Transaction transaction2 = new Transaction();
        transaction2.setAmount(20);
        transaction2.setName("tran2");
        transaction2.setMember(new Member());
        Transaction transaction3 = new Transaction();
        transaction3.setAmount(30);
        transaction3.setName("tran3");
        transaction3.setMember(new Member());
        return new ArrayList<>(List.of(transaction1, transaction2, transaction3));
    }
}