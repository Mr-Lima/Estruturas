package listas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class ListaEncadSTest {

    @Test
    void add() {
        ListaEncadS<Integer> lista = new ListaEncadS<>();
        lista.add(15);
        Assertions.assertEquals((Integer) 15, lista.get(0));
    }

    @Test
    void add1() {
        Random x = new Random();
        ListaEncadS<Integer> lista = new ListaEncadS<>();
        for (int i = 0; i < 1000; i++) {
            lista.add(x.nextInt(999));
        }
        lista.add(15, 2);
        Assertions.assertEquals((Integer) 15, lista.get(2));
    }

    @Test
    void addBegin() {
        Random x = new Random();
        ListaEncadS<Integer> lista = new ListaEncadS<>();
        for (int i = 0; i < 1000; i++) {
            lista.add(x.nextInt(999));
        }
        lista.addBegin(15);
        Assertions.assertEquals((Integer) 15, lista.get(0));
    }

    @Test
    void addLast() {
        Random x = new Random();
        ListaEncadS<Integer> lista = new ListaEncadS<>();
        for (int i = 0; i < 1000; i++) {
            lista.add(x.nextInt(999));
        }
        lista.addLast(15);
        Assertions.assertEquals((Integer) 15, lista.getLast());
    }

    @Test
    void addAll() {
        Random x = new Random();
        ListaEncadS<Integer> lista = new ListaEncadS<>();
        ListaEncadS<Integer> aux = new ListaEncadS<>();
        for (int i = 0; i < 1000; i++) {
            lista.add(x.nextInt(999));
            aux.add(x.nextInt(999));
        }

        lista.addAll(aux);
    }

    @Test
    void remove() {
        Random x = new Random();
        ListaEncadS<Integer> lista = new ListaEncadS<>();
        for (int i = 0; i < 1000; i++) {
            lista.add(x.nextInt(999));
        }
        Integer aux = lista.get(15);
        Assertions.assertEquals(aux, lista.remove(15));
    }

    @Test
    void contains() {
        Random x = new Random();
        ListaEncadS<Integer> lista = new ListaEncadS<>();
        for (int i = 0; i < 1000; i++) {
            lista.add(x.nextInt(999));
        }
        lista.add(15, 10);
        Assertions.assertTrue(lista.contains(15));
    }

    @Test
    void clear() {
        Random x = new Random();
        ListaEncadS<Integer> lista = new ListaEncadS<>();
        for (int i = 0; i < 1000; i++) {
            lista.add(x.nextInt(999));
        }
        lista.clear();
        Assertions.assertEquals(0, lista.lenght());
    }

    @Test
    void lenght() {
        Random x = new Random();
        ListaEncadS<Integer> lista = new ListaEncadS<>();
        for (int i = 0; i < 100; i++) {
            lista.add(x.nextInt(999));
        }
        Assertions.assertEquals(100, lista.lenght());
    }
}