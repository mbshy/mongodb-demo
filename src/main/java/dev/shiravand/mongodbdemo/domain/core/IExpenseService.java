package dev.shiravand.mongodbdemo.domain.core;

import dev.shiravand.mongodbdemo.domain.impl.ExpenseService;
import dev.shiravand.mongodbdemo.domain.model.Expense;

import java.util.List;

public interface IExpenseService {
    public void addExpense(Expense expense);
    public void updateExpense(Expense expense);
    public List<Expense> getAllExpenses();
    public Expense getExpenseByName(String name);
    public void deleteExpense(String id);
}
