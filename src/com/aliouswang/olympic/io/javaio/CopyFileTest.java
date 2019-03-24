package com.aliouswang.olympic.io.javaio;

import com.aliouswang.olympic.util.Log;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFileTest {

    public static final String BASE_PATH = "/Users/aliouswang/Desktop/test/";

    public static void main(String[] args) throws IOException {
        //parpare


        long time = System.currentTimeMillis();
        copyWithFile();
        Log.d("time:" + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();

        copyWithBuffer();
        Log.d("time:" + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();

        copyWithNIO();
        Log.d("time:" + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();

        copyWithNioDirect();
        Log.d("time:" + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
    }

    public static void copyWithFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(BASE_PATH + "ideaI.dmg"));
        FileOutputStream fileOutputStream = new FileOutputStream(
                new File(BASE_PATH + "ideal.copy1")
        );
        byte[] bytes = new byte[1024];
        int read = 0;
        while ((read = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(read);
        }
        fileOutputStream.flush();

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void copyWithBuffer() throws IOException{
        BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(new File(BASE_PATH + "ideaI.dmg")));
        BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(
                new File(BASE_PATH + "ideal.copy2")
        ));
        byte[] bytes = new byte[1024];
        int read = 0;
        while ((read = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(read);
        }
        fileOutputStream.flush();

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void copyWithNIO() throws IOException{
        FileChannel fileChannel = new FileInputStream(new File(BASE_PATH + "ideaI.dmg"))
                .getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        FileChannel fileChannel2 = new FileOutputStream(
                new File(BASE_PATH + "ideaI.copy3")
        ).getChannel();
        while ((fileChannel.read(buffer)) != -1) {
            buffer.flip();
            fileChannel2.write(buffer);
            buffer.clear();
        }

    }

    public static void copyWithNioDirect() throws IOException{
        FileChannel fileChannel = new FileInputStream(new File(BASE_PATH + "ideaI.dmg"))
                .getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        FileChannel fileChannel2 = new FileOutputStream(
                new File(BASE_PATH + "ideaI.copy4")
        ).getChannel();
        while ((fileChannel.read(buffer)) != -1) {
            buffer.flip();
            fileChannel2.write(buffer);
            buffer.clear();
        }
    }

}
