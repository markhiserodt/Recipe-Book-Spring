package recipebook.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import recipebook.entity.FoodGroup;

@JsonSerialize
@JsonDeserialize
public class FoodGroupDto {
    public Long id;
    public String name;

    public FoodGroupDto(FoodGroup foodGroup) {
        this.id = foodGroup.getId();
        this.name = foodGroup.getName();
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
}
