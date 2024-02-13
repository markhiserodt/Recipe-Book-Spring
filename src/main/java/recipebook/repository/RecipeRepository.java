package recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import recipebook.entity.Recipe;

import java.util.List;
import java.util.Optional;

/*
/api/recipe/vo;fields=foods
/api/recipe/vo;fields=foods,comments
/api/recipe/vo;fields=foods,food.foodGroup

class RecipeService
 getRecipe(List<String> fields) {
    switch(fields) {
        case "foods":
            return getRecipeWithFoods();
        case "comments":
            return getRecipeWithFoodsAndComments();
        case "food.foodGroup":
            return getRecipeWithFoodsAndFoodGroup();
    }
 }
 */

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("select r from Recipe r where r.id = ?1")
    Optional<Recipe> findByRecipeId(Long id);

    @Query(value = "SELECT r.id, r.name, rc.comment, rc.recipe_id FROM Recipe r INNER JOIN Recipe_Comment rc ON r.id = rc.recipe_id", nativeQuery = true)
    Optional<List<Recipe>> findWithComments();
//    public List<Recipe> getRecipeWithComments(Long id); // custom SQL query to join
//    public List<Recipe> getRecipeWithFoods(Long id); // custom SQL query to join
//    public List<Recipe> getRecipeWithFoodsAndComments(Long id); // custom SQL query to join
//    public List<Recipe> getRecipeWithFoodsAndFoodGroup(Long id); // custom SQL query to join
}
