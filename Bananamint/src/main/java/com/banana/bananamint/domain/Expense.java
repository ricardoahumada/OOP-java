package com.banana.bananamint.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    private Integer Id;

    private Customer user;

    private double amount;

    private LocalDate dueDate;

    private Account moneyFrom;

    private String status;

}
