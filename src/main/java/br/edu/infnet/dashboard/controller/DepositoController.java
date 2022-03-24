package br.edu.infnet.dashboard.controller;

import br.edu.infnet.dashboard.model.service.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepositoController {

    @Autowired
    private DepositoService depositoService;

    @GetMapping("/depositos")
    public String obterLista(Model model) {
        model.addAttribute("listagem", depositoService.obterLista());
        return "lista/depositos";
    }
}
