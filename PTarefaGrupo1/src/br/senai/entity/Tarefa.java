package br.senai.entity;

import java.util.Date;

public class Tarefa {

    private Integer idTarefa;
    private String descricao;
    private Date prazo;
    private Boolean concluido;
    private Lista lista;

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }



    public Tarefa() {
        idTarefa = 0;
        concluido = false;
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
    
    public Integer getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Integer idTarefa) {
        this.idTarefa = idTarefa;
    }

}
