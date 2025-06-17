package com.seuusuario.agendamento.entity;

public class TransacaoExterna {
    private int id;
    private int clienteId;
    private double valor;
    private String tipo;

    public TransacaoExterna() {}

    public TransacaoExterna(int id, int clienteId, double valor, String tipo) {
        this.id = id;
        this.clienteId = clienteId;
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
