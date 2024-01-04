package recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipebook.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
