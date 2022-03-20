package br.edu.infnet.dashboard.model.service;

import br.edu.infnet.dashboard.clients.ITransacaoClient;
import br.edu.infnet.dashboard.model.domain.Transacao;
import br.edu.infnet.dashboard.model.domain.Transferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private ITransacaoClient transacaoClient;

    public List<Transferencia> obterList() {
        return transacaoClient.obterTransferenciaLista();
    }

    public BigDecimal calcularValor() {
        return transacaoClient.obterTransferenciaLista().stream()
                .map(Transacao::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
