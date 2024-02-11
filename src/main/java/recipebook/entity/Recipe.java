package recipebook.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

@Entity
@Table(name = "Recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Recipe_Food",
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "food_id"))
    Set<Food> foods;

    @OneToMany(mappedBy = "recipeId", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Set<RecipeComment> comments;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }

    public Set<RecipeComment> getComments() {
        return comments;
    }

    public void setComments(Set<RecipeComment> comments) {
        this.comments = comments;
    }
}
