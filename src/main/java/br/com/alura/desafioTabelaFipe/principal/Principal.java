package br.com.alura.desafioTabelaFipe.principal;

import br.com.alura.desafioTabelaFipe.service.ConsumoApi;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu () {

       var menu = """
              ====Escolha Uma OPção===
              Carro
              Moto
              Caminhão
               """;

        System.out.println(menu);
        var opcao = leitura.nextLine();

        String endereco;
        if (opcao.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco= URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = new ConsumoApi().obterDados(endereco);
        System.out.println(json);

        System.out.println("Digite o código da marca desejada");

        var marca = leitura.nextLine();


        if (opcao.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas/" + marca + "/modelos";
        }
        var jsonMarca = new ConsumoApi().obterDados(endereco);
        System.out.println(jsonMarca);




    }
}
