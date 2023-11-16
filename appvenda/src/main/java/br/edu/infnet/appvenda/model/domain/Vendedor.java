package br.edu.infnet.appvenda.model.domain;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tvendedor",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"nome"}),
                             @UniqueConstraint(columnNames = {"email"})})
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 2, max = 50)
    @Column(unique = true)
    private String nome;
    //@CPF
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    @Column(unique = true)
    private String cpf;
    @Email
    @Column(unique = true)
    private String email;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name="idVendedor")
    private List<Produto> produtos;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return String.format("[id]: %d - [nome]: %s - [e-mail]: %s - [cpf]: %s - [endereço]: %s - produtos (%d)",getId(), getNome(), getEmail(), getCpf(), getEndereco(), produtos != null ? produtos.size() : 0);
    }
}
