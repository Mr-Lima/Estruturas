package prova.me1;

import arvores.binaria.buscaBinaria.ABB;

import java.util.ArrayList;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private ArrayList<Postagem> postagens;
    private ABB<String, Pessoa> amigos;

    public Pessoa(String nome) {
        this.nome = nome;
        postagens = new ArrayList<>();
        amigos = new ABB<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Postagem> getPostagens() {
        return postagens;
    }

    public ABB<String, Pessoa> getAmigos() {
        return amigos;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public int compareTo(Pessoa o) {
        return this.nome.compareToIgnoreCase(o.nome);
    }
}
