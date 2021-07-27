package br.com.systemsgs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemsgs.dto.ModelProdutoDTO;
import br.com.systemsgs.service.ProdutoService;

@RestController
@RequestMapping(value = "/api/v1/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping(value = "/salvar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public String salvaProduto(@RequestBody @Valid ModelProdutoDTO ModelProdutoDTO){
		
		System.out.print("oi");
		
		produtoService.salvaProduto(ModelProdutoDTO);
		
		return "Produto Salvo com Sucesso!!!";
	}
	
	@GetMapping(value = "/listaTodos")
	public List<ModelProdutoDTO> listaTodos(){
		List<ModelProdutoDTO> Produtos = produtoService.listaTodos();
		
		return Produtos;
	}
	
	@GetMapping(value = "/pesquisar/{id}")
	public ModelProdutoDTO pesquisaPorId(@PathVariable("id") Long id) {
		ModelProdutoDTO ModelProdutoDTO = produtoService.pesquisaPorId(id);
		
		return ModelProdutoDTO;
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<?> deletaProduto(@PathVariable("id") Long id){
		produtoService.deletarProduto(id);
		
		return ResponseEntity.ok("Produto Removido com Sucesso!!!");
	}

}
