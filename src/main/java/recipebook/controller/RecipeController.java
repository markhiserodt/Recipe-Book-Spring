package recipebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import recipebook.entity.Recipe;
import recipebook.entity.RecipeComment;
import recipebook.model.RecipeDto;
import recipebook.model.RecipeVO;
import recipebook.service.RecipeCommentService;
import recipebook.service.RecipeService;

import java.util.List;


@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    @Autowired
    RecipeService service;

    @Autowired
    RecipeCommentService recipeCommentService;

    @CrossOrigin
    @GetMapping
    public List<Recipe> get() {
        return this.service.get();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Recipe getRecipe(@PathVariable Long id) {
        return this.service.getRecipe(id);
    }

    @CrossOrigin
    @PostMapping
    public Recipe add(@RequestBody Recipe recipe) {
        return this.service.add(recipe);
    }

    @CrossOrigin
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Recipe update(@RequestBody Recipe recipe) {
        return this.service.update(recipe);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }

    @CrossOrigin
    @GetMapping(value = "/recipesAvailable")
    public List<RecipeDto> recipesAvailable(){
        return this.service.recipesAvailable();
    }

    @CrossOrigin
    @GetMapping(value = "/recipesAvailableAsync")
    public List<RecipeDto> recipesAvailableAsync(){
        return this.service.recipesAvailableAsync();
    }

    @CrossOrigin
    @PostMapping(value = "/addComment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addComment(@RequestBody RecipeComment recipeComment) {
        this.recipeCommentService.sendComment(String.valueOf(recipeComment.getRecipeId()), recipeComment);
    }

    @CrossOrigin
    @GetMapping(value = "/vo/{id}")
    public List<RecipeVO> getRecipeVOs(@MatrixVariable(value = "fields", pathVar = "id", required = false) List<String> fields) {
        return this.service.getRecipeVOWithFields(fields);
    }
}
