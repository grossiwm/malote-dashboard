package br.edu.infnet.dashboard.model.service;

import java.util.List;

import br.edu.infnet.dashboard.model.domain.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.ITransacaoClient;

@Service
public class TransacaoService {
	
	@Autowired
	private ITransacaoClient transacaoClient;
	
	public List<Transacao> obterLista() {
		return transacaoClient.obterLista();
	}
}