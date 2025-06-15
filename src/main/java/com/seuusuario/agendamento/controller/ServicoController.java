package com.seuusuario.agendamento.controller;

import com.seuusuario.agendamento.entity.Servico;
import com.seuusuario.agendamento.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoService service;

    public ServicoController(ServicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Servico> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Servico salvar(@RequestBody Servico obj) {
        return service.salvar(obj);
    }

    @GetMapping("/{
        id
    }")
    public ResponseEntity<Servico> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{
        id
    }")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
