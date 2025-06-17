package com.seuusuario.agendamento.entity;

import java.time.LocalDateTime;

public class Agendamento {
    private int id;
    private int clienteId;
    private int profissionalId;
    private int servicoId;
    private LocalDateTime dataHora;

    public Agendamento() {}

    public Agendamento(int id, int clienteId, int profissionalId, int servicoId, LocalDateTime dataHora) {
        this.id = id;
        this.clienteId = clienteId;
        this.profissionalId = profissionalId;
        this.servicoId = servicoId;
        this.dataHora = dataHora;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public int getProfissionalId() { return profissionalId; }
    public void setProfissionalId(int profissionalId) { this.profissionalId = profissionalId; }

    public int getServicoId() { return servicoId; }
    public void setServicoId(int servicoId) { this.servicoId = servicoId; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}
