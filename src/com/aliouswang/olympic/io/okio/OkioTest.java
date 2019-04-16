package com.aliouswang.olympic.io.okio;

import okio.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OkioTest {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/aliouswang/Documents/java/JavaArt/JavaArt.iml");
        Source source = Okio.source(file);
        BufferedSource bufferedSource = Okio.buffer(source);
        File newFile = new File("/Users/aliouswang/Documents/java/JavaArt/JavaArt.temp");
        Sink sink = Okio.sink(newFile);
        BufferedSink bufferedSink = Okio.buffer(sink);
        int read = -1;
        byte[] bytes = new byte[1024];
        Buffer buffer = new Buffer();
        while (bufferedSource.read(bytes) != -1) {
            bufferedSink.write(bytes);
//            sink.write(buffer, read);
            bufferedSink.flush();
        }
//        bufferedSink.flush();
//        sink.flush();

    }

}
