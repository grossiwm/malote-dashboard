package br.edu.infnet.dashboard.clients;

import java.util.List;

import br.edu.infnet.dashboard.model.domain.Deposito;
import br.edu.infnet.dashboard.model.domain.Pagamento;
import br.edu.infnet.dashboard.model.domain.Transacao;
import br.edu.infnet.dashboard.model.domain.Transferencia;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "localhost:8083/api/transacao", name = "transacaoClient")
public interface ITransacaoClient {

	@GetMapping(value = "/listar")
	List<Transacao> obterLista();
	
	@GetMapping(value = "/transferencia/listar")
	List<Transferencia> obterTransferenciaLista();

	@GetMapping(value = "/deposito/listar")
	List<Deposito> obterDepositoLista();

	@GetMapping(value = "/pagamento/listar")
	List<Pagamento> obterPagamentoLista();
}