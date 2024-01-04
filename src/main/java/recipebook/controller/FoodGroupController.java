package recipebook.controller;

import org.springframework.web.bind.annotation.*;
import recipebook.entity.FoodGroup;
import recipebook.service.FoodGroupService;

import java.util.List;

@RestController
public class FoodGroupController {
    FoodGroupService service;

    public FoodGroupController(FoodGroupService service) {
        this.service = service;
    }

    @GetMapping(value = "/api/foodGroup")
    public List<FoodGroup> get() {
        return this.service.get();
    }

    @PostMapping(value = "/api/foodGroup")
    public FoodGroup add(@RequestBody FoodGroup foodGroup) {
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
