package arvores.binaria.buscaBinaria;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ABBTest {
    ABB<Integer, Integer> arvore = new ABB<>();
    ArrayList<Integer> testes = new ArrayList<>();

    void criarLista() {
        /*for (int i = 1; i < 11; i++) {
            testes.add(i);
        }
        Collections.shuffle(testes);*/
        testes.add(9);
        testes.add(8);
        testes.add(10);
        testes.add(3);
        testes.add(1);
        testes.add(5);
        testes.add(2);
        testes.add(4);
        testes.add(7);
        testes.add(6);
    }

    @Test
    void inserir() {
        criarLista();
        System.out.println(testes.toString());
        for (Integer i : testes) {
            arvore.inserir(i, i);
        }
        arvore.listar();
    }

    @Test
    void buscar() {
        inserir();
        Assert.assertEquals(5, (long) arvore.buscar(5));
        arvore.listar();
    }

    @Test
    void remover() {
        inserir();
        Assert.assertEquals(5, (long) arvore.remover(5));
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n");
        arvore.listar();
    }

    @Test
    void showNo() {
        inserir();
        arvore.showNo(5);
    }

    @Test
    void limpar() {
        inserir();
        arvore.limpar();
        arvore.listar();
    }

    @Test
    void listar() {
        inserir();
        System.out.println(arvore.toString());
    }

}