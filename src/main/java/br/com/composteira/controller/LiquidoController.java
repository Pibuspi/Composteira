package br.com.composteira.controller;

import br.com.composteira.model.*;
import br.com.composteira.repository.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/liquidos")
@CrossOrigin
public class LiquidoController {
    private final MonitoramentoLiquidoRepository monitoramentos;
    private final ModuloRepository modulos;
    public LiquidoController(MonitoramentoLiquidoRepository monitoramentos, ModuloRepository modulos) { this.monitoramentos = monitoramentos; this.modulos = modulos; }
    @GetMapping public List<MonitoramentoLiquido> listar() { return monitoramentos.findAllByOrderByDataRegistroDesc(); }
    @PostMapping public ResponseEntity<MonitoramentoLiquido> criar(@RequestBody LiquidoRequest request) {
        Modulo modulo = modulos.findById(request.moduloId()).orElseThrow();
        LocalDateTime data = request.dataRegistro() == null ? LocalDateTime.now() : request.dataRegistro();
        return ResponseEntity.status(HttpStatus.CREATED).body(monitoramentos.save(new MonitoramentoLiquido(modulo, request.presencaLiquido(), request.nivel(), data)));
    }
    @PutMapping("/{id}") public ResponseEntity<MonitoramentoLiquido> atualizar(@PathVariable Long id, @RequestBody LiquidoRequest request) {
        return monitoramentos.findById(id).map(item -> { item.setPresencaLiquido(request.presencaLiquido()); item.setNivel(request.nivel()); if (request.moduloId() != null) item.setModulo(modulos.findById(request.moduloId()).orElse(item.getModulo())); return ResponseEntity.ok(monitoramentos.save(item)); }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id) { if (!monitoramentos.existsById(id)) return ResponseEntity.notFound().build(); monitoramentos.deleteById(id); return ResponseEntity.noContent().build(); }
    public record LiquidoRequest(Long moduloId, Boolean presencaLiquido, String nivel, LocalDateTime dataRegistro) {}
}
