package dev.shiravand.mongodbdemo.application.impl;

import dev.shiravand.mongodbdemo.application.core.IExpenseApplicationService;
import dev.shiravand.mongodbdemo.application.data.ExpenseDto;
import dev.shiravand.mongodbdemo.domain.core.IExpenseMapper;
import dev.shiravand.mongodbdemo.domain.core.IExpenseService;
import dev.shiravand.mongodbdemo.domain.model.Expense;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseApplicationService implements IExpenseApplicationService {
    private final IExpenseService expenseService;
    private final IExpenseMapper expenseMapper;

    public void addExpense(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.toEntity(expenseDto);
        expenseService.addExpense(expense);
    }

    public void updateExpense(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.toEntity(expenseDto);
        expenseService.updateExpense(expense);
    }

    public List<ExpenseDto> getAllExpenses() {
        List<Expense> allExpenses = expenseService.getAllExpenses();
        return allExpenses.stream().map(expenseMapper::toDto).toList();
    }

    public ExpenseDto getExpenseByName(String name) {
        return expenseMapper.toDto(expenseService.getExpenseByName(name));
    }

    public void deleteExpense(String id) {
        expenseService.deleteExpense(id);
    }

}
