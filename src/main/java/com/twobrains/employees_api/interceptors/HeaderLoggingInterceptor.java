package com.twobrains.employees_api.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Collections;
import java.util.Set;

@Component
public class HeaderLoggingInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(HeaderLoggingInterceptor.class);

    private static final Set<String> SENSITIVE_HEADERS = Set.of("authorization", "cookie", "set-cookie");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("📥 Incoming Request: [{} {}]", request.getMethod(), request.getRequestURI());

        Collections.list(request.getHeaderNames())
                .forEach(headerName -> {
                    String lowerCaseHeader = headerName.toLowerCase();
                    if (SENSITIVE_HEADERS.contains(lowerCaseHeader)) {
                        logger.info("🔒 Header [{}] = [REDACTED]", headerName);
                    } else {
                        logger.info("➡️ Header [{}] = {}", headerName, request.getHeader(headerName));
                    }
                });

        return true;
    }
}
