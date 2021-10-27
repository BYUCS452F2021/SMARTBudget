package com.example.smartbudget.Model;


import java.time.LocalDate;
import java.util.UUID;

public class Expenditure {
    UUID id;
    Category category;
    String description;
    float amount;
    LocalDate timeStamp;

    public Expenditure(Category category, String description, float amount) {
        this.description = description;
        this.amount = amount;
        this.timeStamp = LocalDate.now();
    }
    public Expenditure(UUID id, String description, float amount, int year, int month, int day,
                       Category category) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.timeStamp = LocalDate.of(year, month, day);
        this.category = category;
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

    public Category getCategory(){
        return category;
    }
}
