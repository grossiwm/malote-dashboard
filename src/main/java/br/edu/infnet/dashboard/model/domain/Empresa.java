package br.edu.infnet.dashboard.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private Long id;
    
	private String cnpj;
	
	private String nome;
	
	private List<Malote> malotes;
	
	private List<Usuario> usuarios;

	private List<Transacao> transacoes;

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public int getQuantidadeMalotes() {
		return quantidadeMalotes;
	}

	public void setQuantidadeMalotes(int quantidadeMalotes) {
		this.quantidadeMalotes = quantidadeMalotes;
	}

	private int quantidadeMalotes;

	public Empresa() {
		malotes = new ArrayList<>();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Malote> getMalotes() {
		return new ArrayList<>(malotes);
	}

	public void addMalote(Malote malote) {
		malotes.add(malote);
	}
	
	public void addMalotes(List<Malote> malotes) {
		this.malotes.addAll(malotes);
	}

	public void setMalotes(List<Malote> malotes) {
		this.malotes = malotes;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(id).append(";").append(nome).append(";").append(cnpj).toString();
		
	}

}
