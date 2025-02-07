package main.swing.utils;

import java.io.*;

public class SortingDataWriter {

    public void writeDataToJson(String generatorName, String algorithmName, int SortSize, int comparisons, int arrayAccesses,int set, int swap, long delay, int[][] pourcent) {
        // Construire le JSON manuellement
            String json = "{\n" +
                    "  \"history\": {\n";
            for (int i = 0; i < pourcent.length; i++) {
                json += "  \""+((i+1)*10)+"\":  {\n" +
                        "      \"correct\": " + pourcent[i][0] + ",\n" +
                        "      \"set\": " + pourcent[i][1] + ",\n" +
                        "      \"swap\": " + pourcent[i][2] + ",\n" +
                        "      \"arrayAccess\": " + pourcent[i][3] + ",\n" +
                        "      \"comparaison\": " + pourcent[i][4] + ",\n" +
                        "      \"delay\": " + pourcent[i][5] + "\n";
                if (i == pourcent.length - 1) {
                    json += "    }\n";
                } else {
                    json += "    },\n";
                }
            }
            json += "  },\n" +
                    "  \"global\": {\n" +
                    "    \"algorithm\": \"" + algorithmName + "\",\n" +
                    "    \"comparaisons\": " + comparisons + ",\n" +
                    "    \"arrayAccess\": " + arrayAccesses + ",\n" +
                    "    \"set\": " + set + ",\n" +
                    "    \"swap\": " + swap + ",\n" +
                    "    \"delay\": " + delay + "\n" +
                    "  }\n" +
                    "}";



        // Écrire le JSON dans un fichier
        try (FileWriter writer = new FileWriter("src/main/web/resources/data/json/"+generatorName+"/"+SortSize+"/"+algorithmName+".json")) {
            writer.write(json);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture du fichier JSON : " + e.getMessage());
        }
    }
}
