package br.com.systemsgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelProdutos;

@Repository
public interface ProdutoRepository extends JpaRepository<ModelProdutos, Long>{

}
