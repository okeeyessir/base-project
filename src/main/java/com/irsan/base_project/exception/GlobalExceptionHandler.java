package com.irsan.base_project.exception;

import com.irsan.base_project.dto.ErrorCaptureDto;
import com.irsan.base_project.util.URIUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DefaultException.class)
    public final ResponseEntity<Object> handleDefaultException(DefaultException ex, HttpServletRequest request) {
        ErrorCaptureDto<Object, Object> dto = new ErrorCaptureDto<>();
        dto.setHeaders(URIUtil.getHttpHeaders(request));
        dto.setRequest(ex.getRequest());
        dto.setResponse(ex.getResponse());

        String requestId = URIUtil.getRequestId(request);
        dto.setRequestId(requestId);

        dto.setMethod(request.getMethod());
        dto.setUri(URIUtil.getRequestUriWithQueryParams(request));
        dto.setErrorCode(ex.getErrorCode());
        dto.setErrorMessage(ex.getMessage());

        return new ResponseEntity<>(requestId, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
