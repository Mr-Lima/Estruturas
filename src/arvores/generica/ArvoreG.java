package arvores.generica;

import filas.FilaLkd;
import listas.LkdList;

public class ArvoreG<T> {
    private No raiz;
    private int tamanho = 0;

    public ArvoreG(T valor) {
        this.raiz = new No<>(valor);
        tamanho++;
    }

    public void inserir(T valor, No pai) {
        busca_em_largura(pai).getNos().add(new No(valor));
        tamanho++;
    }

    public No<T> obterRaiz() {
        return this.raiz;
    }

    public LkdList obterFilhos(No pai) {
        LkdList<No> filhos = new LkdList<>();

        for (No filho : busca_em_largura(pai).getNos()) {
            filhos.add(filho);
        }
        return filhos;
    }

    public No removerNo(No no) {
        FilaLkd<No> noFilaLkd = new FilaLkd<>();
        noFilaLkd.enfileirar(this.raiz);

        while (!noFilaLkd.vazio()) {
            No pai = noFilaLkd.olhar();
            LkdList<No> adjacentes = noFilaLkd.desenfileirar().getNos();

            for (No x : adjacentes) {
                if (x.equals(no)) {
                    pai.getNos().remove(no);
                    tamanho--;
                    return x;
                } else
                    noFilaLkd.enfileirar(x);
            }
        }
        return null;
    }

    public No removerFilhos(No pai) {
        No aux = busca_em_largura(pai);
        busca_em_largura(pai).setNos(new LkdList<>());
        return aux;
    }

    private No<T> busca_em_largura(No no) {
        if (this.raiz.equals(no))
            return this.raiz;
        FilaLkd<No> noFilaLkd = new FilaLkd<>();
        noFilaLkd.enfileirar(this.raiz);

        while (!noFilaLkd.vazio()) {
            LkdList<No> adjacentes = noFilaLkd.desenfileirar().getNos();

            for (No x : adjacentes) {
                if (x.equals(no))
                    return no;
                else
                    noFilaLkd.enfileirar(x);
            }
        }
        return null;
    }

    private class No<T> {
        T valor;
        LkdList<No> nos;

        public No(T valor) {
            this.valor = valor;
            this.nos = new LkdList<>();
        }

        public LkdList<No> getNos() {
            return nos;
        }

        public void setNos(LkdList<No> nos) {
            this.nos = nos;
        }

        public T getValor() {
            return valor;
        }
    }

}
