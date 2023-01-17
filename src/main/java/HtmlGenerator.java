import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HtmlGenerator implements AutoCloseable {

    private final PrintWriter writer;

    public HtmlGenerator(String fileName) throws FileNotFoundException {
        this.writer = new PrintWriter(fileName);
    }

    private String readFileInResourcesPath(String fileName) throws IOException {
        Path filePath = Path.of("src", "main", "resources", "html", fileName);

        return Files.readString(filePath);
    }

    public void generate(List<Movie> Movies) throws IOException {
        String head = readFileInResourcesPath("head.txt");
        String divTemplate = readFileInResourcesPath("divTemplate.txt");

        writer.println(head);

        for (Movie Movie : Movies) {
            String title = Movie.getTitle();
            String urlImage = Movie.getUrlImage();
            Double rating = Movie.getRating();
            Integer year = Movie.getYear();

            writer.println(String.format(divTemplate, title, urlImage, title, rating, year));
        }
    }

    @Override
    public void close() {
        writer.close();
    }
}
