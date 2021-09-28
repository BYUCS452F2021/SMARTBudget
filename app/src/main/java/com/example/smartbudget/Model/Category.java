package com.example.smartbudget.Model;

import androidx.annotation.NonNull;

import java.util.UUID;

public class Category {
    UUID id;
    String name;
    float allotment;

    public Category(UUID id, String name, float allotment){
        this.name = name;
        this.allotment = allotment;
        this.id = id;
    }

    public Category(String name, float allotment) {
        this.name = name;
        this.allotment = allotment;
    }

    public String getName() {
        return name;
    }

    public float getAllotment() {
        return allotment;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
