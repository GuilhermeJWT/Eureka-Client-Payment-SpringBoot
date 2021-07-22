package br.com.systemsgs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.config.DozerConverter;
import br.com.systemsgs.dto.ModelClientesDTO;
import br.com.systemsgs.exception.RecursoNaoEncontradoException;
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

	public List<ModelClientesDTO> listaTodos() {
		return DozerConverter.converteList(clienteRepository.findAll(), ModelClientesDTO.class);
	}

	public ModelClientesDTO pesquisaPorId(Long id) {
		ModelClientes modelClientes = clienteRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException());
		
		return DozerConverter.converteEntidade(modelClientes, ModelClientesDTO.class);
	}

	@Transactional
	public void deletarCliente(Long id) {
		clienteRepository.findById(id).map(cliente -> {clienteRepository.delete(cliente); return cliente;}).orElseThrow(() -> new RecursoNaoEncontradoException());
	}

}
