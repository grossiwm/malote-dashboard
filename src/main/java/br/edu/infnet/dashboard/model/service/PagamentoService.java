package br.edu.infnet.dashboard.model.service;

import java.math.BigDecimal;
import java.util.List;

import br.edu.infnet.dashboard.model.domain.Pagamento;
import br.edu.infnet.dashboard.model.domain.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.ITransacaoClient;

@Service
public class PagamentoService {
	
	@Autowired
	private ITransacaoClient transacaoClient;
	
	public List<Pagamento> obterLista() {
		return transacaoClient.obterPagamentoLista();
	}

	public BigDecimal calcularValor() {
		return transacaoClient.obterTransferenciaLista().stream()
				.map(Transacao::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}