package br.com.composteira.controller;

import br.com.composteira.model.*;
import br.com.composteira.repository.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/residuos")
@CrossOrigin
public class ResiduoController {
    private final ResiduoRepository residuos;
    private final ModuloRepository modulos;
    public ResiduoController(ResiduoRepository residuos, ModuloRepository modulos) { this.residuos = residuos; this.modulos = modulos; }
    @GetMapping public List<Residuo> listar() { return residuos.findByModuloNumeroModuloOrderByDataAdicaoDesc(1); }
    @PostMapping public ResponseEntity<Residuo> criar(@RequestBody ResiduoRequest request) {
        Modulo modulo = modulos.findAll().stream().filter(m -> m.getNumeroModulo() == 1).findFirst().orElseThrow();
        LocalDateTime data = request.dataAdicao() == null ? LocalDateTime.now() : request.dataAdicao();
        return ResponseEntity.status(HttpStatus.CREATED).body(residuos.save(new Residuo(modulo, request.categoria(), request.item(), data)));
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id) { if (!residuos.existsById(id)) return ResponseEntity.notFound().build(); residuos.deleteById(id); return ResponseEntity.noContent().build(); }
    public record ResiduoRequest(String categoria, String item, LocalDateTime dataAdicao) {}
}
