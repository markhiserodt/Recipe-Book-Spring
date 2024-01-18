package recipebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import recipebook.entity.Food;
import recipebook.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    FoodService service;

    @CrossOrigin
    @GetMapping
    public List<Food> get() {
        return this.service.get();
    }

    @CrossOrigin
    @PostMapping
    public Food add(@RequestBody Food food) {
        return this.service.add(food);
    }

    @CrossOrigin
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Food update(@RequestBody Food food) {
        return this.service.update(food);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
