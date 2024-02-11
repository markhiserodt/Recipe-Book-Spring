package recipebook.model;

import recipebook.entity.Recipe;
import recipebook.entity.RecipeComment;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RecipeVO {
    private Long id;
    private String name;
    private Set<FoodDto> foods;

    private Set<RecipeComment> comments;

    public RecipeVO(Recipe recipe, List<String> fields) {
        this.id = recipe.getId();
        this.name = recipe.getName();
        if (fields == null || fields.isEmpty()) {
            return;
        }
        if (fields.contains("foods")) {
            this.foods = recipe.getFoods().stream().map(food -> new FoodDto(food, fields)).collect(Collectors.toSet());
        }
        if (fields.contains("comments")) {
            this.comments = recipe.getComments();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<FoodDto> getFoods() {
        return foods;
    }

    public void setFoods(Set<FoodDto> foods) {
        this.foods = foods;
    }

    public Set<RecipeComment> getComments() {
        return comments;
    }

    public void setComments(Set<RecipeComment> comments) {
        this.comments = comments;
    }
}
