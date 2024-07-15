package com.example.demo.exception;

public class PatientException extends Exception {
    public PatientException(String s, Throwable e) {
        super(s,e);
    }
}
