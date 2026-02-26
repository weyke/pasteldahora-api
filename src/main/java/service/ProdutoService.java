package service;

import Enums.StatusProduto;
import lombok.RequiredArgsConstructor;
import model.Produto;
import org.springframework.stereotype.Service;
import repository.ProdutoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public Produto salvar(Produto produto) {
        produto.setStatus(StatusProduto.ATIVO);
        return repository.save(produto);
    }

    public Produto editar(Long id, Produto produtoAtualizado) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(produtoAtualizado.getNome());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setImageUrl(produtoAtualizado.getImageUrl());

        return repository.save(produto);
    }

    public Produto desativar(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setStatus(StatusProduto.INATIVO);
        return repository.save(produto);
    }

    public Produto ativar(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setStatus(StatusProduto.ATIVO);
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public List<Produto> listarAtivos() {
        return repository.findByStatus(StatusProduto.ATIVO);
    }

    public Produto alterarStatus(Long id, StatusProduto status) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setStatus(status);
        return repository.save(produto);
    }

    public void deletar(Long id) {
    }
}