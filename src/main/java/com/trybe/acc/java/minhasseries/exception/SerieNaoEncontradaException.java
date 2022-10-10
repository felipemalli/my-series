package com.trybe.acc.java.minhasseries.exception;

public class SerieNaoEncontradaException extends RuntimeException {

  public SerieNaoEncontradaException() {
    super("Série não encontrada");
  }

}