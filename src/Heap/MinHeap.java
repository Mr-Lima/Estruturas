package Heap;

import java.util.Iterator;

public class MinHeap<K extends Comparable<K>, V> implements Iterable<V> {

    private No[] elementos;
    private int capacidade, qtdElemts = 0;

    public MinHeap(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Argumento invalido: " + capacity + "Somente numeros maiores que 0");

        this.capacidade = capacity;
        this.elementos = (No[]) new Object[this.capacidade + 1];
    }

    public boolean inserir(K chave, V valor){
        if (this.cheio())
            return false;
        this.elementos[this.qtdElemts + 1] = new No(chave, valor);
        int k = this.qtdElemts + 1;
        while (k > 1) {
            if (this.elementos[k].compareTo(this.elementos[k/2]) < 0) {
                No temp = this.elementos[k];
                this.elementos[k] = this.elementos[k / 2];
                this.elementos[k / 2] = temp;
            }
            k = k / 2;
        }
        this.qtdElemts++;
        return true;
    }

    public boolean vazio() {
        if (0 == this.qtdElemts)
            return true;
        return false;
    }

    private boolean cheio() {
        if (this.qtdElemts == this.capacidade)
            return true;
        return false;
    }

    public K olhar() {
        return this.elementos[1].chave;
    }

    public void print() {
        for (int i = 1; i <= this.capacidade; i++)
            System.out.print(this.elementos[i] + " ");
        System.out.println();
    }

    public void ordenarPilha() {
        for (int i = 1; i < this.capacidade; i++)
            this.remover();
    }

    private void sink() {
        int k = 1;
        while (2 * k <= this.qtdElemts || 2 * k + 1 <= this.qtdElemts) {
            int minIndex;
            if (this.elementos[2 * k].compareTo(this.elementos[k]) >= 0) {
                if (2 * k + 1 <= this.qtdElemts && this.elementos[2 * k + 1].compareTo(this.elementos[k]) >= 0) {
                    break;
                } else if (2 * k + 1 > this.qtdElemts) {
                    break;
                }
            }
            if (2 * k + 1 > this.qtdElemts) {
                minIndex = this.elementos[2 * k].compareTo((this.elementos[k])) < 0 ? 2 * k : k;
            } else {
                if (this.elementos[k].compareTo(this.elementos[2 * k]) >  0 || this.elementos[k].compareTo(this.elementos[2 * k + 1]) > 0) {
                    minIndex = this.elementos[2 * k].compareTo(this.elementos[2 * k + 1]) < 0 ? 2 * k : 2 * k + 1;
                } else {
                    minIndex = k;
                }
            }
            No temp = this.elementos[k];
            this.elementos[k] = this.elementos[minIndex];
            this.elementos[minIndex] = temp;
            k = minIndex;
        }
    }

    public K remover() {
        No min = this.elementos[1];
        this.elementos[1] = this.elementos[this.qtdElemts];
        this.elementos[this.qtdElemts] = min;
        this.qtdElemts--;
        this.sink();
        return min.chave;
    }

    @Override
    public Iterator<V> iterator() {
        return null;
    }

    private class No implements Comparable<No> {
        K chave;
        V valor;

        public No(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

        @Override
        public int compareTo(No o) {
            return this.chave.compareTo(o.chave);
        }
    }
}
