package org.projetoED.Algorithms;

public class Merge {
    public static Integer[] sort(Integer[] array) {
        Integer[] a = array;
        // caso base da recursao
        if (a.length == 1) {
            return a;
        } else {
            Integer[] left;
            Integer[] right;
            Integer[] sorted;

            // dividindo lista ao meio
            Integer middle = (int) (a.length / 2);
            left = new Integer[middle];

            // caso seja impar, a direita tera 1 elemento a mais
            if (a.length % 2 == 0) {
                right = new Integer[middle];
            } else {
                right = new Integer[middle + 1];
                // colocando elem. extra na ultima posicao
                right[middle] = a[a.length - 1];
            }

            // colocando elementos nas listas
            for (int i = 0; i < middle; i++) {
                left[i] = a[i];
                right[i] = a[i + middle];
            }

            // lista resultante com o tamanho da original
            sorted = new Integer[a.length];

            // recursao: usando merge nas listas menores
            Integer[] leftSorted = sort(left);
            Integer[] rightSorted = sort(right);

            int c = 0, i = 0, j = 0;
            while (i < leftSorted.length && j < rightSorted.length) {

                // comparando pares de elementos nas duas listas
                if (leftSorted[i] < rightSorted[j]) {

                    // caso esquerda seja menor, ele e colocado na resposta
                    // e o ponteiro da esquerda avanca
                    sorted[c] = leftSorted[i];
                    i++;
                } else {
                    // caso direito seja menor, ele e colocado
                    sorted[c] = rightSorted[j];
                    j++;
                }
                c++; // o contador da lista ordenada sempre avanca
            }

            // uma das listas sempre termina antes, o resto
            // da outra lista e colocado no final
            for (; i < leftSorted.length; i++) {
                sorted[c] = leftSorted[i];
                c++;
            }
            // como a outra lista estara vazia, um dos For nao executa
            // mas a checagem das duas precisa ser feita
            for (; j < rightSorted.length; j++) {
                sorted[c] = rightSorted[j];
                c++;
            }

            return sorted;
        }

    }
}
