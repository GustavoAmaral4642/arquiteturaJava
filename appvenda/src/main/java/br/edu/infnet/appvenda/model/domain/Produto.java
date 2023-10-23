package br.edu.infnet.appvenda.model.domain;

public class Produto {

    private int codigo;
    private String marca;
    private String modelo;
    private int ano;
    private float preco;
    private boolean estoque;
    private String quilometragem;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    @Override
    public String toString() {
        return String.format("%d - %s - %s - %d - %.2f - %s - %s", getCodigo(), getMarca(), getModelo(), getAno(), getPreco(), getQuilometragem(), isEstoque());
    }
}
