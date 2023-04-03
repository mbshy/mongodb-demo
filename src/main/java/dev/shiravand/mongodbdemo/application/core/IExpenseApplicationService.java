package dev.shiravand.mongodbdemo.application.core;

import dev.shiravand.mongodbdemo.application.data.ExpenseDto;

import java.util.List;

public interface IExpenseApplicationService {
    public void addExpense(ExpenseDto expenseDto);
    public void updateExpense(ExpenseDto expenseDto);
    public List<ExpenseDto> getAllExpenses();
    public ExpenseDto getExpenseByName(String name);
    public void deleteExpense(String id);
}
