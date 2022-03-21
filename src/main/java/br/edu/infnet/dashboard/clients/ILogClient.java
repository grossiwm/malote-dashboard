package br.edu.infnet.dashboard.clients;

import br.edu.infnet.dashboard.model.domain.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "${maloteapi.log.root}/log", name = "logClient")
public interface ILogClient {

	@GetMapping(value = "/listar")
	public List<Log> obterLista();

	@GetMapping(value = "/qtde")
	public Long obterQuantidade();

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Log log);

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
}