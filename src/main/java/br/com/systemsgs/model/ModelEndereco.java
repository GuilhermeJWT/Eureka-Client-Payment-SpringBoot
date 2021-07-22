package br.com.systemsgs.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "endereco")
public class ModelEndereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "A Cidade deve ser Informado!!!")
	private String cidade;
	
	@NotBlank(message = "O Estado deve ser Informado!!!")
	private String estado;
	
	@NotBlank(message = "O Cep deve ser Informado!!!")
	private String cep;
	
	@NotBlank(message = "O Endereço deve ser Informado!!!")
	private String endereco;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
	@org.hibernate.annotations.ForeignKey(name = "cliente_id")
	private ModelClientes clientes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public ModelClientes getClientes() {
		return clientes;
	}
	
	public void setClientes(ModelClientes clientes) {
		this.clientes = clientes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelEndereco other = (ModelEndereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ModelEndereco [id=" + id + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + ", endereco="
				+ endereco + ", clientes=" + clientes + "]";
	}
	
}
