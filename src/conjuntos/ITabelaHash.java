/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import java.security.InvalidParameterException;

/**
 * @author 11645
 */
public interface ITabelaHash<K, V> extends Iterable<V> {
    V inserir(K chave, V valor) throws InvalidParameterException;

    V buscar(K chave);

    V remover(K chave);

    int tamanho(); //qtdElementos

    boolean vazio();

    void limpar();

    boolean contem(V valor);
}
