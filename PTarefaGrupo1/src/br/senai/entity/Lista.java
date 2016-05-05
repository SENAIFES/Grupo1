
package br.senai.entity;


public class Lista {
    private Integer id;
    private String nome;

    public Integer getId() {
        return id;
    }
    
     public Lista () {
        id = 0;
        
    }

    @Override
    public String toString() {
        return nome;
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

}