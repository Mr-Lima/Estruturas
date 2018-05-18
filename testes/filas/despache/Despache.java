package filas.despache;

import filas.FilaLkd;
import listas.VetorLista;

public class Despache {

    public static FilaLkd<Despache> despaches = new FilaLkd<>();
    private Cliente cliente;
    private VetorLista<Produto> produtos;
    static int id = 1;
    private int codigo;

    public Despache(Cliente cliente, VetorLista<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.codigo = this.id++;
    }

    public int getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Pedido: "+this.codigo+"\tCliente: "+this.cliente.getCpf()+"\tID PRODUTOS:");
        for(Produto produto : produtos){
            builder.append("-----"+produto.getId());
        }
        return builder.toString();
    }
}
