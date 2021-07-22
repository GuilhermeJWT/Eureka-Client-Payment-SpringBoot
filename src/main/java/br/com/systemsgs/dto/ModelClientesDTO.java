package br.com.systemsgs.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ModelClientesDTO {

	@NotBlank(message = "O Nome deve ser Informado!!!")
	private String nome;

	@NotBlank(message = "O E-Mail deve ser Informado!!!")
	@Email(message = "E-mail Inválido, Informe Outro!!!")
	private String email;

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
}
