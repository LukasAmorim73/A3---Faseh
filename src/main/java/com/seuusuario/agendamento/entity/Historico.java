package com.seuusuario.agendamento.entity;

public class Historico {
    private int id;
    private int clienteId;
    private String descricao;

    public Historico() {}

    public Historico(int id, int clienteId, String descricao) {
        this.id = id;
        this.clienteId = clienteId;
        this.descricao = descricao;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
