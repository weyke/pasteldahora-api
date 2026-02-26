package repository;

import Enums.StatusProduto;
import model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto>  findByActiveTrue();

    List<Produto> findByStatus(StatusProduto statusProduto);
}
