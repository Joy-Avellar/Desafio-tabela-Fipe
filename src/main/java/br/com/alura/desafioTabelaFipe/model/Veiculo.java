package br.com.alura.desafioTabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo( String Valor,
                       String Marca,
                       String Modelo,
                       Integer AnoModelo,
                       String Combustivel,
                       String CodigoFipe) {

    @Override
    public String toString() {
        return  " Modelo: " + Modelo +
                " Marca: " + Marca +
                " Ano do Modelo: " + AnoModelo +
                " Combustivel: " + Combustivel +
                " Valor: " + Valor +
                " Codigo Fipe: " + CodigoFipe;
    }
}
