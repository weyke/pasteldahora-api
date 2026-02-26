package controller;

import lombok.RequiredArgsConstructor;
import model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<Product> salvar(@RequestBody Product product) {
        return ResponseEntity.ok(service.salvar(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editar(@PathVariable Long id,
                                          @RequestBody Product product) {
        return ResponseEntity.ok(service.editar(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Product>> listarAtivos() {
        return ResponseEntity.ok(service.listarAtivos());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Product> alterarStatus(@PathVariable Long id,
                                                 @RequestParam Boolean active) {
        return ResponseEntity.ok(service.alterarStatus(id, active));
    }
}