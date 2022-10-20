package org.example;

import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestMap {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Map<String, String> hashmap = new HashMap<>();
        hashmap.put("12.12.02", "Rediska1");
        hashmap.put("12.12.03", "Rediska2");
        hashmap.put("12.12.04", "Rediska3");
        hashmap.put("12.12.05", "Rediska4");
        hashmap.put("12.12.06", "Rediska5");
        hashmap.put("12.12.07", "Rediska6");
        hashmap.put("12.12.08", "Rediska7");
        hashmap.put("12.12.09", "Rediska8");

        //   System.out.println(hashmap);

        //Запись в файл
        try {
            File fileTwo = new File("BD.txt");
            FileOutputStream fos = new FileOutputStream(fileTwo);
            PrintWriter pw = new PrintWriter(fos);

            for (Map.Entry<String, String> m : hashmap.entrySet()) {
                pw.println(m.getKey() + "=" + m.getValue());
            }
            pw.flush();
            pw.close();
            fos.close();
        } catch (Exception e) {
            System.out.println("can't write to file");


        }
        HashMap<String, String> mapInFile = null;
        try {
            File toRead = new File("BD.txt");
            FileInputStream fis = new FileInputStream(toRead);

            Scanner sc = new Scanner(fis);

            mapInFile = new HashMap<String, String>();

            //Чтение
            String currentLine;
            while (sc.hasNextLine()) {
                currentLine = sc.nextLine();
                StringTokenizer st = new StringTokenizer(currentLine, "=", false);
                mapInFile.put(st.nextToken(), st.nextToken());
            }
            fis.close();

            for (Map.Entry<String, String> m : mapInFile.entrySet()) {
                System.out.println(m.getKey() + " = " + m.getValue());
            }
        } catch (Exception e) {
            System.out.println("can't create to file");
        }

        System.out.println(mapInFile);
    }
}

