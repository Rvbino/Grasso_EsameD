package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;

public class Handler implements HttpHandler {
    private final ArrayList<Wines> wines;

    public Handler(ArrayList<Wines> wines) {
        this.wines = wines;
    }

    public void handle(HttpExchange t) throws IOException {
        URI uri = t.getRequestURI();
        String query = uri.getQuery();
        String[] v = query.split("[=&]");
        InputStream is = t.getRequestBody();

        String output = "";
        ArrayList<Wines> box = (ArrayList<Wines>) wines.clone();
        if(v[0].equals("cmd")){
            switch(v[1]){

                case "all":
                    for(int i = 0; i < wines.size(); i++) {
                        output += wines.get(i);
                    }
                    break;

                case "red":
                    for(int i = 0; i < wines.size(); i++) {
                        if(wines.get(i).getType().equals("red")){
                            output += wines.get(i);
                        }
                    }
                    break;

                case "white":
                    for(int i = 0; i < wines.size(); i++) {
                        if(wines.get(i).getType().equals("white")){
                            output += wines.get(i);
                        }
                    }
                    break;

                case "sorted_by_name":
                    for(int i = 0; i < box.size(); i++) {
                        output += box.get(i);
                    }
                    break;

                case "sorted_by_price":
                    box.sort((p1, p2) -> {
                        if(p1.getPrice() > p2.getPrice()) return 1;
                        if(p1.getPrice() < p2.getPrice()) return -1;
                        return 0;
                    });
                    for(int i = 0; i < box.size(); i++) {
                        output += box.get(i);
                    }
                    break;

                default:
                    System.out.println("errore");
                    break;
            }
        }
        String response = "<!doctype html>\n" +
                "<html lang=en>\n" +
                "<head>\n" +
                "<meta charset=utf-8>\n" +
                "<title>MyJava Sample</title>\n" +
                "</head>\n" +
                "<body>\n" +
                output +
                "</body>\n" +
                "</html>\n";

        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private String read(InputStream is) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(is));

        System.out.println("\n");
        String received = null;

        while (true) {
            String s = null;

            try {
                if ((s = br.readLine()) == null ) break;
            } catch (IOException e) {
                System.out.println("errore"+e);
            }
            System.out.println(s);
            received += s;
        }
        return received;
    }
}