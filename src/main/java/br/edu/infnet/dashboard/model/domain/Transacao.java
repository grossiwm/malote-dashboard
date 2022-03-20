package br.edu.infnet.dashboard.model.domain;

import com.gabrielrossilopes.appmalote.model.enums.TipoTransacao;

import java.math.BigDecimal;

public abstract class Transacao {

	protected Long id;

	protected BigDecimal valor;

	protected TipoTransacao tipoTransacao;

	protected Malote malote;

	public Transacao() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public Malote getMalote() {
		return malote;
	}

	public void setMalote(Malote malote) {
		this.malote = malote;
	}
}
