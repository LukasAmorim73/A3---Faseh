package com.seuusuario.agendamento.service;

import com.seuusuario.agendamento.entity.Historico;
import com.seuusuario.agendamento.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoService {

    private final HistoricoRepository repository;

    public HistoricoService(HistoricoRepository repository) {
        this.repository = repository;
    }

    public List<Historico> listarTodos() {
        return repository.findAll();
    }

    public Historico salvar(Historico obj) {
        return repository.save(obj);
    }

    public Optional<Historico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
