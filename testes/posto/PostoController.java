package posto;

import conjuntos.THash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import static posto.Posto.postoLista;

public class PostoController {

    public boolean cadastrarPosto(String nome, String endereco, String cidade, String estado, double lat, double lon) {
        try {
            Posto posto = new Posto(nome, endereco, cidade, estado, lat, lon);
            if (postoLista.contemChave(estado)) {
                postoLista.buscar(estado).inserir(posto.getId(), posto);
                return true;
            } else {
                postoLista.inserir(estado, new THash<>());
                postoLista.buscar(estado).inserir(posto.getId(), posto);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Posto> getPostosPorNome(String nome) {
        ArrayList<Posto> postosParaRemocao = new ArrayList<>();
        for (THash<Integer, Posto> queue : postoLista) {
            queue.forEach(item -> {
                if (item.getNome().equalsIgnoreCase(nome))
                    postosParaRemocao.add(item);
            });
        }
        return postosParaRemocao;
    }

    public boolean removerPosto(String estado, Posto posto) {
        try {
            postoLista.buscar(estado).remover(posto.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean compInfo(String estado, Integer id, float preco, double tempo) {
        try {
            Posto posto = postoLista.buscar(estado).buscar(id);
            posto.setPreco(preco);
            posto.addTempo(tempo);
            posto.setComb(true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean compInfo(String estado, Integer id) {
        try {
            Posto posto = postoLista.buscar(estado).buscar(id);
            posto.setComb(false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String mostrarPostos(String estado, double lat, double lon, boolean filter, boolean sort) {
        Comparator<Posto> postoComparator;
        if (sort)
           postoComparator = (posto, t1) -> (int) (posto.getDistancia() - t1.getDistancia());
        else
            postoComparator = (posto, t1) -> (int) (posto.getMediaTempo() - t1.getMediaTempo());
        PriorityQueue<Posto> postosQueue = new PriorityQueue<>(postoComparator);
        THash<Integer, Posto> postos = postoLista.buscar(estado);
        if (filter) {
            for (Posto posto : postos) {
                if (posto.isComb())
                    posto.setDistancia(lat, lon);
                    postosQueue.add(posto);
            }
        } else {
            for (Posto posto : postos) {
                posto.setDistancia(lat, lon);
                postosQueue.add(posto);
            }
        }

        return postosQueue.toString();
    }
}
