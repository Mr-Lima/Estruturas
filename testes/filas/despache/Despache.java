package filas.despache;

import filas.Fila;

public class Despache {

    public static Fila<Despache> despaches = new Fila<>();
    private Cliente cliente;
    private Produto produto;
    static int id = 1;
    private int codigo;

    public Despache(Cliente cliente, Produto produto) {
        this.cliente = cliente;
        this.produto = produto;
        this.codigo = this.id++;
    }

    public int getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
