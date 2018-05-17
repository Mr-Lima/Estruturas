package listas;

import java.security.InvalidParameterException;
import java.util.Iterator;

@SuppressWarnings("unused")
public class VetorLista<T> implements Lista<T> {

    private T[] elements;
    private int capacity, qtdElmts = 0;

    public VetorLista() {
        this(10);
    }

    public VetorLista(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Argumento invalido: " + capacity + "Somente numeros maiores que 0");

        this.capacity = capacity;
        this.elements = (T[]) new Object[this.capacity];
    }

    @Override
    public void add(T element) {
        // TODO Auto-generated method stub
        expand();
        this.elements[this.qtdElmts] = element;
        this.qtdElmts++;
    }

    @Override
    public void add(T element, int index) throws InvalidParameterException {
        // TODO Auto-generated method stub
        expand();
        if (!isValidIndex(index))
            throw new InvalidParameterException("Posicao invalida");

        for (int i = this.qtdElmts - 1; i >= index; i--) {
            this.elements[i + 1] = this.elements[i];
        }

        this.elements[index] = element;
        this.qtdElmts++;
    }

    @Override
    public void addBegin(T element) {
        // TODO Auto-generated method stub
        expand();
        for (int i = this.qtdElmts - 1; i >= 0; i--) {
            this.elements[i + 1] = this.elements[i];
        }

        this.elements[0] = element;
        this.qtdElmts++;
    }

    @Override
    public void addLast(T element) {
        // TODO Auto-generated method stub
        expand();
        this.elements[this.qtdElmts] = element;
        this.qtdElmts++;
    }

    @Override
    public void addAll(T... element) {
        // TODO Auto-generated method stub
        for (T aux : element) {
            this.add(aux);
        }

    }

    @Override
    public void addAll(Iterable<T> lista) {
        for (T aux :
                lista) {
            this.add(aux);
        }
    }

    @Override
    public T get(int index) throws InvalidParameterException {
        // TODO Auto-generated method stub
        if (!isOccupied(index)) {
            throw new InvalidParameterException("Posicao invalida");
        } else
            return this.elements[index];
    }

    @Override
    public T getLast() {
        return this.get(qtdElmts - 1);
    }

    @Override
    public T getElement(T element) throws InvalidParameterException {
        for (int i = 0; i < qtdElmts; i++) {
            if (this.elements[i].equals(element)) {
                return element;
            }
        }
        throw new InvalidParameterException();
    }

    @Override
    public T remove(int index) throws InvalidParameterException {
        // TODO Auto-generated method stub
        T aux = this.elements[index];
        for (int i = index; i < this.qtdElmts - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.qtdElmts--;
        return aux;
    }

    public boolean remove(T object) throws InvalidParameterException {
        if (this.contains(object)) {
            for (int i = 0; i < this.size(); i++) {
                if (object.equals(this.elements[i])) {
                    this.remove(i);
                    return true;
                }
            }
        }
        throw new InvalidParameterException("Objeto nao encontrado");
    }

    @Override
    public T removeLastOf() throws InvalidParameterException {
        // TODO Auto-generated method stub
        T aux = this.elements[this.qtdElmts - 1];
        this.elements[this.qtdElmts - 1] = null;
        this.qtdElmts--;
        return aux;
    }

    @Override
    public T removeFirstOf() throws InvalidParameterException {
        // TODO Auto-generated method stub
        T aux = this.elements[0];
        for (int i = 0; i < this.qtdElmts - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.qtdElmts--;
        return aux;
    }

    @Override
    public boolean contains(T element) {
        // TODO Auto-generated method stub
        for (int i = 0; i < this.qtdElmts; i++) {
            if (element == this.elements[i])
                return true;
        }

        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        this.elements = null;
        this.capacity = 0;
        this.qtdElmts = 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return this.qtdElmts;
    }

    @Override
    public int lenght() {
        // TODO Auto-generated method stub
        return this.qtdElmts;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        if (this.qtdElmts == 0)
            return "[]";

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < this.qtdElmts - 1; i++) {
            builder.append(this.elements[i]);
            builder.append(", ");
        }
        builder.append(this.elements[this.qtdElmts - 1]);
        builder.append("]");
        return builder.toString();
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= this.qtdElmts;
    }

    private boolean isOccupied(int index) {
        return index >= 0 && index < this.qtdElmts;
    }

    private void expand() {
        if (this.qtdElmts == this.capacity) {
            T[] aux = (T[]) new Object[this.capacity * 2];
            for (int i = 0; i < this.capacity; i++) {
                aux[i] = this.elements[i];
            }
            this.capacity = this.capacity * 2;
            this.elements = aux;
        }
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new IteratorVetor();
    }

    private class IteratorVetor implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return currentIndex < elements.length && elements[currentIndex] != null;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            return elements[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
