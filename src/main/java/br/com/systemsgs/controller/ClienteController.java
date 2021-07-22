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

import br.com.systemsgs.config.DozerConverter;
import br.com.systemsgs.dto.ModelClientesDTO;
import br.com.systemsgs.model.ModelClientes;
import br.com.systemsgs.service.ClienteService;

@RestController
@RequestMapping(value = "/api/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping(value = "/salvar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public String salvaCliente(@RequestBody @Valid ModelClientesDTO modelClientesDTO){
		
		System.out.print("oi");
		
		for(int pos = 0; pos < modelClientesDTO.getEnderecos().size(); pos++) {
			ModelClientes converteCliente = DozerConverter.converteEntidade(modelClientesDTO, ModelClientes.class);
			modelClientesDTO.getEnderecos().get(pos).setClientes(converteCliente);
			System.out.print(modelClientesDTO.getEnderecos().toString());
			System.out.println(modelClientesDTO.getEnderecos());
		}
		
		
		clienteService.salvaCliente(modelClientesDTO);
		
		return "Cliente Salvo com Sucesso!!!";
	}
	
	@GetMapping(value = "/listaTodos")
	public List<ModelClientesDTO> listaTodos(){
		List<ModelClientesDTO> clientes = clienteService.listaTodos();
		
		return clientes;
	}
	
	@GetMapping(value = "/pesquisar/{id}")
	public ModelClientesDTO pesquisaPorId(@PathVariable("id") Long id) {
		ModelClientesDTO modelClientesDTO = clienteService.pesquisaPorId(id);
		
		return modelClientesDTO;
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<?> deletaCliente(@PathVariable("id") Long id){
		clienteService.deletarCliente(id);
		
		return ResponseEntity.ok("Cliente Removido com Sucesso!!!");
	}

}
