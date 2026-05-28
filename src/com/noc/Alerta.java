package com.noc;

public class Alerta {
    private String id;
    private String mensagem;
    private Severidade severidade;

    public Alerta(String id, String mensagem, Severidade severidade) {
        this.id = id;
        this.mensagem = mensagem;
        this.severidade = severidade;
    }

    public void setSeveridade(Severidade severidade) { this.severidade = severidade; }
    public Severidade getSeveridade() { return severidade; }
    public String getMensagem() { return mensagem; }
}