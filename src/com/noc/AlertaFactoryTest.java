package com.noc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AlertaFactoryTest {

    @Test
    public void testCriarAlertaBruto() {
        String mensagem = "Teste de carga no sistema";
        Alerta alerta = AlertaFactory.criarAlertaBruto(mensagem);

        // Valida se o alerta foi construído corretamente pela Factory
        assertNotNull(alerta, "O alerta criado não deve ser nulo.");
        assertEquals(mensagem, alerta.getMensagem(), "A mensagem deve ser a mesma passada no parâmetro.");
        assertEquals(Severidade.INFO, alerta.getSeveridade(), "O alerta bruto deve sempre nascer como INFO.");
    }
}