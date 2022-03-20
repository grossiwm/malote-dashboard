package br.edu.infnet.dashboard.model.service;

import java.util.List;

import br.edu.infnet.dashboard.clients.IMaloteClient;
import br.edu.infnet.dashboard.model.domain.Malote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaloteService {
	
	@Autowired
	private IMaloteClient maloteClient;
	
	public List<Malote> obterLista() {
		return maloteClient.obterLista();
	}
	
	public long obterQuantidade() {
		return maloteClient.obterQuantidade();
	}		
}
