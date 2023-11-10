package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TCarro")
public class Carro extends Produto{
    @Size(min = 1, max = 5, message = "O motor deve conter entre 1 e 4 caracteres")
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
