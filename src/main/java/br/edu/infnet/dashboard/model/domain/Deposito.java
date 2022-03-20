package br.edu.infnet.dashboard.model.domain;

import com.gabrielrossilopes.appmalote.model.enums.TipoTransacao;

public class Deposito extends Transacao {

	private String cpfBeneficiario;

	private String nomeBeneficiario;

	public Deposito() {
		super();

	}
	
	public String getCpfBeneficiario() {
		return cpfBeneficiario;
	}
	public void setCpfBeneficiario(String cpfBeneficiario) {

		this.cpfBeneficiario = cpfBeneficiario;
	}
	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}
	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}
	@Override
	public TipoTransacao getTipoTransacao() {
		return TipoTransacao.DEPOSITO;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(cpfBeneficiario).append(";").append(nomeBeneficiario).append(";R$ ").append(valor)
				.toString();
	}

}
