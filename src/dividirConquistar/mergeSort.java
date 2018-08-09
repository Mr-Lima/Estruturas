package dividirConquistar;

import java.util.Arrays;

@SuppressWarnings("ALL")
public class mergeSort {

    public static void main(String[] args) {
        int[] vetor = {9, 5, 7, 2, 3, 1, 6};
        int[] aux = new int[vetor.length];

        mergeSort(vetor, aux, 0, vetor.length - 1);
        System.out.println(Arrays.toString(vetor));
    }

    public static void mergeSort(int[] vetor, int[] aux, int ini, int fim) { //O( n log n)
        if (ini < fim) {
            int meio = (ini + fim) / 2;
            mergeSort(vetor, aux, ini, meio);
            mergeSort(vetor, aux, meio + 1, fim);
            merge(vetor, aux, ini, meio, fim);
        }
    }

    private static void merge(int[] vetor, int[] aux, int ini, int meio, int fim) {
        System.arraycopy(vetor, ini, aux, ini, fim + 1 - ini);

        int i = ini;
        int j = meio + 1;

        for (int k = ini; k <= fim; k++) {
            if (i > meio) vetor[k] = aux[j++];
            else if (j > fim) vetor[k] = aux[i++];
            else if (aux[i] < aux[j]) vetor[k] = aux[i++];
            else vetor[k] = aux[j++];
        }
    }

}
