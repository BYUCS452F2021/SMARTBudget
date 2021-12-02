package com.example.smartbudget.Model;


import java.time.LocalDate;
import java.util.UUID;

public class Expenditure {
    UUID id;
    Category category;
    String description;
    float amount;
    String timeStamp;

    public Expenditure(Category category, String description, float amount, LocalDate timeStamp) {
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.id = UUID.randomUUID();
        this.timeStamp = timeStamp.toString();
    }
    public Expenditure(UUID id, String description, float amount, int year, int month, int day,
                       Category category) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.timeStamp = LocalDate.of(year, month, day).toString();
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

    private LocalDate getTime(){
        return LocalDate.parse(timeStamp);
    }

    public int getYear() {
        return getTime().getYear();
    }

    public int getMonth() {
        return getTime().getMonthValue();
    }

    public int getDay() {
        return getTime().getDayOfMonth();
    }

    public Category getCategory(){
        return category;
    }
}
