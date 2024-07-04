package br.com.alura.desafioTabelaFipe.principal;

import br.com.alura.desafioTabelaFipe.model.Dados;
import br.com.alura.desafioTabelaFipe.model.Modelos;
import br.com.alura.desafioTabelaFipe.model.Veiculo;
import br.com.alura.desafioTabelaFipe.service.ConsumoApi;
import br.com.alura.desafioTabelaFipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();

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
        var marcas = conversor.obterLIsta(json, Dados.class);

        marcas.stream()
                .sorted(Comparator.comparing(Dados::nome))
                .forEach(System.out::println);

        System.out.println("Digite o código da marca desejada");

        var modelo = leitura.nextLine();
        endereco = endereco + "/" + modelo + "/modelos";

        json = new ConsumoApi().obterDados(endereco);

        var modelos = conversor.obterDados(json, Modelos.class);
        System.out.println("\n Modelos dessa marca: " );

        modelos.modelos().stream()
                .sorted(Comparator.comparing(Dados::nome))
                .forEach(System.out::println);

        System.out.println("\nDigite o nome do modelo para ser buscado: ");

        var nomeVeiculo = leitura.nextLine();

        List<Dados> modelosFiltrados = modelos.modelos().stream()
                        .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                        .collect(Collectors.toList());

        System.out.println("Modelos Encontrados: ");
        modelosFiltrados.forEach(System.out::println);



        System.out.println("Digite o código do Modelo para veriricar os anos");

        var codigoModelos = leitura.nextLine();
        endereco = endereco + "/" + codigoModelos + "/anos";

        json = new ConsumoApi().obterDados(endereco);

        List<Dados> anos = conversor.obterLIsta(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = new ConsumoApi().obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veiculos filtrados com avaliações por ano: "); veiculos.forEach(System.out::println);



//        var  cpdigoModelos = conversor.obterDados(json, Dados.class);
//        System.out.println("\n Anos desse Modelo: " );
//
//        ano.anos().stream()
//                .sorted(Comparator.comparing(Dados::codigo))
//                .forEach(System.out::println);



    }
}
