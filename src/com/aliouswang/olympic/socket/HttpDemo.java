package com.aliouswang.olympic.socket;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

import java.io.*;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.rmi.server.ExportException;

public class HttpDemo {

    public static void main(String[] args) {

        try {
            String host = "www.baidu.com";
//            host = "api.bejiaoyu.cn";
            String parmas = "byjy/config/homePage";
            int port = 80;

            Socket socket = new Socket();
            InetSocketAddress address = new InetSocketAddress(host, port);

            socket.connect(address, 3000);

//            OutputStreamWriter outputStream = new OutputStreamWriter(socket.getOutputStream(), "utf-8");
//            outputStream.write("GET " + "/" + " HTTP/1.1\r\n");
//            outputStream.write("Host: " + host + " \r\n");
//
//            outputStream.write("\r\n");
//
//            outputStream.flush();

            BufferedSink sink = Okio.buffer(Okio.sink(socket.getOutputStream()));
            sink.writeUtf8("GET " + "/" + parmas + " HTTP/1.1\r\n");
            sink.writeUtf8("Host: " + host + " \r\n");
            sink.writeUtf8("\r\n");
            sink.flush();



            socket.shutdownOutput();

            Source source = Okio.buffer(Okio.source(socket.getInputStream()));

            String line = null;
            while ((line = ((BufferedSource) source).readUtf8Line()) != null) {
                System.out.println(line);
            }

//            BufferedReader bufferedReader = new BufferedReader(
//                    new InputStreamReader(socket.getInputStream(), "utf-8")
//            );
//
//            String line = null;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }


            sink.close();
//            bufferedReader.close();
            source.close();
            socket.close();
        } catch (ConnectException e) {
            System.out.println("链接失败");
        } catch (SocketTimeoutException e) {
            System.out.println("连接超时");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
