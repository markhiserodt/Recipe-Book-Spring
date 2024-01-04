package recipebook.resource;

import org.springframework.web.bind.annotation.*;
import recipebook.persistence.FoodGroup;
import recipebook.service.FoodGroupService;

import java.util.List;

@RestController
public class FoodGroupResource {
    FoodGroupService service;

    public FoodGroupResource(FoodGroupService service) {
        this.service = service;
    }

    @GetMapping(value = "/api/foodGroup")
    public List<FoodGroup> get() {
        return this.service.get();
    }

    @PostMapping(value = "/api/foodGroup")
    public FoodGroup add(FoodGroup foodGroup) {
        return this.service.add(foodGroup);
    }

    @PutMapping(value = "/api/foodGroup", consumes = "application/json")
    public FoodGroup update(@RequestBody FoodGroup foodGroup) {
        return this.service.update(foodGroup);
    }

    @DeleteMapping(value = "/api/foodGroup/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
