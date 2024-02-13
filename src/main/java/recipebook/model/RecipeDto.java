package recipebook.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import recipebook.entity.Food;
import recipebook.entity.Recipe;

import java.util.Set;

@JsonSerialize
@JsonDeserialize
public class RecipeDto {
    private Long id;
    private String name;
    private Set<Food> foods;
    private boolean isAvailable;

    public RecipeDto(Recipe recipe, boolean isAvailable) {
        this.id = recipe.getId();
        this.name = recipe.getName();
//        this.foods = recipe.getFoods();
        this.isAvailable = isAvailable;
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

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
