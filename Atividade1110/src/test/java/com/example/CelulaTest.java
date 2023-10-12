package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CelulaTest {

    @Test
    public void testAtualizarValorENotificacao() {
        Planilha planilha = new Planilha();
        Celula a1 = planilha.criarCelula("A1", 10);
        Celula a2 = planilha.criarCelula("A2", 20);
        Celula a3 = planilha.criarCelula("A3", 0);

        a3.adicionarObservadora(a1);
        a3.adicionarObservadora(a2);

        a1.atualizarValor(15);

        assertEquals(45, a3.getValor()); // O novo valor de A3 deve ser 45
    }
}
