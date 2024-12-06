package com.uniube.service;

import com.uniube.model.Quarto;
import com.uniube.model.Reserva;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SistemaDeAluguel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public SistemaDeAluguel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    // Método para cadastrar um quarto
    public void cadastrarQuarto(int id, String tipo) {
        Quarto quarto = new Quarto(id, tipo);
        quartos.add(quarto);
        System.out.println("Quarto " + tipo + " cadastrado com sucesso!");
    }

    // Método para exibir os quartos disponíveis
    public void listarQuartosDisponiveis() {
        System.out.println("Lista de Quartos Disponíveis:");
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel()) {
                System.out.println("ID: " + quarto.getId() + " - Tipo: " + quarto.getTipo());
            }
        }
    }

    // Método para reservar um quarto
    public void reservarQuarto(int idQuarto, Date dataEntrada, Date dataSaida, String clienteNome, double preco) {
        for (Quarto quarto : quartos) {
            if (quarto.getId() == idQuarto && quarto.isDisponivel()) {
                Reserva reserva = new Reserva(quarto, dataEntrada, dataSaida, clienteNome, preco);
                reservas.add(reserva);
                quarto.setDisponivel(false);  // Marca o quarto como reservado
                System.out.println("Reserva realizada com sucesso para o quarto " + quarto.getTipo() + "!");
                return;
            }
        }
        System.out.println("Desculpe, o quarto não está disponível.");
    }

    // Método para registrar a avaliação do cliente
    public void registrarAvaliacao(int idReserva, int avaliacao) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().getId() == idReserva) {
                reserva.setAvaliacaoSatisfacao(avaliacao);
                System.out.println("Avaliação registrada com sucesso!");
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    // Método para gerar relatório de ocupação
    public void gerarRelatorioOcupacao() {
        int ocupados = 0;
        int total = quartos.size();
        for (Quarto quarto : quartos) {
            if (!quarto.isDisponivel()) {
                ocupados++;
            }
        }
        System.out.println("Relatório de Ocupação:");
        System.out.println("Total de Quartos: " + total);
        System.out.println("Quartos Ocupados: " + ocupados);
        System.out.println("Taxa de Ocupação: " + (ocupados * 100 / total) + "%");
    }

    public static void main(String[] args) {
        SistemaDeAluguel sistema = new SistemaDeAluguel();
        Scanner scanner = new Scanner(System.in);

        // Cadastrar alguns quartos
        sistema.cadastrarQuarto(1, "Individual");
        sistema.cadastrarQuarto(2, "Duplo");
        sistema.cadastrarQuarto(3, "Suíte");

        // Interação com o cliente
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Listar Quartos Disponíveis");
            System.out.println("2 - Reservar Quarto");
            System.out.println("3 - Registrar Avaliação");
            System.out.println("4 - Gerar Relatório de Ocupação");
            System.out.println("0 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    sistema.listarQuartosDisponiveis();
                    break;
                case 2:
                    System.out.println("Digite o ID do quarto:");
                    int idQuarto = scanner.nextInt();
                    scanner.nextLine();  // Limpar o buffer
                    System.out.println("Digite a data de entrada (dd/mm/yyyy):");
                    String entrada = scanner.nextLine();
                    System.out.println("Digite a data de saída (dd/mm/yyyy):");
                    String saida = scanner.nextLine();
                    System.out.println("Digite o nome do cliente:");
                    String clienteNome = scanner.nextLine();
                    System.out.println("Digite o preço total da reserva:");
                    double preco = scanner.nextDouble();
                    // O formato das datas está simplificado aqui
                    sistema.reservarQuarto(idQuarto, new Date(), new Date(), clienteNome, preco);
                    break;
                case 3:
                    System.out.println("Digite o ID da reserva para avaliação:");
                    int idReserva = scanner.nextInt();
                    System.out.println("Digite a avaliação (1-5):");
                    int avaliacao = scanner.nextInt();
                    sistema.registrarAvaliacao(idReserva, avaliacao);
                    break;
                case 4:
                    sistema.gerarRelatorioOcupacao();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
