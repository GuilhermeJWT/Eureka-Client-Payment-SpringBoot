package br.com.systemsgs.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ModelProdutoDTO {
	
	@NotBlank(message = "SKU deve ser Informado!!!")
	private String sku;
	
	@NotBlank(message = "Descrição deve ser Informada!!!")
	private String descricao;
	
	@NotNull(message = "Quantidade deve ser Informada!!!")
	private Integer quantidade;
	
	@NotNull(message = "O Valor deve ser Informado!!!")
	private BigDecimal valor;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
