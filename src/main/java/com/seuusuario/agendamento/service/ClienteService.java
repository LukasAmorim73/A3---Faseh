package com.seuusuario.agendamento.service;

import com.seuusuario.agendamento.Repository.ClienteRepository;
import com.seuusuario.agendamento.entity.Cliente;

import java.util.List;

public class ClienteService {
    private ClienteRepository clienteRepository = new ClienteRepository();

    public void adicionarCliente(Cliente cliente, List<Cliente> clientesExistentes) {
        for (Cliente c : clientesExistentes) {
            if (c.getNome().equalsIgnoreCase(cliente.getNome())
                    && c.getTelefone().equals(cliente.getTelefone())
                    && c.getEmail().equalsIgnoreCase(cliente.getEmail())) {
                System.out.println("Cliente já cadastrado.");
                return;
            }
        }
        clienteRepository.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }
}
