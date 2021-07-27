package br.com.systemsgs.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.config.DozerConverter;
import br.com.systemsgs.dto.ModelProdutoDTO;
import br.com.systemsgs.exception.RecursoNaoEncontradoException;
import br.com.systemsgs.model.ModelProdutos;
import br.com.systemsgs.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public ModelProdutoDTO salvaProduto(@Valid ModelProdutoDTO modelProdutoDTO) {
		ModelProdutos modelProdutos  = DozerConverter.converteEntidade(modelProdutoDTO, ModelProdutos.class);
		ModelProdutoDTO produtoConvertido = DozerConverter.converteEntidade(produtoRepository.save(modelProdutos), ModelProdutoDTO.class);
		
		return produtoConvertido;
	}
	
	public List<ModelProdutoDTO> listaTodos() {
		return DozerConverter.converteList(produtoRepository.findAll(), ModelProdutoDTO.class);
	}
	
	public ModelProdutoDTO pesquisaPorId(Long id) {
		ModelProdutos modelProdutos = produtoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException());
		
		return DozerConverter.converteEntidade(modelProdutos, ModelProdutoDTO.class);
	}

	@Transactional
	public void deletarProduto(Long id) {
		produtoRepository.findById(id).map(produto -> {produtoRepository.delete(produto); return produto;}).orElseThrow(() -> new RecursoNaoEncontradoException());
	}

}
