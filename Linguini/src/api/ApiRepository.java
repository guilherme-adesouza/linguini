package api;

import java.io.IOException;

/**
 * @author guilherme-souza
 */
public interface ApiRepository {
    public static final String JSON = "application/json; charset=utf-8";

    public String get(String url, String mediaType, String[] headers) throws IOException;
    public String post(String url, String body, String mediaType, String[] headers) throws IOException;
}
