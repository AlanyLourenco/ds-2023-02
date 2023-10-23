package com.example;


public class EnumExemplo {
    // Enum para Dias da Semana
    public enum DiaDaSemana {
        SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
    }

    // Enum para Permissões em um Diretório
    public enum PermissaoDiretorio {
        LEITURA, ESCRITA, EXECUCAO
    }

    // Enum para Tamanho de Pizza
    public enum TamanhoPizza {
        PEQUENA, MEDIA, GRANDE, GIGANTE
    }

    // Enum para Pontos Cardeais
    public enum PontoCardeal {
        NORTE, LESTE, SUL, OESTE
    }

    // Enum para Posições em um Tabuleiro de Xadrez
    public enum PosicaoTabuleiroXadrez {
        A1, A2, A3, A4, A5, A6, A7, A8,
        B1, B2, B3, B4, B5, B6, B7, B8,
        C1, C2, C3, C4, C5, C6, C7, C8,
        D1, D2, D3, D4, D5, D6, D7, D8,
        E1, E2, E3, E4, E5, E6, E7, E8,
        F1, F2, F3, F4, F5, F6, F7, F8,
        G1, G2, G3, G4, G5, G6, G7, G8,
        H1, H2, H3, H4, H5, H6, H7, H8
    }

    public static void main(String[] args) {
        // Exemplos de uso das enums
        DiaDaSemana dia = DiaDaSemana.SEGUNDA;
        PermissaoDiretorio permissao = PermissaoDiretorio.LEITURA;
        TamanhoPizza tamanho = TamanhoPizza.MEDIA;
        PontoCardeal ponto = PontoCardeal.NORTE;
        PosicaoTabuleiroXadrez posicao = PosicaoTabuleiroXadrez.A1;

        // Exibindo os valores das enums
        System.out.println("Dia da Semana: " + dia);
        System.out.println("Permissão de Diretório: " + permissao);
        System.out.println("Tamanho de Pizza: " + tamanho);
        System.out.println("Ponto Cardeal: " + ponto);
        System.out.println("Posição no Tabuleiro de Xadrez: " + posicao);
    }
}

