package recipebook.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import recipebook.entity.Food;
import recipebook.entity.FoodGroup;
import recipebook.entity.Recipe;
import recipebook.repository.FoodRepository;
import recipebook.repository.RecipeRepository;

@Service
public class RecipeService {

    RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public List<Recipe> get() {
        return this.repository.findAll();
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


}
