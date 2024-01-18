package recipebook.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import recipebook.entity.Recipe;
import recipebook.utility.HttpUtil;

import java.util.Arrays;
import java.util.List;

@Service
public class TestService {

    private final RestTemplate restTemplate;

    public TestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Recipe> getAvailable() {
        String response = HttpUtil.get("http://localhost:8000/api/recipe");
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList(mapper.readValue(response, Recipe[].class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Recipe[] getRecipes() {
        String url = "http://localhost:8000/api/recipe";
        return this.restTemplate.getForObject(url, Recipe[].class);
    }
}
