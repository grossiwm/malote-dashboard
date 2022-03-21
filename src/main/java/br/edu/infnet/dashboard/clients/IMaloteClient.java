package br.edu.infnet.dashboard.clients;

import br.edu.infnet.dashboard.model.domain.Malote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "${maloteapi.malote.root}/malote", name = "maloteClient")
public interface IMaloteClient {

    @GetMapping(value = "/listar")
    List<Malote> obterLista();

    @GetMapping(value = "/qtde")
    long obterQuantidade();
}
