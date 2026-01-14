package com.winterflame.aura.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.winterflame.aura.dto.ErrorResponseDTO;
import com.winterflame.aura.repository.SqlErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SqlErrorException.class)
    public ResponseEntity<ErrorResponseDTO> handleSqlException(SqlErrorException sqlErrorException) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                sqlErrorException.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
