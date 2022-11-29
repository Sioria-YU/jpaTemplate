package com.project.secure.controller;

import com.project.secure.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /*@Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException e) throws IOException {
        log.error("Responding with unauthorized error. Message - {}", e.getMessage());

        ErrorCode unAuthorizationCode = (ErrorCode) request.getAttribute("unauthorization.code");

        request.setAttribute("response.failure.code", unAuthorizationCode.getCode());
        try {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, unAuthorizationCode.getMessage());
        } catch (java.io.IOException ex) {
            log.error(ex.getMessage());
        }

    }*/

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // 유효한 자격증명을 제공하지 않고 접근하려 할때 401
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

}
