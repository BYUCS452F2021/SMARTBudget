package com.example.smartbudget.Request;

import java.util.UUID;

public class ReadBudgetRequest {
    private UUID id;

    public ReadBudgetRequest(UUID id) {
        if (id == null){
            throw new IllegalArgumentException("id is null");
        }
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
