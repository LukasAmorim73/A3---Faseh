package com.seuusuario.agendamento.service;

import com.seuusuario.agendamento.entity.Servico;
import com.seuusuario.agendamento.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository) {
        this.repository = repository;
    }

    public List<Servico> listarTodos() {
        return repository.findAll();
    }

    public Servico salvar(Servico obj) {
        return repository.save(obj);
    }

    public Optional<Servico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
