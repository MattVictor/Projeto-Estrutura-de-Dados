package org.projetoED;

import com.opencsv.CSVWriter;
import org.projetoED.Algorithms.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//Esse código roda apenas um algoritmo por vez Para que os outros algoritmos
// não sofram pelo desempenho da máquina sendo afetado ao longo do tempo
public class Main {

    public static String algoritmo = "Selection"; //Escolher o Algoritmo (Para deixar registrado no CSV)
    public static String[] arquivos = {
            "1MCrescente",
            "1MDecrescente",
            "1MConstante",
            "1MDesordenado",
            "1MDesordenado10Finais",
            "1MDesordenado10Iniciais",
            "2MCrescente",
            "2MDecrescente",
            "2MConstante",
            "2MDesordenado",
            "2MDesordenado10Finais",
            "2MDesordenado10Iniciais",
            "3MCrescente",
            "3MDecrescente",
            "3MConstante",
            "3MDesordenado",
            "3MDesordenado10Finais",
            "3MDesordenado10Iniciais"
    };

    public static void main(String[] args) {

        ArrayList <Double> tempoDeExecução = new ArrayList<Double>(); //Array dos tempos de Execução
        ArrayList <Long> usoDeMemoria = new ArrayList<Long>(); //Array do uso de memória

        for(String arquivo : arquivos){ //Para cada arquivo txt

            Integer[] array = ArraysTeste.Array(arquivo+".txt");

            long timeBefore = System.nanoTime();

            sortAlgorithm(array);//Rodando o Algortimo de ordenação

            long timeAfter = System.nanoTime();
            long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            tempoDeExecução.add((timeAfter-timeBefore)/ 1000000000.0);
            usoDeMemoria.add(memoryAfter);
            System.out.println(arquivo);
        }

        dataRegister("Resultados"+algoritmo+".csv", tempoDeExecução, usoDeMemoria);
    }

    public static void sortAlgorithm(Integer[] array){
        Selection.sort(array);//Selecione o algoritmo baseado na classe
    }

    public static void dataRegister(String filePath, ArrayList<Double> tempo, ArrayList<Long> memoria){
        //Registrando os resultados em um arquivo .csv
        File file = new File(filePath);
        try {

            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(outputfile);

            String[] header = { "Algortimo", "Array", "Tempo De Execução", "Uso de Memória" };
            writer.writeNext(header);

            for(int i = 0; i < arquivos.length; i++){
                String[] data = {algoritmo, arquivos[i], tempo.get(i).toString(), memoria.get(i).toString()};
                writer.writeNext(data);
            }

            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}