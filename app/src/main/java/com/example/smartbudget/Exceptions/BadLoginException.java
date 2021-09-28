package com.example.smartbudget.Exceptions;

public class BadLoginException extends Exception{
    public BadLoginException() {
        super("No budget matches that username and password");
    }
}
