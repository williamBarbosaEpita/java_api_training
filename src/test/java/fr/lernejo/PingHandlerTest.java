package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.io.IOException;

class LauncherTest {

    @org.junit.jupiter.api.Test
    void PingTests() throws IOException, InterruptedException {
        String[] args = {"9876"};
        Launcher.main(args);

        HttpClient httpClient = HttpClient.newHttpClient();
        URL url = new URL("http://localhost:9876/ping");
        HttpURLConnection httpurlcon = (HttpURLConnection) url.openConnection();
        httpurlcon.setRequestMethod("GET");
        int status = httpurlcon.getResponseCode();
        Assertions.assertEquals(status, 200);
    }
}
