package br.edu.infnet.dashboard.model.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Malote {
	
	public Malote(Empresa empresa, LocalDateTime data) {
		this.empresa = empresa;
		this.transacoes = new ArrayList<Transacao>();
		this.data = LocalDateTime.now();
	}
	
	public Malote() {
		this.transacoes = new ArrayList<Transacao>();
		this.data = LocalDateTime.now();
	}


	private Long id;

	private Empresa empresa;

	private Usuario usuario;

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	private List<Deposito> depositos;


	private List<Pagamento> pagamentos;

	private List<Transferencia> transferencias;

	private List<Transacao> transacoes;

	private BigDecimal valorTotal;

	private int quantidadeTransacoes;

	public int getQuantidadeTransacoes() {
		return quantidadeTransacoes;
	}

	public BigDecimal getValorTotal() {
		return somaTransacoes();
	}

	private BigDecimal somaTransacoes() {
		List<Transacao> transacoes = new ArrayList<>();
		if (depositos != null)
			transacoes.addAll(depositos);
		if (transferencias != null)
			transacoes.addAll(transferencias);
		if (pagamentos != null)
			transacoes.addAll(pagamentos);

		return transacoes.stream().map(Transacao::getValor)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	private LocalDateTime data;

	@Override
	public String toString() {

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return String.format("%s; %s; %s", id, empresa, formato.format(data));
	}


	public List<Deposito> getDepositos() {
		return depositos;
	}

	public void setDepositos(List<Deposito> depositos) {
		this.depositos = depositos;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public List<Transferencia> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(List<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Transacao> getTransacoes() {
		return new ArrayList<>(transacoes);
	}
	public void addTransacoes(List<Transacao> transacoes) {
		this.transacoes.addAll(transacoes);
	}

}
