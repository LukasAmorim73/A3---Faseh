package com.seuusuario.agendamento.controller;

import com.seuusuario.agendamento.entity.TransacaoExterna;
import com.seuusuario.agendamento.service.TransacaoExternaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacaoexternas")
public class TransacaoExternaController {

    private final TransacaoExternaService service;

    public TransacaoExternaController(TransacaoExternaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TransacaoExterna> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public TransacaoExterna salvar(@RequestBody TransacaoExterna obj) {
        return service.salvar(obj);
    }

    @GetMapping("/{
        id
    }")
    public ResponseEntity<TransacaoExterna> buscarPorId(@PathVariable Long id) {
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
