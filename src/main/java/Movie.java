import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @JsonProperty("title")
    public String title;

    @JsonProperty("year")
    public Integer year;

    @JsonProperty("image")
    public String urlImage;

    @JsonProperty("imDbRating")
    public Double rating;

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
