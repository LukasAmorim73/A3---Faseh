package com.seuusuario.agendamento.controller;

import com.seuusuario.agendamento.entity.Cliente;
import com.seuusuario.agendamento.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Cliente salvar(@RequestBody Cliente obj) {
        return service.salvar(obj);
    }

    @GetMapping("/{
        id
    }")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
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
