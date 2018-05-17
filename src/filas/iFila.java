/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filas;

/**
 *
 * @author 11645
 */
public interface iFila<T> extends Iterable<T>{
    boolean enfileirar(T elemento);
    T desenfileirar();
    T olhar();
    T primeiro();
    T ultimo();
    int tamanho();
    boolean vazio();
    boolean cheio();
    boolean contem(T elemento);
    void limpar();
    void setTamanhoMaximo(int tamanhoMaximo);
}
