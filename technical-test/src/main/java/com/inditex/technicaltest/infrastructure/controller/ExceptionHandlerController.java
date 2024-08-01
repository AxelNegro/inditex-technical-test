package com.inditex.technicaltest.infrastructure.controller;

import com.inditex.technicaltest.common.exceptions.InditexException;
import com.inditex.technicaltest.infrastructure.controller.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.inditex.technicaltest.common.enums.InditexExceptionsEnum.ERROR_400_BAD_REQUEST;
import static com.inditex.technicaltest.common.enums.InditexExceptionsEnum.ERROR_500_SERVER_ERROR;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = InditexException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<MessageDto> handleInditexException(
            InditexException ex, WebRequest request) {
        log.error(ex.getMessageDto().getMessage());
        return ResponseEntity.badRequest().body(ex.getMessageDto());
    }
    @ExceptionHandler(value = HttpClientErrorException.BadRequest.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<MessageDto> handleBadRequest(
            RuntimeException ex, WebRequest request) {
        log.error(ex.getMessage());
        return ResponseEntity.badRequest().body(ERROR_400_BAD_REQUEST.getMessageDto());
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<MessageDto> handleInternalServerError(
            RuntimeException ex, WebRequest request) {
        log.error(ex.getMessage());
        return ResponseEntity.internalServerError().body(ERROR_500_SERVER_ERROR.getMessageDto());
    }
}
