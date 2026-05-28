package com.noc;

public interface EstrategiaTriagem {
    boolean combinaCom(String mensagem);
    Severidade getSeveridade();
}
