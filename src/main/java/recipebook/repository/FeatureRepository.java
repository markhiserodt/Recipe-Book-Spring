package recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipebook.entity.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
