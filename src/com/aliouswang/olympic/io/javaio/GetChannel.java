package com.aliouswang.olympic.io.javaio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {

    private static final int BSIZE = 1024;
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/aliouswang/Documents/java/JavaArt/data.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/aliouswang/Documents/java/JavaArt/data.txt"));
        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.wrap("Hello NIO!".getBytes());
        fileChannel.write(buffer);

        fileChannel = new RandomAccessFile("/Users/aliouswang/Documents/java/JavaArt/data.txt", "rw").getChannel();
        fileChannel.position(fileChannel.size());

        fileChannel.write(ByteBuffer.wrap("\nWrite by RandomAccessFile!".getBytes()));

        fileChannel = new FileInputStream(new File("/Users/aliouswang/Documents/java/JavaArt/data.txt")).getChannel();

        ByteBuffer buffer1 = ByteBuffer.allocate(BSIZE);
        fileChannel.read(buffer1);

        buffer1.flip();

        while (buffer1.hasRemaining()) {
            System.out.print((char)(buffer1.get()));
        }

    }

}
