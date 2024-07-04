package br.com.alura.desafioTabelaFipe.model;

public record Dados(String nome, Integer codigo) {

    @Override
    public String toString() {
        return "CODIGO: " + codigo +
                " NOME: " + nome;
    }
}
