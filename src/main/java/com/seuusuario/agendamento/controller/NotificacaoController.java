package com.seuusuario.agendamento.controller;

import com.seuusuario.agendamento.entity.Notificacao;
import com.seuusuario.agendamento.service.NotificacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacaos")
public class NotificacaoController {

    private final NotificacaoService service;

    public NotificacaoController(NotificacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Notificacao> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Notificacao salvar(@RequestBody Notificacao obj) {
        return service.salvar(obj);
    }

    @GetMapping("/{
        id
    }")
    public ResponseEntity<Notificacao> buscarPorId(@PathVariable Long id) {
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
