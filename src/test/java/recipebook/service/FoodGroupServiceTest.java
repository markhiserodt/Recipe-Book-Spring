package recipebook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import recipebook.entity.FoodGroup;
import recipebook.repository.FoodGroupRepository;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FoodGroupServiceTest {

    private FoodGroupService service;

    private final FoodGroupRepository repository = mock(FoodGroupRepository.class);

    @BeforeEach
    public void initFoodGroupService() {
        service = new FoodGroupService(repository);
    }

    @Test
    public void testGet() {
        FoodGroup foodGroup = new FoodGroup();
        foodGroup.setId(1L);
        foodGroup.setName("Fruits");
        when(repository.findAll()).thenReturn(List.of(foodGroup));
        assert(service.get()).contains(foodGroup);
    }

    @Test
    public void testAdd() {
        FoodGroup foodGroup = new FoodGroup();
        foodGroup.setId(1L);
        foodGroup.setName("Fruits");
        when(repository.save(foodGroup)).thenReturn(foodGroup);
        assert(service.add(foodGroup)).equals(foodGroup);
    }

    @Test
    public void testUpdate() {
        FoodGroup foodGroup = new FoodGroup();
        foodGroup.setId(1L);
        foodGroup.setName("Fruits");
        when(repository.findById(foodGroup.getId())).thenReturn(java.util.Optional.of(foodGroup));
        when(repository.save(foodGroup)).thenReturn(foodGroup);
        assert(service.update(foodGroup)).equals(foodGroup);
    }

    @Test
    public void testDelete() {
        FoodGroup foodGroup = new FoodGroup();
        foodGroup.setId(1L);
        service.delete(foodGroup.getId());
    }
}
