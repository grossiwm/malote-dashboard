package br.edu.infnet.dashboard.model.service;

import java.math.BigDecimal;
import java.util.List;

import br.edu.infnet.dashboard.model.domain.Deposito;
import br.edu.infnet.dashboard.model.domain.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.ITransacaoClient;

@Service
public class DepositoService {
	
	@Autowired
	private ITransacaoClient transacaoClient;
	
	public List<Deposito> obterLista() {
		return transacaoClient.obterDepositoLista();
	}

	public BigDecimal calcularValor() {
		return transacaoClient.obterDepositoLista().stream()
				.map(Transacao::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}