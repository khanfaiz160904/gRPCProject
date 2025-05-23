package com.session.exception;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;

public class GrpcExceptionHandler {
    public static StatusRuntimeException handleException(Exception e) {
        if (e instanceof GrpcStudentNotFoundException) {
            return Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException();
        } else {
            return Status.NOT_FOUND
                    .withDescription(e.getMessage())
                    .asRuntimeException();
        }
    }
}
