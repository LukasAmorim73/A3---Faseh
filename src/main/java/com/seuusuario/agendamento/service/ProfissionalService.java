package com.seuusuario.agendamento.service;

import com.seuusuario.agendamento.entity.Profissional;
import com.seuusuario.agendamento.repository.ProfissionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    private final ProfissionalRepository repository;

    public ProfissionalService(ProfissionalRepository repository) {
        this.repository = repository;
    }

    public List<Profissional> listarTodos() {
        return repository.findAll();
    }

    public Profissional salvar(Profissional obj) {
        return repository.save(obj);
    }

    public Optional<Profissional> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
