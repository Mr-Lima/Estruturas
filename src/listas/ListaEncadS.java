package listas;

import java.security.InvalidParameterException;
import java.util.Iterator;

public class ListaEncadS<T> implements Lista<T> {

    private No<T> head;
    private No<T> tail;
    private int count = 0;

    public ListaEncadS() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void add(T element) {
        if (count == 0) {
            this.addBegin(element);
        } else {
            No<T> novo = new No<>(element);
            this.tail.setNext(novo);
            this.tail = novo;
            this.count++;
        }
    }

    @Override
    public void add(T element, int index) throws InvalidParameterException {
        if (index == 0) {
            this.addBegin(element);
        } else if (index == this.count) {
            this.add(element);
        } else {
            No<T> novo = new No<>(element);
            novo.setNext(this.getNo(index - 1).getNext());
            this.getNo(index - 1).setNext(novo);
            this.count++;
        }
    }

    @Override
    public void addBegin(T element) {
        No<T> novo = new No(this.head, element);
        this.head = novo;
        if (this.count == 0)
            this.tail = novo;
        this.count++;
    }

    @Override
    public void addLast(T element) {
        this.add(element);
    }

    @Override
    public void addAll(T... element) {
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
        return this.getNo(index).getElement();
    }

    @Override
    public T getLast() {
        return this.tail.getElement();
    }

    @Override
    public T getElement(T element) throws InvalidParameterException {
        No<T> aux = this.head;
        for (int i = 0; i <= count - 1; i++) {
            if (aux.getElement().equals(element)) {
                return aux.getElement();
            }
            aux = aux.getNext();
        }
        throw new InvalidParameterException("Valor não existe");
    }

    @Override
    public T remove(int index) throws InvalidParameterException {
        if (!isValid(index)) throw new InvalidParameterException("Index invalidado");
        if (index == 0) {
            this.removeFirstOf();
        } else if (index == this.count - 1) {
            this.removeLastOf();
        } else {
            No<T> pre = this.getNo(index - 1);
            No<T> current = pre.getNext();
            T element = current.getElement();
            No<T> next = current.getNext();

            pre.setNext(next);
            this.count--;
            return element;
        }
        return null;
    }

    @Override
    public boolean remove(T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T removeLastOf() throws InvalidParameterException {
        if (!this.isValid(this.count - 1)) throw new InvalidParameterException("Posicao nao existe");
        if (this.count == 1) {
            this.removeFirstOf();
        } else {
            No<T> pre = this.getNo(this.count - 2);
            T element = (T) pre.getNext().getElement();
            pre.setNext(null);
            this.tail = pre;
            this.count--;
            return element;
        }
        return null;
    }

    @Override
    public T removeFirstOf() throws InvalidParameterException {
        if (!this.isValid(0)) throw new InvalidParameterException("Lista vazia");
        T element = this.head.getElement();
        this.head = this.head.getNext();
        this.count--;
        if (this.count == 0) this.tail = null;
        return element;
    }

    @Override
    public boolean contains(T element) {
        No<T> current = this.head;

        while (current != null) {
            if (current.getElement().equals(element))
                return true;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = this.head;
        this.count = 0;
    }

    @Override
    public int size() {
        return this.lenght();
    }

    @Override
    public int lenght() {
        return this.count;
    }

    @Override
    public String toString() {
        if (this.count == 0)
            return "[]";

        StringBuilder builder = new StringBuilder("[");
        No<T> current = this.head;
        for (int i = 0; i < this.count - 1; i++) {
            builder.append(current.getElement());
            builder.append(", ");
            current = current.getNext();
        }
        builder.append(current.getElement());
        builder.append("]");

        return builder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorEncad();
    }

    private boolean isValid(int index) {
        return index >= 0 && index < this.count;
    }

    private No<T> getNo(int index) {
        if (!this.isValid(index))
            throw new IllegalArgumentException("Index nao existe");

        No<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    private class IteratorEncad implements Iterator<T> {

        No<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T element = current.getElement();
                current = current.getNext();
                return element;
            }
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class No<T> {
        private No next;
        private T element;

        public No(No next) {
            this.next = next;
        }

        public No(T element) {
            this.element = element;
        }

        public No(No next, T element) {
            this.next = next;
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public No getNext() {
            return next;
        }

        public void setNext(No next) {
            this.next = next;
        }
    }
}


