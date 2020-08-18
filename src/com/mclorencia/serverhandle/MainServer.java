package com.mclorencia.serverhandle;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class MainServer {
    private final int port;
    private CmdHandler cmdHandler;

    public MainServer() {
        this.port = 8800;
        this.cmdHandler = new CmdHandler();
    }

    private final HttpHandler createHttpHandler = httpExchange -> {
        String resp;
        if ("POST".equals(httpExchange.getRequestMethod())) {
            //POST method voi json: result
            InputStream in = httpExchange.getRequestBody();
            Scanner s = new Scanner(in).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";
            System.out.println(result);
            resp = cmdHandler.handle(result);
        } else {
            resp = "Method " + httpExchange.getRequestMethod() + " not allowed!";
        }

        httpExchange.sendResponseHeaders(200, resp.getBytes().length);
        OutputStream out = httpExchange.getResponseBody();
        out.write(resp.getBytes());
        out.flush();
        httpExchange.close();
    };

    public void execute(){
        HttpServer server;
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);

            server.createContext("/api/account", createHttpHandler);
            server.createContext("/api/post", createHttpHandler);

            //Executor mac dinh
            server.setExecutor(null);
            //start Server
            server.start();
            System.out.println("Server running on port: " + server.getAddress().getPort());
        } catch (IOException e) {
            System.out.println("Cannot start server on port: " + port);
            System.out.println(e.getMessage());
        }
    }
}
