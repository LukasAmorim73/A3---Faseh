package com.seuusuario.agendamento.entity;

public class Notificacao {
    private int id;
    private int clienteId;
    private String mensagem;

    public Notificacao() {}

    public Notificacao(int id, int clienteId, String mensagem) {
        this.id = id;
        this.clienteId = clienteId;
        this.mensagem = mensagem;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}
