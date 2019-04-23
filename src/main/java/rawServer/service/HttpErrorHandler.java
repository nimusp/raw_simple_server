package rawServer.service;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class HttpErrorHandler implements HttpHandler {

    private HttpHandler delegate;

    public HttpErrorHandler(HttpHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        try {
            delegate.handle(httpExchange);
        } catch (IOException e) {
            httpExchange.sendResponseHeaders(404, 0);
            httpExchange.close();
        } catch (IllegalArgumentException e) {
            httpExchange.sendResponseHeaders(400, 0);
        } finally {
            httpExchange.close();
        }
    }
}
