package br.edu.infnet.dashboard.controller;

import br.edu.infnet.dashboard.model.domain.Transferencia;
import br.edu.infnet.dashboard.model.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping("/transferencias")
    public String obterLista(Model model) {
        model.addAttribute("listagem", transferenciaService.obterList());
        return "lista/transferencias";
    }
}
