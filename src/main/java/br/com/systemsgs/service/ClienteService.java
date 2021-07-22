package br.com.systemsgs.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.config.DozerConverter;
import br.com.systemsgs.dto.ModelClientesDTO;
import br.com.systemsgs.model.ModelClientes;
import br.com.systemsgs.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public ModelClientesDTO salvaCliente(ModelClientesDTO modelClientesDTO){
		ModelClientes modelClientes = DozerConverter.converteEntidade(modelClientesDTO, ModelClientes.class);
		ModelClientesDTO clienteConvertido = DozerConverter.converteEntidade(clienteRepository.save(modelClientes), ModelClientesDTO.class);
		
		return clienteConvertido;
	}

}
