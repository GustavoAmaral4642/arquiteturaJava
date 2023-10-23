package br.edu.infnet.appvenda.model.domain;

public class Carro extends Produto{

    private String motor;
    private boolean arCondicionado;

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", super.toString(), getMotor(), isArCondicionado());
    }
}
