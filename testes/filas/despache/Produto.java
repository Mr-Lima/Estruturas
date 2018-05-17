package filas.despache;

import listas.VetorLista;

public class Produto {
    public static VetorLista<Produto> produtos = new VetorLista<>();
    private int id;
    private String nome;

    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
}
