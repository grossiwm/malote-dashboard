package br.edu.infnet.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.service.TransacaoService;

@Controller
public class TransacaoController {
	
	@Autowired
	private TransacaoService transacaoService;

	@GetMapping(value = "/transacoes")
	public String obterLista(Model model) {
		
		model.addAttribute("listagem", transacaoService.obterLista());

		return "lista/transacoes";
	}
}
