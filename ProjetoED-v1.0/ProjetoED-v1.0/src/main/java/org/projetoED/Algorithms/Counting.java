package org.projetoED.Algorithms;

import java.util.HashMap;

public class Counting {
    public static void sort(Integer[] array) {
        Integer minimo = array[0];
        Integer maximo = array[0];
        for (Integer valor : array) {
            if (valor < minimo) {
                minimo = valor;
            } else if (valor > maximo) {
                maximo = valor;
            }
        }

        // Subtrair o mínimo de todos os elementos para garantir que todos sejam
        // positivos
        for (int i = 0; i < array.length; i++) {
            array[i] -= minimo;
        }

        // Usar HashMap para contar a ocorrência de cada valor
        HashMap<Integer, Integer> contagem = new HashMap<>();
        for (Integer valor : array) {
            contagem.put(valor, contagem.getOrDefault(valor, 0) + 1);
        }

        // Reconstruir o array original com os valores ordenados
        int index = 0;
        for (int i = 0; i <= maximo - minimo; i++) {
            int count = contagem.getOrDefault(i, 0);
            for (int j = 0; j < count; j++) {
                array[index++] = i + minimo; // Adicionar o mínimo de volta
            }
        }
    }
}
