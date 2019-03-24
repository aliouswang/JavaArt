package com.aliouswang.olympic.io.javaio;

import com.aliouswang.olympic.util.Log;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class BufferedInputFile {

    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        LinkedList<String> linkedList = new LinkedList<>();
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
            sb.append("\r\n");

            linkedList.add(line);
        }

//        Collections.reverse(linkedList);
//        for (String string : linkedList) {
//            Log.d(string);
//        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String fileString = BufferedInputFile.read("/Users/aliouswang/Documents/java/JavaArt/JavaArt.iml");

        DataInputStream dataInputStream = new DataInputStream(
                new ByteArrayInputStream(fileString.getBytes()));
        char c;
        while (dataInputStream.available() != 0) {
            System.out.print(dataInputStream.readByte());
        }
    }


}
