package com.seuusuario.agendamento.service;

import com.seuusuario.agendamento.Repository.ServicoRepository;
import com.seuusuario.agendamento.entity.Servico;

public class ServicoService {
    private ServicoRepository servicoRepository = new ServicoRepository();

    public void adicionarServico(Servico servico) {
        servicoRepository.cadastrarServico(servico);
        System.out.println("Serviço cadastrado com sucesso!");
    }
}
