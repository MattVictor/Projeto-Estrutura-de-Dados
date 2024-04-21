package org.projetoED.Algorithms;

public class Insertion {
    public static void sort(Integer[] array) {
        Integer[] a = array;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {

                int pointer = i;
                while (pointer > 0 && a[pointer - 1] > a[pointer]) {

                    int temp = a[pointer];
                    a[pointer] = a[pointer - 1]; // swap
                    a[pointer - 1] = temp;

                    pointer--;
                }
            }
        }
    }
}
