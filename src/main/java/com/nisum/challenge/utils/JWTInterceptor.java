package com.nisum.challenge.utils;

import com.nisum.challenge.exception.custom.InvalidJWTException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Optional<String> auth = Optional.ofNullable(request.getHeader("Authorization"));
        if (auth.isPresent()) {
            try {
                String token = auth.get().split(" ")[1];
                request.setAttribute("token", token);
            } catch (ArrayIndexOutOfBoundsException e1) {
                log.debug(e1.getMessage());
                throw new InvalidJWTException();
            } catch (Exception e3) {
                log.debug(e3.getMessage());
                throw new InvalidJWTException();
            }
        } else if (request.getRequestURI().equals("/users")) {
            throw new InvalidJWTException();
        }
        return true;
    }
}
