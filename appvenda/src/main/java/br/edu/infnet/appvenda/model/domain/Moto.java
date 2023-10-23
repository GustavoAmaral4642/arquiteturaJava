package br.edu.infnet.appvenda.model.domain;

public class Moto extends Produto{

    private String cilindrada;

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", super.toString(), getCilindrada());
    }
}
