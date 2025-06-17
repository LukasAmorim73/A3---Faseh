package com.seuusuario.agendamento.service;

import com.seuusuario.agendamento.Repository.AgendamentoRepository;
import com.seuusuario.agendamento.Repository.HistoricoRepository;
import com.seuusuario.agendamento.Repository.NotificacaoRepository;
import com.seuusuario.agendamento.Repository.TransacaoExternaRepository;
import com.seuusuario.agendamento.entity.*;

public class AgendamentoService {
    private AgendamentoRepository agendamentoRepository = new AgendamentoRepository();
    private HistoricoRepository historicoRepository = new HistoricoRepository();
    private NotificacaoRepository notificacaoRepository = new NotificacaoRepository();
    private TransacaoExternaRepository transacaoRepository = new TransacaoExternaRepository();

    public void fazerAgendamento(Agendamento agendamento, Cliente cliente, Servico servico) {
        agendamentoRepository.cadastrarAgendamento(agendamento);

        Historico historico = new Historico();
        historico.setClienteId(cliente.getId());
        historico.setDescricao("Serviço realizado: " + servico.getNome());
        historicoRepository.cadastrarHistorico(historico);

        Notificacao notificacao = new Notificacao();
        notificacao.setClienteId(cliente.getId());
        notificacao.setMensagem("Agendamento concluído com sucesso para: " + servico.getNome());
        notificacaoRepository.cadastrarNotificacao(notificacao);

        // Criar transação
        TransacaoExterna transacao = new TransacaoExterna();
        transacao.setClienteId(cliente.getId());
        transacao.setValor(servico.getPreco());
        transacao.setTipo("Pagamento de Serviço");
        transacaoRepository.cadastrarTransacao(transacao);

        System.out.println("Agendamento concluído com sucesso!");
    }
}
