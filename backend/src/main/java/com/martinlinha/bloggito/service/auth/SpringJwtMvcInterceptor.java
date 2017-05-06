package com.martinlinha.bloggito.service.auth;

import com.martinlinha.bloggito.service.auth.annotation.JwtSecured;
import io.jsonwebtoken.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by martinlinha on 30.04.17.
 */
public class SpringJwtMvcInterceptor extends HandlerInterceptorAdapter {

    private static final String AUTHENTICATION_BEARER = "Bearer ";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            if (method.hasMethodAnnotation(JwtSecured.class)) {
                String authenticationHeader = request.getHeader("Authorization");
                if (authenticationHeader == null || !authenticationHeader.startsWith(AUTHENTICATION_BEARER)) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return false;
                } else {
                    try {
                        String authenticationHeaderBearerless = authenticationHeader.
                                substring(AUTHENTICATION_BEARER.length(), authenticationHeader.length());
                        Jwts.parser()
                                .setSigningKey("secretkey")
                                .parseClaimsJws(authenticationHeaderBearerless).getBody();
                    } catch (MalformedJwtException | SignatureException | ExpiredJwtException e) {
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
