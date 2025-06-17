package com.seuusuario.agendamento.dao;

import com.seuusuario.agendamento.ConexaoComBancoDeDados;
import com.seuusuario.agendamento.entity.Notificacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NotificacaoRepository {
    public void cadastrarNotificacao(Notificacao notificacao) {
        String sql = "INSERT INTO notificacao (cliente_id, mensagem) VALUES (?, ?)";

        try (Connection conn = ConexaoComBancoDeDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, notificacao.getClienteId());
            stmt.setString(2, notificacao.getMensagem());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
