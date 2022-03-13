package br.com.forum.api.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Topico {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String mensagem;
  @Column(name = "data_criacao")
  private LocalDateTime dataCriacao;
  @ManyToOne(fetch = FetchType.LAZY)
  private Usuario autor;
  @ManyToOne(fetch = FetchType.LAZY)
  private Curso curso;
  @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Resposta> respostas;
  @Enumerated(EnumType.STRING)
  private StatusTopico status;

  public Topico() {
  }

  public Topico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, Usuario autor, Curso curso,
      List<Resposta> respostas, StatusTopico status) {
    this.id = id;
    this.titulo = titulo;
    this.mensagem = mensagem;
    this.dataCriacao = dataCriacao;
    this.autor = autor;
    this.curso = curso;
    this.respostas = respostas;
    this.status = status;
  }

  public Topico(String titulo, String mensagem, Usuario autor, Curso curso) {
    this.titulo = titulo;
    this.mensagem = mensagem;
    this.dataCriacao = LocalDateTime.now();
    this.autor = autor;
    this.curso = curso;
    this.respostas = new ArrayList<>();
    this.status = StatusTopico.NAO_RESPONDIDO;
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getMensagem() {
    return mensagem;
  }

  public LocalDateTime getDataCriacao() {
    return dataCriacao;
  }

  public Usuario getAutor() {
    return autor;
  }

  public Curso getCurso() {
    return curso;
  }

  public List<Resposta> getRespostas() {
    return respostas;
  }

  public StatusTopico getStatus() {
    return status;
  }

  public void setStatus(StatusTopico status) {
    this.status = status;
  }
}
