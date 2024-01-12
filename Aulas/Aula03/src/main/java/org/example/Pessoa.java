package org.example;

public class Pessoa {
    int codigo, idade;
    String nome;

    public Pessoa(int codigo, int idade, String nome) {
        this.codigo = codigo;
        this.idade = idade;
        this.nome = nome;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getNome() {
        return this.nome;
    }
}

