package com.example.smartbudget.Model;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Expenditure {
    UUID id;
    Category category;
    String description;
    float amount;
    LocalDateTime timeStamp;

    public Expenditure(Category category, String description, float amount) {
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }
}
