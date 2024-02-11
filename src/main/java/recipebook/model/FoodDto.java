package recipebook.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import recipebook.entity.Food;

import java.util.List;

@JsonSerialize
@JsonDeserialize
public class FoodDto {
    private Long id;
    private String name;
    private FoodGroupDto foodGroup;

    public FoodDto(Food food) {
    }

    public FoodDto(Food food, List<String> fields) {
        this.id = food.getId();
        this.name = food.getName();
        if (fields == null || fields.isEmpty()) {
            return;
        }
        if (fields.contains("foodGroup")) {
            this.foodGroup = new FoodGroupDto(food.getFoodGroup());
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

    public FoodGroupDto getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(FoodGroupDto foodGroupDto) {
        this.foodGroup = foodGroupDto;
    }
}
