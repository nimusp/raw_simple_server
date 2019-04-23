package rawServer.repository;

import com.sun.istack.internal.NotNull;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SimpleRepository {

    byte[] get(@NotNull String key) throws IOException;
    void upsert(@NotNull String key, @NotNull byte[] value) throws IOException;
    void delete(@NotNull String key) throws FileNotFoundException;
}
