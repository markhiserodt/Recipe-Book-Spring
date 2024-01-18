package recipebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import recipebook.entity.FoodGroup;
import recipebook.service.FoodGroupService;

import java.util.List;

@RestController
@RequestMapping("/api/foodGroup")
public class FoodGroupController {
    @Autowired
    FoodGroupService service;

    @CrossOrigin
    @GetMapping
    public List<FoodGroup> get() {
        return this.service.get();
    }

    @CrossOrigin
    @PostMapping
    public FoodGroup add(@RequestBody FoodGroup foodGroup) {
        return this.service.add(foodGroup);
    }

    @CrossOrigin
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public FoodGroup update(@RequestBody FoodGroup foodGroup) {
        return this.service.update(foodGroup);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
