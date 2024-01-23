package recipebook.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import recipebook.entity.RecipeComment;

import java.util.concurrent.CompletableFuture;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "recipe_comments";

    @Autowired
    private KafkaTemplate<String, RecipeComment> kafkaTemplate;

    public void sendMessage(String key, RecipeComment recipeComment) {
        CompletableFuture<SendResult<String, RecipeComment>> future = kafkaTemplate.send(TOPIC, key, recipeComment);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                logger.info(String.format("Produced event to topic %s: key = %-10s value = %s", TOPIC, key, recipeComment.getComment()));
            } else {
                logger.error(String.format("Unable to produce event to topic %s: ex = %s", TOPIC, ex));
            }
        });
    }

}