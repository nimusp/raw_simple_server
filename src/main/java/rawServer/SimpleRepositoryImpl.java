package rawServer;

import java.io.*;

public class SimpleRepositoryImpl implements SimpleRepository {

    private final String dir;

    public SimpleRepositoryImpl(String dir) {
        this.dir = dir;
    }

    @Override
    public byte[] get(String key) throws IOException {
        final File file = new File(dir, key);
        final byte[] bytes = new byte[(int) file.length()];
        try (InputStream inputStream = new FileInputStream(file)) {
            if (inputStream.read(bytes) != bytes.length) {
                throw new IOException("Can't read file");
            }
        }
        return bytes;
    }

    @Override
    public void upsert(String key, byte[] value) throws IOException {
        final File file = new File(dir, key);
        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(value);
        }
    }

    @Override
    public void delete(String key) {
        File file = new File(dir, key);
        file.delete();
    }
}
