package br.com.composteira.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "monitoramentos_liquido")
public class MonitoramentoLiquido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false) @JoinColumn(name = "modulo_id")
    private Modulo modulo;
    @Column(nullable = false) private Boolean presencaLiquido;
    @Column(nullable = false) private String nivel;
    @Column(nullable = false) private LocalDateTime dataRegistro;

    public MonitoramentoLiquido() {}
    public MonitoramentoLiquido(Modulo modulo, Boolean presencaLiquido, String nivel, LocalDateTime dataRegistro) { this.modulo = modulo; this.presencaLiquido = presencaLiquido; this.nivel = nivel; this.dataRegistro = dataRegistro; }
    public Long getId() { return id; }
    public Modulo getModulo() { return modulo; }
    public void setModulo(Modulo modulo) { this.modulo = modulo; }
    public Boolean getPresencaLiquido() { return presencaLiquido; }
    public void setPresencaLiquido(Boolean presencaLiquido) { this.presencaLiquido = presencaLiquido; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public LocalDateTime getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDateTime dataRegistro) { this.dataRegistro = dataRegistro; }
}
