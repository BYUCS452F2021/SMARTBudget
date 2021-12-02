package com.example.smartbudget.Response;

public class Response {
    private boolean success;
    private String message;

    public Response(String message) {
        this.message = message;
        this.success = false;
    }

    public Response() {
        this.success = true;
        this.message = "Success!";
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
