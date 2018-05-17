package filas.despache;

import listas.VetorLista;

public class Cliente {
    public static VetorLista<Cliente> clientes = new VetorLista<>();
    private int cpf;
    private String nome;

    public Cliente(int cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }
}
