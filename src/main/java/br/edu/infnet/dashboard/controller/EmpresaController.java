package br.edu.infnet.dashboard.controller;

import br.edu.infnet.dashboard.model.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/empresas")
    public String obterLista(Model model) {
        model.addAttribute("listagem", empresaService.obterLista());
        return "lista/empresas";
    }
}
