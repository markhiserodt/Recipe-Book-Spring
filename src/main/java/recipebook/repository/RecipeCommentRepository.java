package recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipebook.entity.RecipeComment;

@Repository
public interface RecipeCommentRepository extends JpaRepository<RecipeComment, Long> {
}