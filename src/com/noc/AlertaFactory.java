package com.noc;
import java.util.UUID;

public class AlertaFactory {
    public static Alerta criarAlertaBruto(String mensagem) {
        return new Alerta(UUID.randomUUID().toString(), mensagem, Severidade.INFO);
    }
}