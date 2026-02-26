package controller;

import Enums.StatusProduto;
import lombok.RequiredArgsConstructor;
import model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        return ResponseEntity.ok(service.salvar(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> editar(@PathVariable Long id,
                                          @RequestBody Produto produto) {
        return ResponseEntity.ok(service.editar(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.desativar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Produto>> listarAtivos() {
        return ResponseEntity.ok(service.listarAtivos());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Produto> alterarStatus(@PathVariable Long id,
                                                 @RequestParam StatusProduto status) {
        return ResponseEntity.ok(service.alterarStatus(id, status));
    }

    @PatchMapping("/{id}/ativar")
    public ResponseEntity<Produto> ativar(@PathVariable Long id) {
        return ResponseEntity.ok(service.ativar(id));
    }

    @PatchMapping("/{id}/desativar")
    public ResponseEntity<Produto> desativar(@PathVariable Long id) {
        return ResponseEntity.ok(service.desativar(id));
    }
}