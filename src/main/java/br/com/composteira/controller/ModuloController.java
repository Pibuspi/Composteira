package br.com.composteira.controller;

import br.com.composteira.model.Modulo;
import br.com.composteira.repository.ModuloRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/modulos")
@CrossOrigin
public class ModuloController {
    private final ModuloRepository repository;
    public ModuloController(ModuloRepository repository) { this.repository = repository; }
    @GetMapping public List<Modulo> listar() { return repository.findAll(); }
    @PutMapping("/{id}") public ResponseEntity<Modulo> atualizarStatus(@PathVariable Long id, @RequestBody StatusRequest request) {
        return repository.findById(id).map(modulo -> { modulo.setStatus(request.status()); return ResponseEntity.ok(repository.save(modulo)); }).orElse(ResponseEntity.notFound().build());
    }
    public record StatusRequest(String status) {}
}
