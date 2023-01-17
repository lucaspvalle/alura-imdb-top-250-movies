import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ParseTop250MoviesRequest {
    @JsonProperty("items")
    public List<Movie> items;

    @JsonProperty("errorMessage")
    public String errorMessage;

    public List<Movie> getItems() {
        return items;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<Movie> parseJsonStringToObject(String requestedJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        ParseTop250MoviesRequest movies = mapper.readValue(requestedJson, new TypeReference<>() {});

        String errorMessage = movies.getErrorMessage();
        if (!errorMessage.isEmpty()) {
            throw new Exception(errorMessage);
        }

        return movies.getItems();
    }

}
