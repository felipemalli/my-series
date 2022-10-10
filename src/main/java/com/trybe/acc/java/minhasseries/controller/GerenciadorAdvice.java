package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.ErroInesperadoException;
import com.trybe.acc.java.minhasseries.exception.ErrorPattern;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
import com.trybe.acc.java.minhasseries.exception.ServicoIndisponivelException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GerenciadorAdvice {

  /** Retorna objeto erro com mensagem e status 404. */
  @ExceptionHandler(SerieNaoEncontradaException.class)
  public ResponseEntity<ErrorPattern> handlerNotFound(RuntimeException exception) {
    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(new ErrorPattern(exception.getMessage()));
  }

  /** Retorna objeto erro com mensagem e status 409. */
  @ExceptionHandler({ SerieExistenteException.class, EpisodioExistenteException.class, })
  public ResponseEntity<ErrorPattern> handlerConflict(RuntimeException exception) {
    return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(new ErrorPattern(exception.getMessage()));
  }

  /** Retorna objeto erro com mensagem e status 500. */
  @ExceptionHandler(ErroInesperadoException.class)
  public ResponseEntity<ErrorPattern> handlerInternalServerError(Exception exception) {
    return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new ErrorPattern(exception.getMessage()));
  }

  /** Retorna objeto erro com mensagem e status 503. */
  @ExceptionHandler(ServicoIndisponivelException.class)
  public ResponseEntity<ErrorPattern> handlerUnavailableError(Exception exception) {
    return ResponseEntity
            .status(HttpStatus.SERVICE_UNAVAILABLE)
            .body(new ErrorPattern(exception.getMessage()));
  }
}