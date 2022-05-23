package org.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;

//curl: http://127.0.0.1:8000/?cmd=all

public class App
{
    public static void main( String[] args ) {
        ArrayList<Wines> wines = new ArrayList<>();
        wines.add(new Wines(13, "white","Dom perignon Vintage Moet & chandon 2008", 225.94));
        wines.add(new Wines(14, "red","Pignoli Radikon Radikon", 133.0));
        wines.add(new Wines(124, "red", "Pinot Nero Elena Walch Elena Walch", 43.0));

        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8000), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.createContext("/", new Handler(wines));
        server.setExecutor(null);
        server.start();
    }

}