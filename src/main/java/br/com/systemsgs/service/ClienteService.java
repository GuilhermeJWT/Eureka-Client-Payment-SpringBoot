package br.com.systemsgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.model.ModelClientes;
import br.com.systemsgs.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ModelClientes salvaCliente(ModelClientes modelClientes){
		ModelClientes clienteSalvo = clienteRepository.save(modelClientes);
		
		return clienteSalvo;
	}

}
