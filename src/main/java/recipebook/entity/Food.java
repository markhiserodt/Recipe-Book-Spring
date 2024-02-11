package recipebook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @JsonIgnore
    @Column(name = "food_group_id", insertable = false, updatable = false)
    private Long foodGroupId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_group_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private FoodGroup foodGroup;

    public Food() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFoodGroupId() {
        return foodGroupId;
    }

    public void setFoodGroupId(Long foodGroupId) {
        this.foodGroupId = foodGroupId;
    }

    public FoodGroup getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(FoodGroup foodGroup) {
        this.foodGroup = foodGroup;
    }

}
