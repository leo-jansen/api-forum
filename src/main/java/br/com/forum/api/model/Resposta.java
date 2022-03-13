package br.com.forum.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Resposta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String mensagem;
  private Boolean solucao;
  @Column(name = "data_criacao")
  private LocalDateTime dataCriacao;
  @ManyToOne(fetch = FetchType.LAZY)
  private Usuario autor;
  @ManyToOne(fetch = FetchType.LAZY)
  private Topico topico;

  public Resposta() {
  }

  public Resposta(Long id, String mensagem, Usuario autor, Topico topico, Boolean solucao, LocalDateTime dataCriacao) {
    this.id = id;
    this.mensagem = mensagem;
    this.autor = autor;
    this.topico = topico;
    this.solucao = solucao;
    this.dataCriacao = dataCriacao;
  }

  public Resposta(String mensagem, Usuario autor, Topico topico) {
    this.mensagem = mensagem;
    this.autor = autor;
    this.topico = topico;
    this.solucao = false;
    this.dataCriacao = LocalDateTime.now();
  }

  public Long getId() {
    return id;
  }

  public String getMensagem() {
    return mensagem;
  }

  public Boolean getSolucao() {
    return solucao;
  }

  public LocalDateTime getDataCriacao() {
    return dataCriacao;
  }

  public Usuario getAutor() {
    return autor;
  }

  public Topico getTopico() {
    return topico;
  }

  public void setSolucao(Boolean solucao) {
    this.solucao = solucao;
  }

}
