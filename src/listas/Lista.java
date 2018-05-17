package listas;

import java.security.InvalidParameterException;

@SuppressWarnings("unused")
public interface Lista<T> extends Iterable<T> {

    void add(T element);

    void add(T element, int index) throws InvalidParameterException;

    void addBegin(T element);

    void addLast(T element);

    void addAll(T... element);

    void addAll(Iterable<T> lista);

    T get(int index) throws InvalidParameterException;

    T getLast();

    T getElement(T element) throws InvalidParameterException;

    T remove(int index) throws InvalidParameterException;

    boolean remove(T element);

    T removeLastOf() throws InvalidParameterException;

    T removeFirstOf() throws InvalidParameterException;

    boolean contains(T element);

    void clear();

    int size();

    int lenght();

    String toString();


}
