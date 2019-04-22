package rawServer;

import java.io.IOException;

public class Gateway {

    public static void main(String[] args) throws IOException {
        SimpleRepository repository = new SimpleRepositoryImpl("");
        Service simpleService = new ServiceImpl(repository);
        simpleService.start();
        try {
            Thread.sleep(2 * 60 * 1000);
            simpleService.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
