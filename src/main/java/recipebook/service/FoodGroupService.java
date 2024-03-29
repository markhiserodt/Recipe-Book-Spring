package recipebook.service;

import org.springframework.stereotype.Service;
import recipebook.entity.FoodGroup;
import recipebook.repository.FoodGroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoodGroupService {

    private final FoodGroupRepository repository;

    public FoodGroupService(FoodGroupRepository foodGroupRepository) {
        this.repository = foodGroupRepository;
    }

    public List<FoodGroup> get() {
        return this.repository.findAll();
    }

    public FoodGroup add(FoodGroup foodGroup) {
        return this.repository.save(foodGroup);
    }

    public FoodGroup update(FoodGroup foodGroup) {
        Optional<FoodGroup> foodGroupOptional = this.repository.findById(foodGroup.getId());
        if (foodGroupOptional.isEmpty()) {
            throw new RuntimeException();
        }
        FoodGroup foodGroupDb = foodGroupOptional.get();
        foodGroupDb.setName(foodGroup.getName());
        return this.repository.save(foodGroupDb);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
