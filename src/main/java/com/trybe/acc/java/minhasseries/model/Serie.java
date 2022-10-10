package com.trybe.acc.java.minhasseries.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * Entidade Serie.
 */
@Entity
public class Serie {

  /**
   * Atributos.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String nome;
  @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
  private List<Episodio> episodios = new ArrayList<>();

  /**
   * Construtores.
   */
  public Serie() {
  }

  public Serie(String nome) {
    this.nome = nome;
  }

  /**
   * Métodos.
   */
  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Episodio> getEpisodios() {
    return episodios;
  }

  public void adicionarEpisodio(Episodio episodio) {
    this.episodios.add(episodio);
  }

}