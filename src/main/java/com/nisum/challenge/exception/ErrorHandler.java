package com.nisum.challenge.exception;

import com.nisum.challenge.exception.custom.InvalidJWTException;
import com.nisum.challenge.exception.custom.UserInvalidEmailException;
import com.nisum.challenge.exception.custom.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleNotFoundException(ChallengeAbstractException ex) {
        log.error("[ErrorHandler:NotFoundException] " + ex.getMessage());
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .message(ex.getMessage())
                        .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {UserInvalidEmailException.class})
    public ResponseEntity<ErrorMessage> handleBadRequestException(ChallengeAbstractException ex) {
        log.error("[ErrorHandler:handleBadRequestException] " + ex.getMessage());
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .message(ex.getMessage())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidJWTException.class})
    public ResponseEntity<ErrorMessage> handleUnauthorizedException(ChallengeAbstractException ex) {
        log.error("[ErrorHandler:handleUnauthorizedException] " + ex.getMessage());
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .message(ex.getMessage())
                        .build(), HttpStatus.UNAUTHORIZED);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        final BindingResult bindingResult = ex.getBindingResult();
        List<ErrorMessage> errorList = new ArrayList<>(1);
        if (bindingResult.hasErrors()) {
            final List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrorList) {
                String field = fieldError.getField();
                errorList.add(ErrorMessage.builder().message(field + ": " + fieldError.getDefaultMessage())
                        .build());
            }
        }
        return new ResponseEntity<>(errorList, headers, status);
    }
}
