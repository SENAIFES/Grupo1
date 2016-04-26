package br.senai.entity;

import java.util.Date;

public class Tarefa {

    private Integer id;
    private String descricao;
    private Date prazo;
    private Boolean concluido;

    public Tarefa() {
    }

    public Tarefa(String descricao, Date prazo, Boolean feito) {
        this.descricao = descricao;
        this.prazo = prazo;
        this.concluido = feito;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
