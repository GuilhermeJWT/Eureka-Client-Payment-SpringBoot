package br.com.systemsgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemsgs.model.ModelClientes;
import br.com.systemsgs.service.ClienteService;

@RestController
@RequestMapping(value = "/api/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping(value = "/salvar")
	public ModelClientes salvaCliente(@RequestBody @Valid ModelClientes modelClientes){
		return clienteService.salvaCliente(modelClientes);
	}

}
