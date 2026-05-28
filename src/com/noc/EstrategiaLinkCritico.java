package com.noc;

public class EstrategiaLinkCritico implements EstrategiaTriagem {
    @Override
    public boolean combinaCom(String mensagem) {
        String msg = mensagem.toLowerCase();
        return msg.contains("down") || msg.contains("fibra rompida");
    }

    @Override
    public Severidade getSeveridade() { 
        return Severidade.CRITICO; 
    }
}
