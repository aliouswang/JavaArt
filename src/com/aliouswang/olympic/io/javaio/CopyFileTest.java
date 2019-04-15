package com.aliouswang.olympic.io.javaio;

import com.aliouswang.olympic.util.Log;
import okio.*;

import javax.swing.text.Segment;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFileTest {

    public static final String BASE_PATH = "/Users/aliouswang/Desktop/test/";

    public static void main(String[] args) throws IOException {
        //parpare

        long time = System.currentTimeMillis();
        copyWithFile();
        Log.d("FileInputStream take time:" + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();

        copyWithBuffer();
        Log.d("BufferedInputStream take time:" + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();

        copyWithNIO();
        Log.d("nio take time:" + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();

        copyWithNioDirect();
        Log.d("nio direct take time:" + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();

        copyOkio();
        Log.d("okio take time:" + (System.currentTimeMillis() - time));
    }

    public static void copyWithFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(BASE_PATH + "WPS2019.dmg"));
        FileOutputStream fileOutputStream = new FileOutputStream(
                new File(BASE_PATH + "wps.copy1")
        );
        byte[] bytes = new byte[1024];
        int read = 0;
        while ((read = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes,0 ,read);
        }
        fileOutputStream.flush();

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void copyWithBuffer() throws IOException{
        BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(new File(BASE_PATH + "WPS2019.dmg")));
        BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(
                new File(BASE_PATH + "wps.copy2")
        ));
        byte[] bytes = new byte[8192];
        int read = 0;
        while ((read = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, read);
        }
        fileOutputStream.flush();

        fileInputStream.close();
        fileOutputStream.close();
    }

    public static void copyWithNIO() throws IOException{
        FileChannel fileChannel = new FileInputStream(new File(BASE_PATH + "WPS2019.dmg"))
                .getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        FileChannel fileChannel2 = new FileOutputStream(
                new File(BASE_PATH + "wps.copy3")
        ).getChannel();
        while ((fileChannel.read(buffer)) != -1) {
            buffer.flip();
            fileChannel2.write(buffer);
            buffer.clear();
        }

    }

    public static void copyWithNioDirect() throws IOException{
        FileChannel fileChannel = new FileInputStream(new File(BASE_PATH + "WPS2019.dmg"))
                .getChannel();
        FileChannel fileChannel2 = new FileOutputStream(
                new File(BASE_PATH + "wps.copy4")
        ).getChannel();
        fileChannel.transferTo(0, fileChannel.size(), fileChannel2);
    }

    public static void copyOkio() throws IOException {
        copyWithOkio2();
    }

    public static void copyWithOkio() throws IOException{
        Source source = null;
        Sink sink = null;
        try {
            File file = new File(BASE_PATH + "WPS2019.dmg");
            source = Okio.source(file);
            sink = Okio.sink(new File(BASE_PATH + "wps.cop5"));
            Buffer buffer = new Buffer();
            int read = 0;
            while ((read = (int) source.read(buffer, 1024)) != -1) {
                sink.write(buffer, read);
                sink.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sink.close();
            source.close();
        }
    }

    public static void copyWithOkio2() throws IOException {
        File file = new File(BASE_PATH + "WPS2019.dmg");
        BufferedSource source = Okio.buffer(Okio.source(file));
        BufferedSink sink = Okio.buffer(Okio.sink(new File(BASE_PATH + "wps.copy6")));
        byte[] bytes = new byte[1024];
        int read = 0;
        while ((read = source.read(bytes)) != -1) {
            sink.write(bytes, 0, read);
        }
        sink.flush();
    }

    private static void caculateBufferSegmentSize(BufferedSink bufferedSink) {
        Buffer buffer = bufferedSink.buffer();

    }

}
