package br.com.systemsgs.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.systemsgs.model.ModelEndereco;

public class ModelClientesDTO {

	private Long id;
	
	@NotBlank(message = "O Nome deve ser Informado!!!")
	private String nome;

	@NotBlank(message = "O E-Mail deve ser Informado!!!")
	@Email(message = "E-mail Inválido, Informe Outro!!!")
	private String email;
	
	List<ModelEndereco> enderecos = new ArrayList<ModelEndereco>();

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<ModelEndereco> getEnderecos() {
		return enderecos;
	}
	
	public void setEnderecos(List<ModelEndereco> enderecos) {
		this.enderecos = enderecos;
	}
}
