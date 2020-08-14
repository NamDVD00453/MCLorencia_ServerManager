package main.mclorencia.controller;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpHandler;
import main.mclorencia.entity.RequestCommand;
import main.mclorencia.model.ConnectionHelper;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Scanner;

public class AccountController {

    Connection conn;
    HttpHandler accountHandler;

    public AccountController() {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        this.conn = connectionHelper.getConn();
        this.accountHandler = httpExchange -> {
            String resp;
            if ("POST".equals(httpExchange.getRequestMethod())) {
                InputStream in = httpExchange.getRequestBody();
                Scanner s = new Scanner(in).useDelimiter("\\A");
                String result = s.hasNext() ? s.next() : "";
                System.out.println(result);
                resp = handle(result);
            } else {
                resp = "Method " + httpExchange.getRequestMethod() + " not allowed!";
            }

            httpExchange.sendResponseHeaders(200, resp.getBytes().length);
            OutputStream out = httpExchange.getResponseBody();
            out.write(resp.getBytes());
            out.flush();
            httpExchange.close();
        };
    }

    public HttpHandler getAccountHandler() {
        return accountHandler;
    }

    //Xu ly du lieu gui len Json : @var result
    //Tra ve client voi du lieu json

    private static String handle(String result) {
        RequestCommand requestCommand = new Gson().fromJson(result, RequestCommand.class);
        if (requestCommand != null){
            switch (requestCommand.getCmdType()){
                case "REG":{
                    executeReg(requestCommand);
                    break;
                }
                case "LOG":{
                    executeLog(requestCommand);
                    break;
                }
                case "UPDATE":{
                    executeUpdate(requestCommand);
                    break;
                }
                case "DEL":{
                    executeDel(requestCommand);
                    break;
                }
                case "ACTIVE":{
                    executeActive(requestCommand);
                    break;
                }
                default:{
                    handleError(requestCommand, "Unknown Command");
                }
            }
        }
        return "";
    }

    private static void handleError(RequestCommand requestCommand, String message) {
    }

    private static void executeActive(RequestCommand requestCommand) {
    }

    private static void executeDel(RequestCommand requestCommand) {
    }

    private static void executeUpdate(RequestCommand requestCommand) {
    }

    private static void executeLog(RequestCommand requestCommand) {
    }

    private static void executeReg(RequestCommand requestCommand) {
    }
}
