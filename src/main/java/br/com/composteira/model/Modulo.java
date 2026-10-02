package br.com.composteira.model;

import jakarta.persistence.*;

@Entity
@Table(name = "modulos")
public class Modulo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Integer numeroModulo;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String status;

    public Modulo() {}
    public Modulo(Integer numeroModulo, String nome, String status) { this.numeroModulo = numeroModulo; this.nome = nome; this.status = status; }
    public Long getId() { return id; }
    public Integer getNumeroModulo() { return numeroModulo; }
    public void setNumeroModulo(Integer numeroModulo) { this.numeroModulo = numeroModulo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
