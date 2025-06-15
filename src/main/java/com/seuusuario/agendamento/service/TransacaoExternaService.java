package com.seuusuario.agendamento.service;

import com.seuusuario.agendamento.entity.TransacaoExterna;
import com.seuusuario.agendamento.repository.TransacaoExternaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoExternaService {

    private final TransacaoExternaRepository repository;

    public TransacaoExternaService(TransacaoExternaRepository repository) {
        this.repository = repository;
    }

    public List<TransacaoExterna> listarTodos() {
        return repository.findAll();
    }

    public TransacaoExterna salvar(TransacaoExterna obj) {
        return repository.save(obj);
    }

    public Optional<TransacaoExterna> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
