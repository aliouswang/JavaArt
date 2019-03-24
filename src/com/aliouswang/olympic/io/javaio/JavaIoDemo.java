package com.aliouswang.olympic.io.javaio;

import com.aliouswang.olympic.util.Log;

import java.io.*;

public class JavaIoDemo {

    public static void main(String[] args) throws IOException {
        DataOutputStream dataOutputStream =
                new DataOutputStream(new BufferedOutputStream(
                        new FileOutputStream(new File("/Users/aliouswang/Documents/java/JavaArt/"
                        + "outfile.tmp"))
                ));
        dataOutputStream.writeInt(9899);
        dataOutputStream.writeUTF("Hello world!");
        dataOutputStream.flush();
        dataOutputStream.close();


        DataInputStream dataInputStream = new DataInputStream(
                new FileInputStream(new File("/Users/aliouswang/Documents/java/JavaArt/"
                        + "outfile.tmp"))
        );
        Log.d(dataInputStream.readInt() + dataInputStream.readUTF());
    }


}
