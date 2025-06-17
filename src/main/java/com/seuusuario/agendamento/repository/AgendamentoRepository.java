package com.seuusuario.agendamento.Repository;

import com.seuusuario.agendamento.ConexaoComBancoDeDados;
import com.seuusuario.agendamento.entity.Agendamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AgendamentoRepository {
    public void cadastrarAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO agendamento (cliente_id, profissional_id, servico_id, data_hora) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoComBancoDeDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, agendamento.getClienteId());
            stmt.setInt(2, agendamento.getProfissionalId());
            stmt.setInt(3, agendamento.getServicoId());
            stmt.setTimestamp(4, Timestamp.valueOf(agendamento.getDataHora()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
