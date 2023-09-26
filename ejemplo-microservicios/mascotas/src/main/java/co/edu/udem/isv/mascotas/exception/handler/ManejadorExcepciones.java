package co.edu.udem.isv.mascotas.exception.handler;


import co.edu.udem.isv.mascotas.exception.DatosNoEncontradosException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

@RestControllerAdvice
@Log4j2
public class ManejadorExcepciones {

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity procesarViolationException(ConstraintViolationException ex, WebRequest request){
        log.error("Error invocando {}: {}", request, ex.getMessage(), ex);
        String mensaje = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
    }

    @ExceptionHandler(DatosNoEncontradosException.class)
    protected ResponseEntity procesarDatosNoEncontradosException(DatosNoEncontradosException ex, WebRequest request){
        log.error("Error invocando {}: {}", request, ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

    }
}
