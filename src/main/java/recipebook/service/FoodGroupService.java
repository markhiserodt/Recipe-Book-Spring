package recipebook.service;


import recipebook.persistence.FoodGroup;
import recipebook.persistence.FoodGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodGroupService {
    FoodGroupRepository repository;

    public FoodGroupService(FoodGroupRepository repository) {
        this.repository = repository;
    }

    public List<FoodGroup> get() {
        return this.repository.findAll();
    }

    public FoodGroup add(FoodGroup foodGroup) {
        return this.repository.save(foodGroup);
    }

    public FoodGroup update(FoodGroup foodGroup) {
        Optional<FoodGroup> dbFoodGroup = this.repository.findById(foodGroup.getId());
        if (dbFoodGroup.isEmpty()) {
            throw new RuntimeException();
        }
        foodGroup.setName(dbFoodGroup.get().getName());
        return this.repository.save(dbFoodGroup.get());
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
