package com.noc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EstrategiaLinkCriticoTest {

    private EstrategiaLinkCritico estrategia;

    @BeforeEach
    public void setUp() {
        estrategia = new EstrategiaLinkCritico();
    }

    @Test
    public void testCombinaComMensagemValida() {
        assertTrue(estrategia.combinaCom("Erro: link down no roteador"));
        assertTrue(estrategia.combinaCom("Alerta de fibra rompida na filial"));
    }

    @Test
    public void testCombinaComMensagemValidaCaseInsensitive() {
        assertTrue(estrategia.combinaCom("LINK DOWN"));
        assertTrue(estrategia.combinaCom("Fibra Rompida"));
    }

    @Test
    public void testNaoCombinaComMensagemIrrelevante() {
        assertFalse(estrategia.combinaCom("Uso de CPU acima de 80%"));
        assertFalse(estrategia.combinaCom("Link restabelecido com sucesso"));
    }

    @Test
    public void testGetSeveridade() {
        assertEquals(Severidade.CRITICO, estrategia.getSeveridade());
    }
}