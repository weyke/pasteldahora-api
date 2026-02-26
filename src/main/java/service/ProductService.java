package service;

import lombok.RequiredArgsConstructor;
import model.Product;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product salvar(Product product) {
        product.setActive(true);
        return repository.save(product);
    }

    public Product editar(Long id, Product productAtualizado) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        product.setName(productAtualizado.getName());
        product.setCategory(productAtualizado.getCategory());
        product.setDescription(productAtualizado.getDescription());
        product.setPrice(productAtualizado.getPrice());
        product.setImageUrl(productAtualizado.getImageUrl());

        return repository.save(product);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Product> listarTodos() {
        return repository.findAll();
    }

    public List<Product> listarAtivos() {
        return repository.findByActiveTrue();
    }

    public Product alterarStatus(Long id, Boolean active) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        product.setActive(active);
        return repository.save(product);
    }
}