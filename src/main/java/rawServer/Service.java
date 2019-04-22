package rawServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Service {

    private static HttpServer server;

    private Service() { }

    public static Service getInstance() throws IOException {
        if (server == null) {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/v0/status", exchange -> {
                String responseString = "ONLINE";
                exchange.sendResponseHeaders(200, responseString.getBytes().length);
                exchange.getResponseBody().write(responseString.getBytes());
                exchange.close();
            });
        }
        return new Service();
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.stop(0);
        System.out.println("Service was stopped");
    }
}
