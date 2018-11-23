package Heap;

public class MinHeapTest {
    public static void main(String[] args) {
        MinHeap<Integer, Integer> q = new MinHeap<>(8);
        q.inserir(5, 5);
        q.inserir(2, 2);
        q.inserir(4, 4);
        q.inserir(1, 1);
        q.inserir(7, 7);
        q.inserir(6, 6);
        q.inserir(3, 3);
        q.inserir(8, 8);
        q.print(); // [ 1, 2, 3, 5, 7, 6, 4, 8 ]
        q.ordenarPilha();
        q.print(); // [ 8, 7, 6, 5, 4, 3, 2, 1 ]
    }
}
