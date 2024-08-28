package com.irsan.base_project.exception;

import com.irsan.base_project.util.enumeration.ErrorCode;
import lombok.Getter;

import java.io.Serial;

@Getter
public class DefaultException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 8344197785226579404L;

    private final ErrorCode errorCode;

    private final Object request;

    private final Object response;

    public DefaultException(ErrorCode errorCode, Object request, Object response, String message) {
        super(message);

        this.errorCode = errorCode;
        this.request = request;
        this.response = response;
    }

}
