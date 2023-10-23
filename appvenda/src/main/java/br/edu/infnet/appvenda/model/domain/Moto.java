package br.edu.infnet.appvenda.model.domain;

public class Moto extends Produto{

    private String cilindrada;
    private boolean injecaoEletronica;

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public boolean isInjecaoEletronica() {
        return injecaoEletronica;
    }

    public void setInjecaoEletronica(boolean injecaoEletronica) {
        this.injecaoEletronica = injecaoEletronica;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", super.toString(), getCilindrada(), isInjecaoEletronica());
    }
}
