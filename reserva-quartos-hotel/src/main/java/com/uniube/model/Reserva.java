package com.uniube.model;

import java.util.Date;

public class Reserva {
    private Quarto quarto;
    private Date dataEntrada;
    private Date dataSaida;
    private String clienteNome;
    private double preco;
    private int avaliacaoSatisfacao;

    public Reserva(Quarto quarto, Date dataEntrada, Date dataSaida, String clienteNome, double preco) {
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.clienteNome = clienteNome;
        this.preco = preco;
        this.avaliacaoSatisfacao = -1;  // -1 indica que a avaliação ainda não foi fornecida
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public double getPreco() {
        return preco;
    }

    public void setAvaliacaoSatisfacao(int avaliacao) {
        this.avaliacaoSatisfacao = avaliacao;
    }

    public int getAvaliacaoSatisfacao() {
        return avaliacaoSatisfacao;
    }
}
