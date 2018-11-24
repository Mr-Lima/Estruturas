package posto;

import java.security.spec.InvalidParameterSpecException;
import java.util.ArrayList;
import java.util.Scanner;

import static posto.Posto.postoLista;

public class Runner {
    Scanner input = new Scanner(System.in);
    PostoController postoController = new PostoController();
    public static int m, n = 1;

    public static void main(String[] args) throws InvalidParameterSpecException {
        Runner m = new Runner();
        m.Menu();
    }

    private void Menu() throws InvalidParameterSpecException {
        int opc = -1;
        while (opc != 0) {
            System.out.println("======="+"\n"
                    + "1-Cadastrar posto\n"
                    + "2-Remover posto\n"
                    + "3-Compartilhar informações\n"
                    + "4-Consultar preços\n"
                    + "0-Sair\n\n");
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    cadPostoView();
                    break;
                case 2:
                    remPosto();
                    break;
                case 3:
                    compInfoView();
                    break;
                case 4:
                    precoView();
                    break;
                default:
                    break;
            }
        }
    }

    private void cadPostoView() {
        String nome, endereco, cidade, estado;
        double lat, lon;
        System.out.println("Nome:");
        nome = input.next();
        System.out.println("Endereco:");
        endereco = input.next();
        System.out.println("Cidade:");
        cidade = input.next();
        System.out.println("Estado:");
        estado = input.next();
        System.out.println("Latitude:");
        lat = input.nextDouble();
        System.out.println("Longitude");
        lon = input.nextDouble();

        if (postoController.cadastrarPosto(nome, endereco, cidade, estado, lat, lon)) {
            System.out.println("Posto cadastrado");
        } else {
            System.out.println("Erro ao cadastrar");
        }
    }

    private void remPosto() {
        String posto;
        System.out.println("Nome posto:");
        posto = input.next().toLowerCase();
        ArrayList<Posto> postosFiltrados = postoController.getPostosPorNome(posto);
        System.out.println(postosFiltrados.toString());
        System.out.println("Digite o id desejado: ");
        int id = input.nextInt();
        Posto paraRemover = postosFiltrados.stream()
                .filter(item -> item.getId()==id)
                .findFirst().orElse(null);
        if (postoController.removerPosto(paraRemover.getEstado(), paraRemover)) {
            System.out.println("Posto removido");
        } else {
            System.out.println("Falha ao remover");
        }
//        System.out.println("Posto: "+aux.getNome()+"\n" +
//                "Endereco: "+aux.getEndereco()+"\n" +
//                "Cidade: "+aux.getCidade()+"\n" +
//                "Estado: "+aux.getEstado()+"\n" +
//                "Confirma?(y/n)");
//        if (input.next().equalsIgnoreCase("y")){
//            postoLista.remover(posto.toLowerCase());
//            System.out.println("Posto removido");
//        }
    }
//
    private void compInfoView() {
        String estado;
        Integer id;
        boolean comb;
        float preco;
        double tempo;
        System.out.println("Estado:");
        estado = input.next();
        System.out.println(postoLista.buscar(estado).toString());
        System.out.println("Posto Id: ");
        id = input.nextInt();
        System.out.println("Tem combustivel?(y/n)");
        String seCombString = input.next();
        comb = seCombString.equalsIgnoreCase("y") ? true : false;
        if (comb) {
            System.out.println("Preco:");
            preco = input.nextFloat();
            System.out.println("Tempo de espera: (horas)");
            tempo = input.nextDouble();
            if (postoController.compInfo(estado, id, preco, tempo)) {
                System.out.println("Informacoes enviadas");
            } else {
                System.out.println("Erro ao enviar informações");
            }
        } else {
            if (postoController.compInfo(estado, id)) {
                System.out.println("Informacoes enviadas");
            } else {
                System.out.println("Erro ao enviar informações");
            }
        }
    }

    private void precoView() {
        String estado;
        boolean comb;
        boolean localPreco;
        double lat, lon;
        System.out.println("Estado:");
        estado = input.next();
        System.out.println("Latitude:");
        lat = input.nextDouble();
        System.out.println("Longitude:");
        lon = input.nextDouble();
        System.out.println("Filtrar apenas com disponibilidade? (y/n) [Default: n]");
        boolean isFiltrarDisp = input.next().equalsIgnoreCase("y") ? true : false;
        System.out.println("Sortear por distancia(1) ou menor tempo em fila(2) [Default: Menor Tempo]?");
        boolean isSort = input.next().equalsIgnoreCase("1") ? true : false;

        System.out.println("Lista de postos");
        System.out.println(postoController.mostrarPostos(estado, lat, lon, isFiltrarDisp, isSort));
    }
}
