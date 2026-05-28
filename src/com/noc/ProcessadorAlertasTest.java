package com.noc;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProcessadorAlertasTest {

    private ProcessadorAlertas processador;
    private List<EstrategiaTriagem> estrategias;
    
    @BeforeEach
    public void setUp() {
        estrategias = new ArrayList<>();
        estrategias.add(new EstrategiaLinkCritico());
        processador = new ProcessadorAlertas(estrategias);
    }
    @Test
    public void testProcessarMensagemSemEstrategiaCorrespondente() {
        String mensagem = "Sistema operando normalmente dentro dos parâmetros.";
        Alerta resultado = processador.processar(mensagem);
        assertNotNull(resultado, "O alerta gerado não deveria ser nulo.");
        assertEquals(mensagem, resultado.getMensagem());
        assertEquals(Severidade.INFO, resultado.getSeveridade(), "A severidade padrão deve ser INFO.");
    }
    @Test
    public void testProcessarMensagemComEstrategiaLinkCriticoDown() {
        String mensagem = "O servidor principal ficou DOWN inesperadamente.";
        Alerta resultado = processador.processar(mensagem);
        assertEquals(Severidade.CRITICO, resultado.getSeveridade(), "A severidade deveria ser alterada para CRITICO.");
    }
    @Test
    public void testProcessarMensagemComEstrategiaLinkCriticoFibraRompida() {
        String mensagem = "Alerta: Identificada fibra rompida no trecho sul.";
        Alerta resultado = processador.processar(mensagem);
        assertEquals(Severidade.CRITICO, resultado.getSeveridade(), "Mensagens de fibra rompida devem ser de severidade CRITICA.");
    }
    @Test
    public void testProcessarMensagemComMultiplasEstrategiasRespeitaPrimeira() {
        EstrategiaTriagem outraEstrategia = new EstrategiaTriagem() {
            @Override
            public boolean combinaCom(String mensagem) {
                return mensagem.contains("down");
            }
            @Override
            public Severidade getSeveridade() {
                return Severidade.AVISO;
            }
        };
        estrategias.add(outraEstrategia);
        processador = new ProcessadorAlertas(estrategias);
        Alerta resultado = processador.processar("Link down na interface principal.");
        assertEquals(Severidade.CRITICO, resultado.getSeveridade(), "O processador deveria parar na primeira estratégia correspondente.");
    }
}