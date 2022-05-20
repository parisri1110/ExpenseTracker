package com.realtime.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realtime.expensetracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

	
}
