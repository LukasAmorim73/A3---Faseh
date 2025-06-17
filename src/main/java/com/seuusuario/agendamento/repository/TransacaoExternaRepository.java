package com.seuusuario.agendamento.dao;

import com.seuusuario.agendamento.ConexaoComBancoDeDados;
import com.seuusuario.agendamento.entity.TransacaoExterna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransacaoExternaRepository {
    public void cadastrarTransacao(TransacaoExterna transacao) {
        String sql = "INSERT INTO transacao_externa (cliente_id, valor, tipo) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoComBancoDeDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, transacao.getClienteId());
            stmt.setDouble(2, transacao.getValor());
            stmt.setString(3, transacao.getTipo());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
