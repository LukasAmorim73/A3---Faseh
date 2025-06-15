package com.seuusuario.agendamento.controller;

import com.seuusuario.agendamento.entity.Profissional;
import com.seuusuario.agendamento.service.ProfissionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionals")
public class ProfissionalController {

    private final ProfissionalService service;

    public ProfissionalController(ProfissionalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Profissional> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Profissional salvar(@RequestBody Profissional obj) {
        return service.salvar(obj);
    }

    @GetMapping("/{
        id
    }")
    public ResponseEntity<Profissional> buscarPorId(@PathVariable Long id) {
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
