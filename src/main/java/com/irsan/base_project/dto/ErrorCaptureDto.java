package com.irsan.base_project.dto;

import com.irsan.base_project.util.enumeration.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCaptureDto<R, P> {

    private Map<String, String> headers;

    private R request;

    private P response;

    private String requestId;

    private String method;

    private String uri;

    private ErrorCode errorCode;

    private String errorMessage;

}
