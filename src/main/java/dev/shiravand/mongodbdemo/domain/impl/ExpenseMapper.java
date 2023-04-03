package dev.shiravand.mongodbdemo.domain.impl;

import dev.shiravand.mongodbdemo.application.data.ExpenseDto;
import dev.shiravand.mongodbdemo.domain.core.IExpenseMapper;
import dev.shiravand.mongodbdemo.domain.model.Expense;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper implements IExpenseMapper {
    @Override
    public Expense toEntity(ExpenseDto dto) {
        return new Expense(dto.getId(), dto.getExpenseName(), dto.getExpenseCategory(), dto.getExpenseAmount());
    }

    @Override
    public ExpenseDto toDto(Expense entity) {
        return new ExpenseDto(entity.getId(), entity.getExpenseName(), entity.getExpenseCategory(), entity.getExpenseAmount());
    }
}
