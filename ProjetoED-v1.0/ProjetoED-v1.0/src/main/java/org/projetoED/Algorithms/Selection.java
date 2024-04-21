package org.projetoED.Algorithms;

public class Selection {
    public static void sort(Integer[] array) {
        Integer[] a = array;
        int n = a.length;
        for (int j = 0; j < n - 1; j++) {
            int min_index = j;
            for (int i = j; i < n; i++) {
                if (a[i] < a[min_index]) {
                    min_index = i;
                }
            }
            Integer aux = a[min_index];
            a[min_index] = a[j];
            a[j] = aux;
        }
    }
}
