# Sistema de Aluguel de Quartos de Hotel

Este é um sistema simples de gerenciamento de reservas de quartos de hotel. O sistema permite cadastrar quartos, realizar reservas, registrar avaliações de clientes e gerar relatórios de ocupação.

## Funcionalidades

- **Cadastro de Quartos**: Permite cadastrar diferentes tipos de quartos (Individual, Duplo, Suíte, etc.).
- **Exibição de Quartos Disponíveis**: Exibe todos os quartos que estão disponíveis para reserva.
- **Reserva de Quarto**: Permite que os usuários realizem reservas de quartos, fornecendo dados como data de entrada, data de saída, nome do cliente e preço da reserva.
- **Registro de Avaliação**: Os clientes podem avaliar os quartos após a estadia, de 1 a 5.
- **Relatório de Ocupação**: Gera um relatório com a quantidade de quartos ocupados e a taxa de ocupação do hotel.

## Estrutura de Pacotes

O código está organizado em pacotes para separar a lógica de negócios da definição do modelo de dados:

- **com.hotel.model**: Contém as classes `Quarto` e `Reserva`, que representam o modelo de dados do sistema.
- **com.hotel.service**: Contém a classe `SistemaDeAluguel`, que é responsável pela lógica de reserva e gerenciamento do hotel.

## Requisitos

- Java 8 ou superior

## Como Rodar o Sistema

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/sistema-aluguel-quartos.git
