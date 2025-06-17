package com.seuusuario.agendamento.dao;

import com.seuusuario.agendamento.ConexaoComBancoDeDados;
import com.seuusuario.agendamento.entity.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicoRepository {
    public void cadastrarServico(Servico servico) {
        String sql = "INSERT INTO servico (nome, preco) VALUES (?, ?)";

        try (Connection conn = ConexaoComBancoDeDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, servico.getNome());
            stmt.setDouble(2, servico.getPreco());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
