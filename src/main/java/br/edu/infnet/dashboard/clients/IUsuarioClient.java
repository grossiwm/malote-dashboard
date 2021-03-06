package br.edu.infnet.dashboard.clients;

import br.edu.infnet.dashboard.model.domain.Malote;
import br.edu.infnet.dashboard.model.domain.Transacao;
import br.edu.infnet.dashboard.model.domain.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "${maloteapi.usuario.root}/usuario", name = "usuarioClient")
public interface IUsuarioClient {

	@GetMapping(value = "/listar")
	List<Usuario> obterLista();

	@GetMapping(value = "/malotes")
	List<Malote> obterListaMalotes();

	@GetMapping(value = "/transacoes")
	List<Transacao> obterListaTransacoes();
}