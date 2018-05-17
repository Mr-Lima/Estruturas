package pilhas;

import java.util.Iterator;

public class Pilha<T> implements iPilha<T>  {
    /** Tamanho maximo da pilha */
    private int tamMax;
    /** Vetor da pilha */
    private T[] pilhaVetor;
    /** Topo da pilha */
    private int topo;


    /**
     * Construtor
     *
     * @param tamanho Size of the Stack
     */
    public Pilha(int tamanho){
        tamMax = tamanho;
        pilhaVetor = (T[]) new Object[tamMax];
        topo = -1;
    }

    /**
     * Adiciona um elemento ao topo da pilha
     *
     * @param elemento Elemento a ser adicionado
     */
    @Override
    public void empilhar(T elemento) {
        if(!cheia()){ //Checa se nao esta cheia
            topo++;
            pilhaVetor[topo] = elemento;
        }else{
            redimencionar(tamMax*2);
            empilhar(elemento);
        }
    }

    /**
     * Remove e retorna o elemento do topo da pilha
     *
     * @return Elemento desempilhado
     */
    @Override
    public T desempilhar() {
        if(!vazia()){ //Checa se nao esta vazia
            return pilhaVetor[topo--];
        }

        if(topo < tamMax/4){
            redimencionar(tamMax/2);
            return desempilhar();
        }
        else{
            throw new NullPointerException("Pilha ja esta vazia");
        }
    }

    @Override
    public T topo() {
        if(!vazia()){
            return pilhaVetor[topo];
        }else{
            throw new NullPointerException("Pilha vazia");
        }
    }

    @Override
    public int tamanho() {
        int temp = 0;
        for (T aPilhaVetor : pilhaVetor) {
            if (aPilhaVetor.equals(null))
                temp++;
        }
        return temp;
    }

    @Override
    public boolean contem(T elemento) {
        for (int i = 0; i < pilhaVetor.length; i++) {
            if(pilhaVetor[i].equals(elemento))
                return true;
        }
        return false;
    }

    @Override
    public void limpar() {
        pilhaVetor = (T[]) new Object[tamMax];
        topo = -1;
    }

    @Override
    public boolean vazia() {
        return(topo == -1);
    }

    @Override
    public boolean cheia() {
        return(topo+1 == tamMax);
    }

    private void redimencionar(int novoTamanho){
        T[] vetorTemp = (T[]) new Object[novoTamanho];
        for(int i = 0; i < pilhaVetor.length; i++){
            vetorTemp[i] = pilhaVetor[i];
            pilhaVetor = vetorTemp;
        }
        tamMax = novoTamanho;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


}
