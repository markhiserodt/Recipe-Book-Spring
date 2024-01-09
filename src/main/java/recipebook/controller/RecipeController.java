package recipebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import recipebook.entity.Recipe;
import recipebook.service.RecipeService;

@RestController
public class RecipeController {
    @Autowired
    RecipeService service;

    @GetMapping(value = "/api/recipe")
    public List<Recipe> get() {
        return this.service.get();
    }

    @PostMapping(value = "/api/recipe")
    public Recipe add(@RequestBody Recipe recipe) {
        return this.service.add(recipe);
    }

    @PutMapping(value = "/api/recipe", consumes = "application/json")
    public Recipe update(@RequestBody Recipe recipe) {
        return this.service.update(recipe);
    }

    @DeleteMapping(value = "/api/recipe/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
