package recipebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import recipebook.entity.Food;
import recipebook.service.FoodService;

@RestController
public class FoodController {
    @Autowired
    FoodService service;

    @GetMapping(value = "/api/food")
    public List<Food> get() {
        return this.service.get();
    }

    @PostMapping(value = "/api/food")
    public Food add(@RequestBody Food food) {
        return this.service.add(food);
    }

    @PutMapping(value = "/api/food", consumes = "application/json")
    public Food update(@RequestBody Food food) {
        return this.service.update(food);
    }

    @DeleteMapping(value = "/api/food/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
