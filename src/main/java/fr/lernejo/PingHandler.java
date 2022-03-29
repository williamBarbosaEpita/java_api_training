package fr.lernejo;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public class PingHandler implements HttpHandler {
        String body = "Hello";
    public void handle(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200,body.length());
        try(
            OutputStream os = exchange.getResponseBody())

            {
                os.write(body.getBytes());
            }
    }
}
