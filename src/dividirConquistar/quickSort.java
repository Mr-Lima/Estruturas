package dividirConquistar;

import java.util.Arrays;

public class quickSort {

    public static void main(String[] args) {
        int[] vetor = {9, 5, 7, 2, 3, 1, 6};
        quickSort(vetor, 0, vetor.length - 1);
        System.out.println(Arrays.toString(vetor));
    }

    private static void quickSort(int[] vetor, int esq, int dir) {// O( n log n)
        if (esq < dir) {
            int j = separar(vetor, esq, dir);
            quickSort(vetor, esq, j - 1);
            quickSort(vetor, j + 1, dir);
        }
    }

    private static int separar(int[] vetor, int esq, int dir) {
        int i = esq, j = dir;

        while (i < j) {
            while (i < dir && vetor[i] <= vetor[esq]) i++;
            while (j > esq && vetor[j] >= vetor[esq]) j--;
            if (i < j) {
                trocar(vetor, i, j);
                i++;
                j--;
            }
        }
        trocar(vetor, esq, j);
        return j;
    }

    private static void trocar(int[] vetor, int i, int j) {
        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }

}
