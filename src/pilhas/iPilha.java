/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilhas;

/**
 *
 * @author 11645
 */
public interface iPilha<T> extends Iterable<T>{
    void empilhar(T elemento);
    T desempilhar();
    T topo();
    int tamanho();
    boolean contem(T elemento);
    void limpar();
    boolean vazia();
    boolean cheia();
}
