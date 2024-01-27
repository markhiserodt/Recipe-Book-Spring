package recipebook.service;

import org.springframework.stereotype.Service;
import recipebook.entity.Feature;
import recipebook.repository.FeatureRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureService {

    private final FeatureRepository repository;

    public FeatureService(FeatureRepository featureRepository) {
        this.repository = featureRepository;
    }

    public List<Feature> get() {
        return this.repository.findAll();
    }

    public Feature get(Long id) {
        Optional<Feature> featureOptional = this.repository.findById(id);
        if (featureOptional.isEmpty()) {
            throw new RuntimeException();
        }
        return featureOptional.get();
    }

    public Feature add(Feature feature) {
        return this.repository.save(feature);
    }

    public Feature update(Feature feature) {
        return this.repository.save(feature);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
