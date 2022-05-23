package org.example;

import java.net.Socket;

public class Handler implements Runnable{
    private TCP conn;

    public Handler(Socket sock){
        System.out.println("--conneting to "+sock.getRemoteSocketAddress() + "...");
        conn = new TCP(sock);
        System.out.println("--connection established!");
    }

    @Override
    public void run() {
        for(String s; (s = conn.read()) != null;) {
            System.out.println(s);
        }
    }
}