package br.com.alura.desafioTabelaFipe.service;

import java.util.List;

public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe);

    <T> List<T> obterLIsta(String json, Class<T> classe);
}
