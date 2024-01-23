package recipebook.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import recipebook.entity.RecipeComment;
import recipebook.repository.RecipeCommentRepository;

@Service
public class RecipeCommentService {
    private final Logger logger = LoggerFactory.getLogger(RecipeCommentService.class);
    @Autowired
    RecipeCommentRepository repository;

    @KafkaListener(id = "recipe-comment-consumer", topics = "recipe_comments", groupId = "recipebook", autoStartup = "true")
    public void listen(RecipeComment recipeComment) {
        try {
            this.addComment(recipeComment);
        } catch (Exception e) {
            logger.error(String.format("Unable to add comment: %s, recipeId: %d", recipeComment.getComment(), recipeComment.getRecipeId()));
            throw new RuntimeException();
        }
    }

    public void addComment(RecipeComment recipeComment) {
        this.repository.save(recipeComment);
    }
}
