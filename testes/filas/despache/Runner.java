package filas.despache;

import listas.VetorLista;

import java.util.Scanner;

public class Runner {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.Menu();
    }

    private void Menu(){
        int opc = -1;
        while (opc != 0) {
            System.out.println("======="
                    + "1-Cadastrar produto\n"
                    + "2-Cadastrar cliente\n"
                    + "3-Efetuar pedido\n"
                    + "4-Despachar pedido\n"
                    + "5-Exibir fila de pedidos\n"
                    + "0-Sair\n\n");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    cadProd();
                    break;
                case 2:
                    cadClt();
                    break;
                case 3:
                    efetPed();
                    break;
                case 4:
                    dpcPed();
                    break;
                case 5:
                    pedidos();
                    break;
                default:
                    break;
            }
        }
    }

    private void pedidos() {
        System.out.println(Despache.despaches.toString());
    }

    private void dpcPed() {
        System.out.println("Pedido: "+Despache.despaches.primeiro().getCodigo()+" despachado!");
        Despache.despaches.desenfileirar();
    }

    private void efetPed() {
        int cpf, id;
        Cliente auxCliente = null;
        VetorLista<Produto> auxProdutos = new VetorLista<>();
        String escolha = null;

        System.out.println("CPF cliente:");
        cpf = input.nextInt();
        do {
            System.out.println("Id produto:");
            id = input.nextInt();
            for (Produto produto : Produto.produtos){
                if(id==produto.getId())
                    auxProdutos.add(produto);
            }
            System.out.println("Adcionar outro produto? (Y/N)");
            escolha = input.next();
        }while (escolha.equalsIgnoreCase("y"));

        for (Cliente cliente :
                Cliente.clientes) {
            if(cpf==cliente.getCpf())
                auxCliente = cliente;
        }
        Despache.despaches.enfileirar(new Despache(auxCliente, auxProdutos));
        System.out.println("Pedido efetuado");
    }

    private void cadClt() {
        int cpf;
        String nome;
        System.out.println("CPF (So numeros):");
        cpf = input.nextInt();
        System.out.println("Nome do cliente:");
        nome = input.next();
        Cliente.clientes.add(new Cliente(cpf, nome));
    }

    private void cadProd() {
        int id;
        String nome;
        System.out.println("Id do produto: ");
        id = input.nextInt();
        System.out.println("Nome do produto: ");
        nome = input.next();
        Produto.produtos.add(new Produto(id, nome));
    }
}
