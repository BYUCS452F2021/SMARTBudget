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

    public UUID getId() {
        return id;
    }

    public UUID getCategory() {
        return category.getId();
    }

    public String getDescription() {
        return description;
    }

    public float getAmount() {
        return amount;
    }

    public int getYear() {
        return timeStamp.getYear();
    }

    public int getMonth() {
        return timeStamp.getMonthValue();
    }

    public int getDay() {
        return timeStamp.getDayOfMonth();
    }

}
