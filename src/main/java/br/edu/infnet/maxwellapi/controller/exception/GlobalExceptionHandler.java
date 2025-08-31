package br.edu.infnet.maxwellapi.controller.exception;

import br.edu.infnet.maxwellapi.model.domain.exceptions.ArbitroInvalidoException;
import br.edu.infnet.maxwellapi.model.domain.exceptions.ArbitroNaoEncontradoException;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorInvalidoException;
import br.edu.infnet.maxwellapi.model.domain.exceptions.CompetidorNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CompetidorInvalidoException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(CompetidorInvalidoException ex) {
        Map<String, String> errors = new HashMap<>();
            errors.put("Data/Hora", LocalDateTime.now().toString());
            errors.put("Erro",HttpStatus.BAD_REQUEST.toString());
            errors.put("Erro valido",ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArbitroInvalidoException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(ArbitroInvalidoException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Erro",HttpStatus.BAD_REQUEST.toString());
        errors.put("Erro valido",ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CompetidorNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(CompetidorNaoEncontradoException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Erro",HttpStatus.NOT_FOUND.toString());
        errors.put("Erro valido",ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArbitroNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(ArbitroNaoEncontradoException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Erro",HttpStatus.NOT_FOUND.toString());
        errors.put("Erro valido",ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(IllegalArgumentException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Erro",HttpStatus.BAD_REQUEST.toString());
        errors.put("Erro valido",ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("Data/Hora", LocalDateTime.now().toString());
        errors.put("Erro",HttpStatus.INTERNAL_SERVER_ERROR.toString());
        errors.put("Erro valido",ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }



}
