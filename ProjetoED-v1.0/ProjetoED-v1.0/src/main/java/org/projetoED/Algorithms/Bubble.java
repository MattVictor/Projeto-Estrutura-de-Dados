package org.projetoED.Algorithms;

public class Bubble {
    public static void sort(Integer[] array) {
        boolean hasSwap = false;
        for (int i = array.length-1; i >= 0; i--) {
            for (int j = 1; j < i; j++) {
                hasSwap = false;
                System.out.println(array[j]);
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    hasSwap = true;
                }
            }
            if(!hasSwap){
                break;
            }
        }
    }
}
