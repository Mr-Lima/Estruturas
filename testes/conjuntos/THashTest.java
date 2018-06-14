package conjuntos;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class THashTest {


    @Test
    void inserir() {
        Assert.assertEquals(500f, tabela().buscar(5), 0.5);
    }

    @Test
    void buscar() {
        Assert.assertEquals(500f, tabela().buscar(5), 0.5);
    }

    @Test
    void remover() {
        THash<Integer, Float> tabela = tabela();
        tabela.remover(5);
        Assert.assertNotEquals(500f, tabela.buscar(5));
    }


    @Test
    void tamanho() {
        Assert.assertEquals(99, tabela().tamanho());
    }

    @Test
    void vazio() {
        Assert.assertFalse(tabela().vazio());
        THash<Integer, Float> aux = new THash<>();
        Assert.assertTrue(aux.vazio());
    }

    @Test
    void contem() {
        Assert.assertTrue(tabela().contem(500f));
        Assert.assertFalse(tabela().contem(501f));
    }

    private THash<Integer, Float> tabela() {
        THash<Integer, Float> tabela = new THash<>();
        for (int i = 1; i < 100; i++) {
            tabela.inserir(i, (float) (i * 100));
        }
        return tabela;
    }
}
