package com.aliouswang.olympic.io.javaio;

import okio.Buffer;
import okio.Okio;
import okio.Sink;
import okio.Source;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Okio_kata {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/aliouswang/Documents/olympic/JavaArt//text.temp");
        Sink sink = Okio.sink(file);

        Buffer buffer = new Buffer();
        buffer.writeString("Hello okio!", Charset.forName("UTF-8"));
        buffer.writeInt(998);
        buffer.writeByte(1);
        buffer.writeLong(System.currentTimeMillis());
        buffer.writeUtf8("Hello end!");

        sink.write(buffer, buffer.size());

        sink.flush();

        sink.close();

        Source source = Okio.source(file);

        buffer.clear();

        source.read(buffer, 1024);

        String string = buffer.readString("Hello okio!".length(), Charset.forName("UTF-8"));
        int intValue = buffer.readInt();
        byte byteValue = buffer.readByte();
        long longValue = buffer.readLong();
        String utf8 = buffer.readUtf8();

        System.out.println("str:" + string + "; int:" + intValue + ";byte:" + byteValue + "; long:" + longValue
        + "; utf8:" + utf8);

        source.close();
    }

}
