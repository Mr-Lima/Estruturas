/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author 11645
 */
public interface iPilha<T> extends Iterable<T>{
    public void empilhar(T elemento);
    public T desempilhar();
    public T topo();
    public int tamanho();
    public boolean contem(T elemento);
    public void limpar();
    public boolean vazia();
}
