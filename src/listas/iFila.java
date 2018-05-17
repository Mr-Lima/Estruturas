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
public interface iFila<T> extends Iterable<T>{
    public void enfileirar(T elemento);
    public T desenfileirar();
    public T primeiro();
    public T ultimo();
    public int tamanho();
    public boolean vazio();
    public boolean contem();
    public void limpar();
    public void setTamanhoMaximo(int tamanhoMaximo);
}
