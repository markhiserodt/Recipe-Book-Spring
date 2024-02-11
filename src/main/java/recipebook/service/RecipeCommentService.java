package recipebook.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import recipebook.entity.RecipeComment;
import recipebook.repository.RecipeCommentRepository;

import java.util.concurrent.CompletableFuture;


@Service
public class RecipeCommentService {
    private final Logger logger = LoggerFactory.getLogger(RecipeCommentService.class);
    @Autowired
    RecipeCommentRepository repository;
    @Autowired
    private KafkaTemplate<String, RecipeComment> kafkaTemplate;
    private static final String TOPIC = "recipe_comments";

    @KafkaListener(id = "recipe-comment-consumer", topics = TOPIC, groupId = "recipebook", autoStartup = "false")
    public void listen(RecipeComment recipeComment) {
        try {
            this.saveComment(recipeComment);
            logger.info(String.format("Consumed event with comment: %s, recipeId: %d", recipeComment.getComment(), recipeComment.getRecipeId()));
        } catch (Exception e) {
            logger.error(String.format("Unable to add comment: %s, recipeId: %d", recipeComment.getComment(), recipeComment.getRecipeId()));
            throw new RuntimeException();
        }
    }

    public void saveComment(RecipeComment recipeComment) {
        this.repository.save(recipeComment);
    }

    public void sendComment(String key, RecipeComment recipeComment) {
        CompletableFuture<SendResult<String, RecipeComment>> future = kafkaTemplate.send(TOPIC, key, recipeComment);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                logger.info(String.format("Produced event with comment: %s, recipeId: %d", recipeComment.getComment(), recipeComment.getRecipeId()));
            } else {
                logger.error(String.format("Unable to produce event to topic %s: ex = %s", TOPIC, ex));
            }
        });
    }
}
