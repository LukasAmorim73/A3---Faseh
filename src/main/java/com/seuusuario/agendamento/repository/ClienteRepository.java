package com.seuusuario.agendamento.dao;

import com.seuusuario.agendamento.ConexaoComBancoDeDados;
import com.seuusuario.agendamento.entity.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteRepository {
    public void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, telefone, email) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoComBancoDeDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
