package com.seuusuario.agendamento.dao;

import com.seuusuario.agendamento.ConexaoComBancoDeDados;
import com.seuusuario.agendamento.entity.Profissional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfissionalDAO {
    public void cadastrarProfissional(Profissional profissional) {
        String sql = "INSERT INTO profissional (nome, especialidade) VALUES (?, ?)";

        try (Connection conn = ConexaoComBancoDeDados.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, profissional.getNome());
            stmt.setString(2, profissional.getEspecialidade());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
