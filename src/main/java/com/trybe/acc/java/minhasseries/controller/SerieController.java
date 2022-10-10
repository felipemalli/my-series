package com.trybe.acc.java.minhasseries.controller;

import com.trybe.acc.java.minhasseries.model.Episodio;
import com.trybe.acc.java.minhasseries.model.Serie;
import com.trybe.acc.java.minhasseries.service.SerieService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class SerieController {

  private SerieService serieService;

  @Autowired
  public SerieController(SerieService serieService) {
    this.serieService = serieService;
  }

  @PostMapping
  public Serie add(@RequestBody Serie serie) {
    return serieService.add(serie);
  }

  @GetMapping
  public List<Serie> findAll() {
    return serieService.findAll();
  }

  @DeleteMapping("/{serie_id}")
  public void delete(@PathVariable("serie_id") Integer id) {
    serieService.delete(id);
  }

  @PostMapping("/{serie_id}/episodios")
  public Serie addEpisodio(
          @PathVariable("serie_id") Integer serieId,
          @RequestBody Episodio episodio) {
    return serieService.addEpisodio(serieId, episodio);
  }

  @GetMapping("/{serie_id}/episodios")
  public List<Episodio> findAllEpisodios(@PathVariable("serie_id") Integer serieId) {
    return serieService.findAllEpisodios(serieId);
  }

  @GetMapping("/tempo")
  public Map<String, Integer> getDuracaoDosEpisodios() {
    return serieService.getDuracaoDosEpisodios();
  }
}