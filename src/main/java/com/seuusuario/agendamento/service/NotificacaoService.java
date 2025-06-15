package com.seuusuario.agendamento.service;

import com.seuusuario.agendamento.entity.Notificacao;
import com.seuusuario.agendamento.repository.NotificacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    private final NotificacaoRepository repository;

    public NotificacaoService(NotificacaoRepository repository) {
        this.repository = repository;
    }

    public List<Notificacao> listarTodos() {
        return repository.findAll();
    }

    public Notificacao salvar(Notificacao obj) {
        return repository.save(obj);
    }

    public Optional<Notificacao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
