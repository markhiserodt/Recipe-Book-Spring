package recipebook.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Recipe_Comment")
public class RecipeComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "recipe_id", nullable = false)
    private Long recipeId;

    public RecipeComment() {
        this.id = 1L;
        this.comment = "comment";
        this.recipeId = 1L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}