package com.irsan.base_project.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

import java.util.*;

public class URIUtil {

    public static String getRequestUriWithQueryParams(HttpServletRequest request) {
        String queryString = request.getQueryString();
        String queryClause = StringUtils.hasLength(queryString) ? "?" + queryString : "";

        String uri = (String) request.getAttribute("jakarta.servlet.include.request_uri");
        if (uri == null) {
            uri = request.getRequestURI();
        }

        return uri + queryClause;
    }

    public static Map<String, String> getHttpHeaders(HttpServletRequest request) {
        Map<String, String> headers = new LinkedHashMap<>();

        Enumeration<String> headerNames = request.getHeaderNames();

        for (String key : Collections.list(headerNames)) {
            headers.put(key, request.getHeader(key));
        }

        return headers;
    }

    public static String getRequestId(HttpServletRequest request) {
        return request.getAttribute("request-id").toString();
    }

}
