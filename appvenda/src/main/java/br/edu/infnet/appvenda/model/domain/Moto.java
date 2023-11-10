package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TMoto")
public class Moto  extends Produto{

    @Size(min = 1, max = 5, message = "A cilindrada deve conter entre 1 e 5 caracteres")
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
