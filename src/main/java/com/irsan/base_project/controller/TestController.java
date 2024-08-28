package com.irsan.base_project.controller;

import com.irsan.base_project.util.URIUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.irsan.base_project.util.URIUtil.getHttpHeaders;
import static com.irsan.base_project.util.URIUtil.getRequestUriWithQueryParams;

@RestController
@Slf4j
public class TestController {

    @GetMapping("{name}")
    ResponseEntity<?> test(@PathVariable String name) {
        log.info("hello {}, my name irsan", name);
        return ResponseEntity.ok("Hello " + name);
    }

    @PostMapping("save")
    ResponseEntity<?> test(@RequestParam(value = "message", required = false) String message, @RequestBody TestRequest request, HttpServletRequest httpServletRequest) {
        log.info("request id {}", URIUtil.getRequestId(httpServletRequest));
        log.info("uri {}", getRequestUriWithQueryParams(httpServletRequest));
        log.info("headers {}", getHttpHeaders(httpServletRequest));
        log.info("message {}", message);

        return ResponseEntity.ok(request);
    }

    @Data
    private static class TestRequest {

        private String name;

        private String email;

    }

}
