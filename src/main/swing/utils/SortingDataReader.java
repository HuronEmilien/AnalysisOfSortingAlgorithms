package main.swing.utils;

import java.io.*;
import java.nio.file.*;

public class SortingDataReader {

    public String readDataFromJson(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}
