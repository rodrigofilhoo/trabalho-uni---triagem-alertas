package com.noc;
import java.util.List;

public class ProcessadorAlertas {
    private final List<EstrategiaTriagem> estrategias;
    public ProcessadorAlertas(List<EstrategiaTriagem> estrategias) {
        this.estrategias = estrategias; 
    }

    public Alerta processar(String mensagemBruta) {
        Alerta alerta = AlertaFactory.criarAlertaBruto(mensagemBruta);

        for (EstrategiaTriagem estrategia : estrategias) {
            if (estrategia.combinaCom(mensagemBruta)) {
                alerta.setSeveridade(estrategia.getSeveridade());
                break; 
            }
        }
        return alerta;
    }
}