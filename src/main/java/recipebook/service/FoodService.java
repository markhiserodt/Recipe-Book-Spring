package recipebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipebook.entity.Food;
import recipebook.model.FoodDto;
import recipebook.repository.FoodRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService {
    @Autowired
    FoodRepository repository;

    public List<Food> get() {
        return this.repository.findAll();
    }

    public List<FoodDto> getDto() {
        return this.get().stream().map(FoodDto::new).collect(Collectors.toList());
    }

    public Food add(Food food) {
        return this.repository.save(food);
    }

    public Food update(Food food) {
        Optional<Food> foodOptional = this.repository.findById(food.getId());
        if (foodOptional.isEmpty()) {
            throw new RuntimeException();
        }
        Food foodDb = foodOptional.get();
        foodDb.setName(food.getName());
        foodDb.setFoodGroup(food.getFoodGroup());
        return this.repository.save(foodDb);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<FoodDto> getFoodDtosWithFields(List<String> fields) {
        return this.repository.findAll().stream().map(food -> new FoodDto(food, fields)).collect(Collectors.toList());
    }
}