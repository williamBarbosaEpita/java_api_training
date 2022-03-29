package fr.lernejo.navy_battle;
import fr.lernejo.PingHandler;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;


public class Launcher
{
    public static void main(String[] args) throws IOException
    {
        final Map<String, String> gameContext = new HashMap<String, String>();
        if (args.length < 1)
            return;
        int port = parse_port(args);
        UUID uuid = UUID.randomUUID();
        gameContext.put("my_id", uuid.toString());
        gameContext.put("my_port", String.valueOf(port));
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 1);
        ExecutorService executorService =
            new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        beginServer(port);
    }

    private static void beginServer(int port) throws IOException
    {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(port), 0);
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 1000, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());
        httpServer.createContext("/ping", new PingHandler());
        httpServer.setExecutor(executorService);
        httpServer.start();
    }
    private static int parse_port(String[] args)
    {
        try
        {
            return Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
