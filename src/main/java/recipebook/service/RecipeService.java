package recipebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import recipebook.entity.Recipe;
import recipebook.model.RecipeDto;
import recipebook.repository.RecipeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class RecipeService {
    @Autowired
    RecipeRepository repository;

    private final RestTemplate restTemplate;

    public RecipeService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Recipe> get() {
        return this.repository.findAll();
    }

    public Recipe getRecipe(Long id) {
        Optional<Recipe> recipeOptional = this.repository.findById(id);
        if (recipeOptional.isEmpty()) {
            throw new RuntimeException();
        }
        return recipeOptional.get();
    }

    public Recipe add(Recipe recipe) {
        return this.repository.save(recipe);
    }

    public Recipe update(Recipe recipe) {
        Optional<Recipe> recipeOptional = this.repository.findById(recipe.getId());
        if (recipeOptional.isEmpty()) {
            throw new RuntimeException();
        }
        Recipe recipeDb = recipeOptional.get();
        recipeDb.setName(recipe.getName());
        recipeDb.setFoods(recipe.getFoods());
        return this.repository.save(recipeDb);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<RecipeDto> recipesAvailable() {
        List<RecipeDto> recipeDtos = new ArrayList<>();
        String url = "http://localhost:8001/api/inventory/isAvailable";
        List<Recipe> recipes = this.get();

        recipes.forEach(recipe -> {
            Boolean isAvailable = this.restTemplate.postForObject(url, recipe, Boolean.class);
            if (isAvailable == null) {
                throw new RuntimeException();
            }
            recipeDtos.add(new RecipeDto(recipe, isAvailable));
        });
        return recipeDtos;
    }

    public List<RecipeDto> recipesAvailableAsync() {
        List<RecipeDto> recipeDtos = new ArrayList<>();
        String url = "http://localhost:8001/api/inventory/isAvailable";
        List<Recipe> recipes = this.get();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (Recipe recipe : recipes) {
            futures.add(CompletableFuture.runAsync(() -> {
                Boolean isAvailable = this.restTemplate.postForObject(url, recipe, Boolean.class);
                if (isAvailable == null) {
                    throw new RuntimeException();
                }
                recipeDtos.add(new RecipeDto(recipe, isAvailable));
            }));
        }
        futures.forEach(CompletableFuture::join);
        return recipeDtos;
    }
}
