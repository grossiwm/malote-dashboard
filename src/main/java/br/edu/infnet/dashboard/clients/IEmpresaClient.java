package br.edu.infnet.dashboard.clients;

import br.edu.infnet.dashboard.model.domain.Empresa;
import br.edu.infnet.dashboard.model.domain.Malote;
import br.edu.infnet.dashboard.model.domain.Transacao;
import br.edu.infnet.dashboard.model.domain.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "${maloteapi.empresa.root}/empresa", name = "empresaClient")
public interface IEmpresaClient {

	@GetMapping(value = "/listar")
	List<Empresa> obterLista();
}