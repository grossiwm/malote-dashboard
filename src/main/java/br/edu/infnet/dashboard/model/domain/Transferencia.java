package br.edu.infnet.dashboard.model.domain;

import com.gabrielrossilopes.appmalote.model.enums.TipoTransacao;

public class Transferencia extends Transacao {

	private String contaDestino;
	private String contaOrigem;

	public Transferencia() {
		super();
	}


	public String getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(String contaDestino)  {this.contaDestino = contaDestino;}
	public String getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	@Override
	public TipoTransacao getTipoTransacao() {
		return TipoTransacao.TRANSFERENCIA;
	}	
	
	@Override
	public String toString() {
		return new StringBuilder().append(contaDestino).append(";").append(contaOrigem).append(";R$ ").append(valor)
				.toString();
	}

}
