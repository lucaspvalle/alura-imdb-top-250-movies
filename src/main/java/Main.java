import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String token_imdb = System.getenv("API_KEY_IMDB");
        String json = new HttpRequestIMDB(token_imdb).requestTop250();

        List<Movie> movies = new ParseTop250MoviesRequest().parseJsonStringToObject(json);

        new HtmlGenerator("content.html").generate(movies);
    }
}
