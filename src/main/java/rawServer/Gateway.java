package rawServer;

import rawServer.repository.SimpleRepository;
import rawServer.repository.SimpleRepositoryImpl;
import rawServer.service.Service;
import rawServer.service.ServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Gateway {

    public static void main(String[] args) throws IOException {
        Path tempDirectory = Files.createTempDirectory("repo_simulation");
        SimpleRepository repository = new SimpleRepositoryImpl(tempDirectory.toAbsolutePath().toString());
        Service simpleService = new ServiceImpl(repository);
        simpleService.start();
        try {
            Thread.sleep(5 * 60 * 1000);
            simpleService.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
