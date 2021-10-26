package com.example.smartbudget.Model;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Expenditure {
    UUID id;
    String description;
    float amount;
    LocalDateTime timeStamp;

    public Expenditure(String description, float amount) {
        this.description = description;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }

    public Expenditure(UUID id, String description, float amount, LocalDateTime timeStamp) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    public UUID getId() {
        return id;
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
