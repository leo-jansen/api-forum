package br.com.forum.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String categoria;

  public Curso() {
  }

  public Curso(Long id, String nome, String categoria) {
    this.id = id;
    this.nome = nome;
    this.categoria = categoria;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getCategoria() {
    return categoria;
  }
}
