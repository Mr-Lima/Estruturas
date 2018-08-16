package arvores.binaria;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArvoreBin<K, V> {
    No raiz;
    int tamanho = 0;

    public ArvoreBin(K chave, V valor) {
        this.raiz = new No(chave, valor);
        this.tamanho++;
    }


    public No buscarValor(V valor) {
        if (this.raiz.valor.equals(valor))
            return this.raiz;
        Queue<No> nos = new ArrayDeque<>();

        nos.add(this.raiz);
        while (!nos.isEmpty()) {
            No aux = nos.poll();
            if (aux.esquerdo.valor.equals(valor)) {
                return aux.esquerdo;
            } else if (aux.direito.valor.equals(valor)) {
                return aux.direito;
            } else {
                nos.add(aux.esquerdo);
                nos.add(aux.direito);
            }
        }
        return null;
    }

    public No buscarChave(K chave) {
        if (this.raiz.chave.equals(chave))
            return this.raiz;
        Queue<No> nos = new ArrayDeque<>();

        nos.add(this.raiz);
        while (!nos.isEmpty()) {
            No aux = nos.poll();
            if (aux.esquerdo.chave.equals(chave)) {
                return aux.esquerdo;
            } else if (aux.direito.chave.equals(chave)) {
                return aux.direito;
            } else {
                nos.add(aux.esquerdo);
                nos.add(aux.direito);
            }
        }
        return null;
    }

    public void add(K chave, V valor) {
        No novoNo = new No(chave, valor);
        procurarEspaco(novoNo);
        this.tamanho++;
    }

    public No removeChave(K chave) {
        No remover = buscarChave(chave);
        if (remover == null)
            return null;
        remover.pai = null;
        this.tamanho--;
        return remover;
    }

    public No removeValor(V valor) {
        No remover = buscarValor(valor);
        if (remover == null)
            return null;
        remover.pai = null;
        this.tamanho--;
        return remover;
    }

    private void procurarEspaco(No novoNo) {
        Queue<No> nos = new ArrayDeque<>();

        nos.add(this.raiz);
        while (!nos.isEmpty()) {
            No aux = nos.poll();
            if (aux.esquerdo == null) {
                aux.esquerdo = novoNo;
                break;
            } else if (aux.direito == null) {
                aux.direito = novoNo;
                break;
            } else {
                nos.add(aux.esquerdo);
                nos.add(aux.direito);
            }
        }
    }


    public class No<K, V> {
        K chave;
        V valor;
        No esquerdo, direito, pai;

        public No(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

        public K getChave() {
            return chave;
        }

        public void setChave(K chave) {
            this.chave = chave;
        }

        public V getValor() {
            return valor;
        }

        public void setValor(V valor) {
            this.valor = valor;
        }
    }
}
