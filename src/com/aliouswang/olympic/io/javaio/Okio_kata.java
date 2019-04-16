package com.aliouswang.olympic.io.javaio;

import okio.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Okio_kata {

    public static void main(String[] args) throws IOException {
//        File file = new File("/Users/aliouswang/Documents/olympic/JavaArt//text.temp");
        File file = new File("/Users/aliouswang/Documents/java/JavaArt/text.temp");
        Sink sink = Okio.sink(file);
        BufferedSink bufferedSink = Okio.buffer(sink);

//        Buffer buffer = new Buffer();
        bufferedSink.writeString("Hello okio!", Charset.forName("UTF-8"));
        bufferedSink.writeInt(998);
        bufferedSink.writeByte(1);
        bufferedSink.writeLong(System.currentTimeMillis());
        bufferedSink.writeUtf8("Hello end!");

//        sink.write(buffer, buffer.size());

//        sink.flush();

//        sink.close();
        bufferedSink.close();

        Source source = Okio.source(file);
        BufferedSource bufferedSource = Okio.buffer(source);

//        buffer.clear();

//        source.read(buffer, 1024);

        String string = bufferedSource.readString("Hello okio!".length(), Charset.forName("UTF-8"));
        int intValue = bufferedSource.readInt();
        byte byteValue = bufferedSource.readByte();
        long longValue = bufferedSource.readLong();
        String utf8 = bufferedSource.readUtf8();

        System.out.println("str:" + string + ";\nint:" + intValue + ";\nbyte:" + byteValue + ";" +
                "\nlong:" + longValue + "\nutf8:" + utf8);

        source.close();
    }

}
