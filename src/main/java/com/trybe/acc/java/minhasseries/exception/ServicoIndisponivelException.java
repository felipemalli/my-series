package com.trybe.acc.java.minhasseries.exception;

public class ServicoIndisponivelException extends RuntimeException {

  public ServicoIndisponivelException() {
    super("Serviço temporariamente indisponível");
  }

}