package br.edu.infnet.dashboard.controller;

import br.edu.infnet.dashboard.model.service.MaloteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaloteController {
	
	@Autowired
	private MaloteService maloteService;

	@GetMapping(value = "/malotes")
	public String obterLista(Model model) {
		
		model.addAttribute("listagem", maloteService.obterLista());
		return "lista/pedidos";
	}
}
