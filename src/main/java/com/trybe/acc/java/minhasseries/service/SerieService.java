package com.trybe.acc.java.minhasseries.service;

import com.trybe.acc.java.minhasseries.exception.EpisodioExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieExistenteException;
import com.trybe.acc.java.minhasseries.exception.SerieNaoEncontradaException;
import com.trybe.acc.java.minhasseries.exception.ServicoIndisponivelException;
import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.repository.SerieRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {

  @Autowired
  private SerieRepository serieRepository;

  /**
   * Busca todas as séries.
   */
  public List<Serie> findAll() {
    return serieRepository.findAll();
  }

  /**
   * Adiciona uma série.
   */
  public Serie add(Serie serie) {
    boolean isSerieExist = serieRepository.existsByNome(serie.getNome());

    if (isSerieExist) {
      throw new SerieExistenteException();
    }

    return serieRepository.save(serie);
  }

  /**
   * Deleta uma serie.
   */
  public void delete(Integer id) {
    boolean serieExist = serieRepository.existsById(id);

    if (!serieExist) {
      throw new SerieNaoEncontradaException();
    }

    serieRepository.deleteById(id);
  }

  /**
   * Adiciona um episódio a uma série.
   */
  public Serie addEpisodio(Integer serieId, Episodio episodio) {
    Optional<Serie> serieOptional = serieRepository.findById(serieId);

    if (serieOptional.isEmpty()) {
      throw new SerieNaoEncontradaException();
    }
    Serie serie = serieOptional.get();
    List<Episodio> ep = serie.getEpisodios();

    if (ep.contains(episodio)) {
      throw new EpisodioExistenteException();
    }

    ep.add(episodio);
    return serieRepository.save(serie);
  }

  /**
   * Busca todos os episódios de uma série.
   */
  @CircuitBreaker (name = "serie", fallbackMethod = "fallbackFindAllEpisodio")
  public List<Episodio> findAllEpisodios(Integer serieId) {
    Optional<Serie> serieOptional = serieRepository.findById(serieId);

    if (serieOptional.isEmpty()) {
      throw new SerieNaoEncontradaException();
    }

    Serie serie = serieOptional.get();
    return serie.getEpisodios();
  }

  /**
   * Duração de todos os episódios.
   */
  public Map<String, Integer> getDuracaoDosEpisodios() {
    List<Serie> series = serieRepository.findAll();

    Integer tempoEmMinutos = series
            .stream()
            .flatMap(serie -> serie.getEpisodios().stream())
            .mapToInt(Episodio::getDuracaoEmMinutos)
            .sum();

    return Map.of("tempoEmMinutos", tempoEmMinutos);

  }

  public List<Episodio> fallbackFindAllEpisodio(
          Integer id,
          RuntimeException e
  ) throws ServicoIndisponivelException {
    throw new ServicoIndisponivelException();
  }
}