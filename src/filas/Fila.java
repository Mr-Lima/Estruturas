package filas;

import java.util.Iterator;

public class Fila<T> implements iFila<T> {
    /** Tamanho maximo */
    private int tamMax;
    /** Vetor da fila */
    private T[] filaVetor;
    /** Frente da fila */
    private int frente;
    /** Fundo da fila */
    private int fundo;
    /** Numero de itens */
    private int nItens;

    /**
     *
     * @param tamanho Tamanho da nova fila
     */
    public Fila(int tamanho){
        tamMax = tamanho;
        filaVetor = (T[]) new Object[tamanho];
        frente = 0;
        fundo = -1;
        nItens = 0;
    }

    public Fila(){
        this(10);
    }

    /**
     * Insere um elemento ao fundo da fila
     *
     * @param elemento Elemento para ser adicionado
     * @return True se o elemento foi adicionado
     */
    @Override
    public boolean enfileirar(T elemento) {
        if(cheio())
            return false;
        if(fundo == tamMax-1)//Se o fundo da fila é o fim do vetor
            redimencionar(tamMax*2);
        fundo++;
        filaVetor[fundo] = elemento;
        nItens++;
        return true;
    }

    /**
     * Remove um elemento da frente da fila
     *
     * @return True se foi removido com sucesso
     */
    @Override
    public T desenfileirar() {
        if(vazio()){
            throw new NullPointerException("Fila esta vazia");
        }
        T temp = filaVetor[frente];
        filaVetor[frente] = null;
        frente++;
        if(frente == tamMax) //Wrap-Around
            frente = 0;
        nItens--;
        return temp;
    }

    @Override
    public T olhar() {
        return primeiro();
    }

    /**
     * Olha para o primeiro elemento da fila
     *
     * @return Primeiro elemento da fila
     */
    @Override
    public T primeiro() {
        return filaVetor[frente];
    }

    /**
     * Olha para o ultimo elemento da fila
     *
     * @return Ultimo elemento da fila
     */
    @Override
    public T ultimo() {
        return filaVetor[fundo];
    }

    /**
     *
     * @return Numero de itens
     */
    @Override
    public int tamanho() {
        return nItens;
    }

    /**
     *
     * @return true se fila vazia
     */
    @Override
    public boolean vazio() {
        return (nItens==0);
    }

    /**
     *
     * @return true se fila cheia
     */
    @Override
    public boolean cheio(){
        return (nItens == tamMax);
    }

    /**
     * Verifica se o elemento existe na fila
     *
     * @param elemento Elemento a verificar
     * @return True se o elemento existe na fila
     */
    @Override
    public boolean contem(T elemento) {
        for (T aFilaVetor : filaVetor) {
            if (aFilaVetor.equals(elemento))
                return true;
        }
        return false;
    }

    /**
     * Todas as posições da fila assumem null
     */
    @Override
    public void limpar() {
        filaVetor = (T[]) new Object[tamMax];
        frente = 0;
        fundo = -1;
        nItens = 0;
    }

    /**
     * Redefine o tamanho maximo da fila
     * @param tamanhoMaximo Tamanho desejado
     */
    @Override
    public void setTamanhoMaximo(int tamanhoMaximo) {
        tamMax = tamanhoMaximo;
    }

    private void redimencionar(int novoTamanho){
        T[] vetorTemp = (T[]) new Object[novoTamanho];
        for(int i = 0; i < filaVetor.length; i++){
            vetorTemp[i] = filaVetor[i];
            filaVetor = vetorTemp;
        }
        tamMax = novoTamanho;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorFila();
    }

    private class IteratorFila implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < filaVetor.length && filaVetor[currentIndex] != null;
        }

        @Override
        public T next() {
            return filaVetor[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
