package com.emiya.api.error;

public class ServerException extends RuntimeException {
    public int code;
    public String message;
}