package br.edu.infnet.appvenda.model.domain;

public class Carro extends Produto{

    private String motor;

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", super.toString(), getMotor());
    }
}
