package main.mclorencia.main;

import com.sun.net.httpserver.HttpServer;
import main.mclorencia.config.ConfigUtil;
import main.mclorencia.controller.AccountController;
import main.mclorencia.controller.ApiController;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Properties;

public class MainThread {
    public static void main(String[] args) {
		//Dung HERE
        Properties properties = new ConfigUtil().getProperties();
        HttpServer server;
        try {
            server = HttpServer.create(new InetSocketAddress(Integer.parseInt(properties.getProperty("ServerPort"))), 0);
            server.createContext("/api/account", new AccountController().getAccountHandler());
            server.setExecutor(null);
            server.start();
            System.out.println("Server running on port: " + server.getAddress().getPort());
        } catch (IOException e) {
            System.out.println("Cannot start server on port: " + properties.getProperty("ServerPort"));
            System.out.println(e.getMessage());
        }
    }
}
