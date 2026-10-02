package br.com.composteira.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "residuos")
public class Residuo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false) @JoinColumn(name = "modulo_id")
    private Modulo modulo;
    @Column(nullable = false) private String categoria;
    @Column(nullable = false) private String item;
    @Column(nullable = false) private LocalDateTime dataAdicao;

    public Residuo() {}
    public Residuo(Modulo modulo, String categoria, String item, LocalDateTime dataAdicao) { this.modulo = modulo; this.categoria = categoria; this.item = item; this.dataAdicao = dataAdicao; }
    public Long getId() { return id; }
    public Modulo getModulo() { return modulo; }
    public void setModulo(Modulo modulo) { this.modulo = modulo; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }
    public LocalDateTime getDataAdicao() { return dataAdicao; }
    public void setDataAdicao(LocalDateTime dataAdicao) { this.dataAdicao = dataAdicao; }
}
