package br.com.alura.desafioTabelaFipe.service;

public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe);

}
