package br.com.systemsgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemsgs.dto.ModelClientesDTO;
import br.com.systemsgs.service.ClienteService;

@RestController
@RequestMapping(value = "/api/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping(value = "/salvar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public String salvaCliente(@RequestBody @Valid ModelClientesDTO modelClientesDTO){
		clienteService.salvaCliente(modelClientesDTO);
		
		return "Cliente Salvo com Sucesso!!!";
	}

}
