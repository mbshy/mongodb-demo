package dev.shiravand.mongodbdemo.domain.core;

import dev.shiravand.mongodbdemo.application.data.ExpenseDto;
import dev.shiravand.mongodbdemo.shared.IEntityMapper;
import dev.shiravand.mongodbdemo.domain.model.Expense;

public interface IExpenseMapper extends IEntityMapper<Expense, ExpenseDto> {
}
