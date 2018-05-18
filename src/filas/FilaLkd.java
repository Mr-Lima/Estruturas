package filas;

import listas.LkdList;

import java.util.Iterator;

public class FilaLkd<T> implements iFila<T> {

    private LkdList<T> fila;
    private int tamMax;

    public FilaLkd(){
        fila = new LkdList<>();
        tamMax = Integer.MAX_VALUE;
    }

    /**
     * Adiciona um elemento na fila
     *
     * @param elemento Elemento a ser adicionado
     * @return True se conseguiu adicionar
     */
    @Override
    public boolean enfileirar(T elemento) {
        if(tamMax==fila.size())
            throw new IndexOutOfBoundsException("Fila cheia");
        return fila.add(elemento);
    }

    /**
     * Retira e retorna o primeiro elemento da fila
     *
     * @return Proximo da fila
     */
    @Override
    public T desenfileirar() {
        return fila.remove(0);
    }

    @Override
    public T olhar() {
        return fila.get(0);
    }

    @Override
    public T primeiro() {
        return fila.get(0);
    }

    @Override
    public T ultimo() {
        return fila.getLast();
    }

    @Override
    public int tamanho() {
        return fila.size();
    }

    @Override
    public boolean vazio() {
        return fila.size()==0;
    }

    @Override
    public boolean cheio() {
        return tamMax==fila.size();
    }

    @Override
    public boolean contem(T elemento) {
        return fila.contains(elemento);
    }

    @Override
    public void limpar() {
        fila.clear();
    }

    @Override
    public void setTamanhoMaximo(int tamanhoMaximo) {
        this.tamMax = tamanhoMaximo;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public String toString() {
        return fila.toString();
    }
}
