package br.com.fiap.challenge.model;


import br.com.fiap.challenge.DTO.IasDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.util.Optional;
import java.util.UUID;

@Entity
public class Ias {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String tipo;
    private String descricao;


    public Ias(IasDTO dados){

        this.nome = dados.nome();
        this.tipo = dados.tipo();
        this.descricao = dados.desc();
    }

    public Ias() {
    }

    public Ias(Optional<Ias> byId) {
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Ias(String nome, String tipo, String descricao) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Ias(UUID id, String nome, String tipo, String descricao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
    }
}
