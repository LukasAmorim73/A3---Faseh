package com.seuusuario.agendamento.dao;

import com.seuusuario.agendamento.ConexaoComBancoDeDados;
import com.seuusuario.agendamento.entity.Historico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoricoRepository {
    public void cadastrarHistorico(Historico historico) {
        String sql = "INSERT INTO historico (cliente_id, descricao) VALUES (?, ?)";

        try (Connection conn = ConexaoComBancoDeDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, historico.getClienteId());
            stmt.setString(2, historico.getDescricao());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
