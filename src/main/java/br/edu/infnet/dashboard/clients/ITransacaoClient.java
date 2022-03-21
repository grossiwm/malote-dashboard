package br.edu.infnet.dashboard.clients;

import br.edu.infnet.dashboard.model.domain.Deposito;
import br.edu.infnet.dashboard.model.domain.Pagamento;
import br.edu.infnet.dashboard.model.domain.Transacao;
import br.edu.infnet.dashboard.model.domain.Transferencia;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "${maloteapi.transferencia.root}/transacao", name = "transacaoClient")
public interface ITransacaoClient {

	@GetMapping(value = "/listar")
	List<Transacao> obterLista();
	
	@GetMapping(value = "/listar/transferencia")
	List<Transferencia> obterTransferenciaLista();

	@GetMapping(value = "/listar/deposito")
	List<Deposito> obterDepositoLista();

	@GetMapping(value = "/listar/pagamento")
	List<Pagamento> obterPagamentoLista();
}