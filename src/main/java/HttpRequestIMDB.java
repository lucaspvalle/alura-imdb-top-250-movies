import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestIMDB {

    private final String token_imdb;

    public HttpRequestIMDB(String token_imdb) {
        this.token_imdb = token_imdb;
    }

    public String requestTop250() throws IOException, InterruptedException {
        String myURL = "https://imdb-api.com/en/API/Top250Movies/" + token_imdb;

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(myURL)).GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
