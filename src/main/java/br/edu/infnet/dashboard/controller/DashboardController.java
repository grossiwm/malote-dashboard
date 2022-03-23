package br.edu.infnet.dashboard.controller;

import java.util.List;

import br.edu.infnet.dashboard.model.domain.Empresa;
import br.edu.infnet.dashboard.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Usuario;

@Controller
public class DashboardController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private MaloteService maloteService;
	
	@Autowired
	private TransferenciaService transferenciaService;

	@Autowired
	private DepositoService depositoService;

	@Autowired
	private PagamentoService pagamentoService;

	@Autowired
	private TransacaoService transacaoService;

	@Autowired
	private LogService logService;

	@GetMapping(value = "/")
	public String index(Model model) {

		//transacoes e malotes por empresa
		List<Empresa> empresas = empresaService.obterLista();
		model.addAttribute("empresas", empresas);
		
		//quantidade de malotes
		model.addAttribute("qtdeMalotes", maloteService.obterQuantidade());
		
		//valor das transacões
		model.addAttribute("valorDepositos", depositoService.calcularValor());
		model.addAttribute("valorPagamentos", pagamentoService.calcularValor());
		model.addAttribute("valorTransferencias", transferenciaService.calcularValor());

		//recuperar o log
		model.addAttribute("listaLog", logService.obterLista());
		model.addAttribute("qtdeLog", logService.obterQuantidade());
		
		return "index";
	}
}