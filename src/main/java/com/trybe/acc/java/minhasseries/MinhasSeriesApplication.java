package com.trybe.acc.java.minhasseries;

import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MinhasSeriesApplication {

  public static void main(String[] args) {
    SpringApplication.run(MinhasSeriesApplication.class, args);
  }

  /**
   * Configuração Circuit Breaker 'serie'.
   */
  @Bean
  public CircuitBreakerConfigCustomizer circuitBreakerCustomizer() {
    return CircuitBreakerConfigCustomizer.of(
        "serie", builder -> builder
        .minimumNumberOfCalls(1)
        .failureRateThreshold(50)
    );
  }
}