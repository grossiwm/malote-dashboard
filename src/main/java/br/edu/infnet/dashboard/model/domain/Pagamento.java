package br.edu.infnet.dashboard.model.domain;

import com.gabrielrossilopes.appmalote.model.enums.TipoTransacao;

public class Pagamento extends Transacao {

	private String cnpjRecebedor;
	
	public String getCnpjRecebedor() {
		return cnpjRecebedor;
	}
	public void setCnpjRecebedor(String cnpjRecebedor) {
		this.cnpjRecebedor = cnpjRecebedor;
	}
	@Override
	public TipoTransacao getTipoTransacao() {
		return TipoTransacao.PAGAMENTO;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(cnpjRecebedor).append(";R$ ").append(valor)
				.toString();
	}

}
