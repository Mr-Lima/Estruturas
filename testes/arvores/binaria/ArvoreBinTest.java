package arvores.binaria;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ArvoreBinTest {

    @Test
    void buscarValor() {
    }

    @Test
    void buscarChave() {
    }

    @Test
    void add() {

        ArvoreBin<Integer, Integer> nomes = new ArvoreBin<>(0, 0);
        for (Integer i = 1; i < 10; i++) {
            nomes.add(i, i);
        }
        Assert.assertEquals(3, nomes.buscarChave(3).getValor());


    }

    @Test
    void removeChave() {
    }

    @Test
    void removeValor() {
    }
}