package prova.me1;

import java.util.ArrayList;

public class Postagem {
    private String conteudo;
    private ArrayList<Pessoa> marcados;

    public Postagem(String conteudo, ArrayList<Pessoa> marcados) {
        this.conteudo = conteudo;
        this.marcados = marcados;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public ArrayList<Pessoa> getMarcados() {
        return marcados;
    }

    @Override
    public String toString() {
        return "Postagem{" +
                "conteudo='" + conteudo + '\'' +
                ", marcados=" + marcados +
                '}';
    }
}
