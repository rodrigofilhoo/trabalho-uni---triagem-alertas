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
        // Testa se identifica as palavras-chave obrigatórias
        assertTrue(estrategia.combinaCom("Erro: link down no roteador"));
        assertTrue(estrategia.combinaCom("Alerta de fibra rompida na filial"));
    }

    @Test
    public void testCombinaComMensagemValidaCaseInsensitive() {
        // Testa se funciona com letras maiúsculas/misturadas
        assertTrue(estrategia.combinaCom("LINK DOWN"));
        assertTrue(estrategia.combinaCom("Fibra Rompida"));
    }

    @Test
    public void testNaoCombinaComMensagemIrrelevante() {
        // Testa se ignora mensagens que não são críticas
        assertFalse(estrategia.combinaCom("Uso de CPU acima de 80%"));
        assertFalse(estrategia.combinaCom("Link restabelecido com sucesso"));
    }

    @Test
    public void testGetSeveridade() {
        // Garante que a severidade dessa estratégia sempre será CRITICO
        assertEquals(Severidade.CRITICO, estrategia.getSeveridade());
    }
}