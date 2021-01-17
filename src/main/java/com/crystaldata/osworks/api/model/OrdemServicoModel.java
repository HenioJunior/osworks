package com.crystaldata.osworks.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.crystaldata.osworks.domain.model.StatusOrdemServico;

public class OrdemServicoModel {
	
private Long Id;
private ClienteResumoModel cliente;
private String descricao;
private BigDecimal preco;
private StatusOrdemServico status;
private OffsetDateTime dataAbertura;
private OffsetDateTime dataFinalizacao;

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public ClienteResumoModel getCliente() {
	return cliente;
}

public void setCliente(ClienteResumoModel cliente) {
	this.cliente = cliente;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public BigDecimal getPreco() {
	return preco;
}

public void setPreco(BigDecimal preco) {
	this.preco = preco;
}

public StatusOrdemServico getStatus() {
	return status;
}

public void setStatus(StatusOrdemServico status) {
	this.status = status;
}

public OffsetDateTime getDataAbertura() {
	return dataAbertura;
}

public void setDataAbertura(OffsetDateTime dataAbertura) {
	this.dataAbertura = dataAbertura;
}

public OffsetDateTime getDataFinalizacao() {
	return dataFinalizacao;
}

public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
	this.dataFinalizacao = dataFinalizacao;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Id == null) ? 0 : Id.hashCode());
	return result;
}
}
