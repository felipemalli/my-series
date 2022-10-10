package com.trybe.acc.java.minhasseries.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Episodio {

  /**
   * Atributos.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private int numero;
  private int duracaoEmMinutos;
  @ManyToOne
  @JoinColumn(name = "serie_id")
  private Serie serie;

  /**
   * Construtores.
   */
  public Episodio() {
  }

  public Episodio(int numero, int duracaoEmMinutos) {
    this.numero = numero;
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  public Episodio(Integer id, int numero, int duracaoEmMinutos, Serie serie) {
    this.id = id;
    this.numero = numero;
    this.duracaoEmMinutos = duracaoEmMinutos;
    this.serie = serie;
  }

  /**
   * Métodos.
   */
  public Integer getId() {
    return id;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getDuracaoEmMinutos() {
    return duracaoEmMinutos;
  }

  public void setDuracaoEmMinutos(int duracaoEmMinutos) {
    this.duracaoEmMinutos = duracaoEmMinutos;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Episodio)) {
      return false;
    }
    Episodio episodio = (Episodio) obj;
    return episodio.numero == this.numero;
  }
}