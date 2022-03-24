package br.edu.infnet.dashboard.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.infnet.dashboard.model.domain.Malote;
import br.edu.infnet.dashboard.model.domain.Transacao;
import br.edu.infnet.dashboard.model.service.RelatorioService;
import br.edu.infnet.dashboard.model.service.TransacaoService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Log;
import br.edu.infnet.dashboard.model.service.LogService;
import br.edu.infnet.dashboard.model.service.MaloteService;

@Controller
public class RelatorioController {
	
	@Autowired
	private MaloteService maloteService;

	@Autowired
	private RelatorioService relatorioService;

	@GetMapping(value = "/generate")
	public String emissaoRelatorio(Model model) {

		relatorioService.gerar();
		return "redirect:/";
	}
}
