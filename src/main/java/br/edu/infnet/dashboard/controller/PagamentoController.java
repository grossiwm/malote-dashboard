package br.edu.infnet.dashboard.controller;

import br.edu.infnet.dashboard.model.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping(value = "/pagamentos")
    public String obterLista(Model model) {
        model.addAttribute("listagem", pagamentoService.obterLista());
        return "lista/pagamentos";
    }
}
