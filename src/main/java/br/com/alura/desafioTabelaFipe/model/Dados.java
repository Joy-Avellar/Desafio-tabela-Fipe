package br.com.alura.desafioTabelaFipe.model;

public record Dados(String nome, String codigo) {

    @Override
    public String toString() {
        return "CODIGO: " + codigo +
                " NOME: " + nome;
    }
}
