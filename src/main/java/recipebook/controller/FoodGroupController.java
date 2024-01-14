package recipebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import recipebook.entity.FoodGroup;
import recipebook.service.FoodGroupService;

import java.util.List;

@RestController
public class FoodGroupController {
    @Autowired
    FoodGroupService service;

    @CrossOrigin
    @GetMapping(value = "/api/foodGroup")
    public List<FoodGroup> get() {
        return this.service.get();
    }

    @CrossOrigin
    @PostMapping(value = "/api/foodGroup")
    public FoodGroup add(@RequestBody FoodGroup foodGroup) {
        return this.service.add(foodGroup);
    }

    @CrossOrigin
    @PutMapping(value = "/api/foodGroup", consumes = "application/json")
    public FoodGroup update(@RequestBody FoodGroup foodGroup) {
        return this.service.update(foodGroup);
    }

    @CrossOrigin
    @DeleteMapping(value = "/api/foodGroup/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
