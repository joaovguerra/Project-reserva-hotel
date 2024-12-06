package com.uniube.model;

public class Quarto {
    private int id;
    private String tipo;
    private boolean disponivel;

    public Quarto(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
