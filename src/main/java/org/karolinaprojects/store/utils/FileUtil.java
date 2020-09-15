package org.karolinaprojects.store.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class FileUtil {

    public static void write(List<String> text, String path) {
        FileWriter writer = null;
        File f = new File(path);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            text.stream().forEach(line -> {
                try {
                    bw.append(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            bw.close();

        } catch (IOException e) {
            out.println(e.getMessage());
        }
    }

    public static void write(String text, String path){
        FileWriter writer = null;
        File f = new File(path);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(f, true));
            bw.append(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> read(String path) {

        List<String> textList = new ArrayList<>();

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                textList.add(scanner.nextLine());
            }
            scanner.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return textList;
    }

}


