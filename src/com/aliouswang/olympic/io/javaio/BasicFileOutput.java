package com.aliouswang.olympic.io.javaio;

import java.io.*;

public class BasicFileOutput {

    public static final String TARGET_FILE_NAME = "/Users/aliouswang/Documents/java/JavaArt/JavaArt.iml";
    public static String copyFileName = "outfile.copy";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(TARGET_FILE_NAME));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/aliouswang/Documents/java/JavaArt/" +
                copyFileName));
        String readLine;
        int line = 1;
        while ((readLine = bufferedReader.readLine()) != null) {
            bufferedWriter.write((line++)+ ":" + readLine + "\n");
        }
//        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
