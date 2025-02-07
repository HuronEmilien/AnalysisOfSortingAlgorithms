package main.swing.model;

import com.sun.net.httpserver.HttpServer;
import java.io.*;
import java.nio.file.*;

public class WebServer {

    public String URL;
    public final static int PORT = 8080;
    public final static String BASE_PATH = ".";

    public WebServer(String path) throws IOException {
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(WebServer.PORT), 0);

        server.createContext("/", exchange -> {
            String requestPath = exchange.getRequestURI().getPath();
            if (requestPath.equals("/")) {
                requestPath = path;
            }
            Path filePath = Paths.get(WebServer.BASE_PATH + requestPath);
            String contentType = getContentType(filePath.toString());
            exchange.getResponseHeaders().set("Content-Type", contentType);
            exchange.sendResponseHeaders(200, Files.size(filePath));
            try (OutputStream os = exchange.getResponseBody()) {
                Files.copy(filePath, os);
            }
        });
        this.URL = path;
        server.setExecutor(null);
        server.start();
        System.out.println("Server running Start : "+path);
    }

    public String getURL() {
        return URL;
    }

    private static String getContentType(String fileName) {
        if (fileName.endsWith(".html")) return "text/html";
        if (fileName.endsWith(".css")) return "text/css";
        if (fileName.endsWith(".js")) return "application/javascript";
        if (fileName.endsWith(".json")) return "application/json";
        return "application/octet-stream";
    }

}