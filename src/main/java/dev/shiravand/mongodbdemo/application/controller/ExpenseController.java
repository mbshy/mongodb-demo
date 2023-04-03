package dev.shiravand.mongodbdemo.application.controller;

import dev.shiravand.mongodbdemo.application.core.IExpenseApplicationService;
import dev.shiravand.mongodbdemo.application.data.ExpenseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {
    private final IExpenseApplicationService expenseApplicationService;

    @PostMapping
    public ResponseEntity addExpense(@RequestBody ExpenseDto expenseDto) {
        expenseApplicationService.addExpense(expenseDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateExpense(@RequestBody ExpenseDto expenseDto) {
        expenseApplicationService.updateExpense(expenseDto);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        return ResponseEntity.ok(expenseApplicationService.getAllExpenses());
    }

    @GetMapping("/{name}")
    public ResponseEntity<ExpenseDto> getExpenseByName(@PathVariable String name) {
        return ResponseEntity.ok(expenseApplicationService.getExpenseByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id) {
        expenseApplicationService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
