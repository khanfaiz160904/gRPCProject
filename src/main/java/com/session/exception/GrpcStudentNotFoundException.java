package com.session.exception;

public class GrpcStudentNotFoundException extends RuntimeException {
    public GrpcStudentNotFoundException(String message) {
        super(message);
    }

    public GrpcStudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
