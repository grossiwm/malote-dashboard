package br.edu.infnet.dashboard.model.service;

import br.edu.infnet.dashboard.model.domain.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private TransferenciaService transferenciaService;

    @Autowired
    private MaloteService maloteService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private DepositoService depositoService;

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private LogService logService;

    public void gerar() {


        Workbook workbook = new XSSFWorkbook();

        gerarAbaTransacoes(workbook);
        gerarAbaMalotes(workbook);
        gerarAbaEmpresas(workbook);
        gerarAbaTransferencias(workbook);
        gerarAbaDepositos(workbook);
        gerarAbaPagamentos(workbook);

        LocalDateTime hoje = LocalDateTime.now();

        String arquivo = "relatorio"+hoje.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+".xlsx";

        String mensagem = null;
        try {
            workbook.write(new FileOutputStream(arquivo));

            workbook.close();

            mensagem = "A planilha gerada está disponível no diretório padrão!!!";

        } catch (IOException e) {
            mensagem = "Problemas na geração da planilha!!!";

            e.printStackTrace();
        }

        incluirLog(hoje, mensagem);
    }

    private void incluirLog(LocalDateTime data, String mensagem) {
        Log log = new Log();
        log.setData(data);
        log.setNome(mensagem);
        logService.incluir(log);
    }

    private void gerarAbaEmpresas(Workbook workbook) {

        Sheet abaEmpresas = workbook.createSheet("Empresas");

        String[] transacaoColumns = {"CNPJ", "Nome", "Malotes", "Transações"};

        Row headerRow = abaEmpresas.createRow(0);

        for(int i = 0; i < transacaoColumns.length; i++) {
            headerRow.createCell(i).setCellValue(transacaoColumns[i]);
        }

        List<Empresa> empresas = empresaService.obterLista();

        int rowNum = 0;


        for(Empresa empresa : empresas) {
            Row row = abaEmpresas.createRow(++rowNum);
            row.createCell(0).setCellValue(empresa.getCnpj());
            row.createCell(1).setCellValue(empresa.getNome());
            row.createCell(2).setCellValue(empresa.getMalotes().size());
            row.createCell(3).setCellValue(empresa.getTransacoes().size());
        }
    }

    private void gerarAbaTransacoes(Workbook workbook) {
        Sheet abaTransacoes = workbook.createSheet("Transacoes");

        String[] transacaoColumns = {"Data", "Tipo", "Malote", "Valor"};

        Row headerRow = abaTransacoes.createRow(0);

        for(int i = 0; i < transacaoColumns.length; i++) {
            headerRow.createCell(i).setCellValue(transacaoColumns[i]);
        }

        List<Transacao> transacaos = transacaoService.obterLista();

        int rowNum = 0;


        for(Transacao transacao : transacaos) {
            Row row = abaTransacoes.createRow(++rowNum);

            row.createCell(0).setCellValue(
                    transacao.getMalote().getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
            );
            row.createCell(1).setCellValue(transacao.getTipoTransacao().name());
            row.createCell(2).setCellValue(transacao.getMalote().getId());
            row.createCell(3).setCellValue(transacao.getValor().floatValue());
        }
    }

    private void gerarAbaMalotes(Workbook workbook) {
        Sheet abaMalotes = workbook.createSheet("Malotes");

        String[] maloteColumns = {"Data", "Empresa", "Usuário", "Transações"};

        Row headerRow = abaMalotes.createRow(0);

        for(int i = 0; i < maloteColumns.length; i++) {
            headerRow.createCell(i).setCellValue(maloteColumns[i]);
        }

        List<Malote> malotes = maloteService.obterLista();

        int rowNum = 0;


        for(Malote malote : malotes) {
            Row row = abaMalotes.createRow(++rowNum);

            row.createCell(0).setCellValue(
                    malote.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
            );
            row.createCell(1).setCellValue(malote.getEmpresa().getNome());
            row.createCell(2).setCellValue(malote.getUsuario().getNome());
            row.createCell(3).setCellValue(malote.getQuantidadeTransacoes());
        }
    }

    private void gerarAbaTransferencias(Workbook workbook) {
        Sheet abaTransacoes = workbook.createSheet("Transferências");

        String[] transacaoColumns = {"Data", "Valor", "Conta Origem", "Conta Destino", "Malote"};

        Row headerRow = abaTransacoes.createRow(0);

        for(int i = 0; i < transacaoColumns.length; i++) {
            headerRow.createCell(i).setCellValue(transacaoColumns[i]);
        }

        List<Transferencia> transacaos = transferenciaService.obterList();

        int rowNum = 0;

        for(Transferencia transacao : transacaos) {
            Row row = abaTransacoes.createRow(++rowNum);
            row.createCell(0).setCellValue(
                    transacao.getMalote().getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
            );
            row.createCell(1).setCellValue(transacao.getValor().floatValue());
            row.createCell(2).setCellValue(transacao.getContaOrigem());
            row.createCell(3).setCellValue(transacao.getContaDestino());
            row.createCell(4).setCellValue(transacao.getMalote().getId());
        }
    }

    private void gerarAbaDepositos(Workbook workbook) {
        Sheet abaTransacoes = workbook.createSheet("Depósitos");

        String[] transacaoColumns = {"Data", "Valor", "CPF Beneficiário", "Nome Beneficiário", "Malote"};

        Row headerRow = abaTransacoes.createRow(0);

        for(int i = 0; i < transacaoColumns.length; i++) {
            headerRow.createCell(i).setCellValue(transacaoColumns[i]);
        }

        List<Deposito> transacaos = depositoService.obterLista();

        int rowNum = 0;

        for(Deposito transacao : transacaos) {
            Row row = abaTransacoes.createRow(++rowNum);
            row.createCell(0).setCellValue(
                    transacao.getMalote().getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
            );
            row.createCell(1).setCellValue(transacao.getValor().floatValue());
            row.createCell(2).setCellValue(transacao.getCpfBeneficiario());
            row.createCell(3).setCellValue(transacao.getNomeBeneficiario());
            row.createCell(4).setCellValue(transacao.getMalote().getId());
        }
    }

    private void gerarAbaPagamentos(Workbook workbook) {
        Sheet abaTransacoes = workbook.createSheet("Pagamento");

        String[] transacaoColumns = {"Data", "Valor", "CNPJ Recebedor", "Malote"};

        Row headerRow = abaTransacoes.createRow(0);

        for(int i = 0; i < transacaoColumns.length; i++) {
            headerRow.createCell(i).setCellValue(transacaoColumns[i]);
        }

        List<Pagamento> transacaos = pagamentoService.obterLista();

        int rowNum = 0;

        for(Pagamento transacao : transacaos) {
            Row row = abaTransacoes.createRow(++rowNum);
            row.createCell(0).setCellValue(
                    transacao.getMalote().getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
            );
            row.createCell(1).setCellValue(transacao.getValor().floatValue());
            row.createCell(2).setCellValue(transacao.getCnpjRecebedor());
            row.createCell(4).setCellValue(transacao.getMalote().getId());
        }
    }
}
