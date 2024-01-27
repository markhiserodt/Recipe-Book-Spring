package recipebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import recipebook.entity.Feature;
import recipebook.service.FeatureService;

import java.util.List;

@RestController
@RequestMapping("/api/feature")
public class FeatureController {
    @Autowired
    FeatureService service;

    @CrossOrigin
    @GetMapping
    public List<Feature> get() {
        return this.service.get();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Feature get(@PathVariable Long id) {
        return this.service.get(id);
    }

    @CrossOrigin
    @PostMapping
    public Feature add(@RequestBody Feature feature) {
        return this.service.add(feature);
    }

    @CrossOrigin
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Feature update(@RequestBody Feature feature) {
        return this.service.update(feature);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}