package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnderecoTest {

    @Test
    public void testBuilderPattern() {
        Endereco endereco = new Endereco.Builder()
                .rua("Rua A")
                .setor("Setor X")
                .cep("12345-678")
                .numero("123")
                .cidade("Cidade")
                .estado("Estado")
                .bloco("Bloco A")
                .quadra("Quadra B")
                .build();

        assertEquals("Rua A", endereco.getRua());
        assertEquals("Setor X", endereco.getSetor());
        assertEquals("12345-678", endereco.getCep());
        assertEquals("123", endereco.getNumero());
        assertEquals("Cidade", endereco.getCidade());
        assertEquals("Estado", endereco.getEstado());
        assertEquals("Bloco A", endereco.getBloco());
        assertEquals("Quadra B", endereco.getQuadra());
    }
}
