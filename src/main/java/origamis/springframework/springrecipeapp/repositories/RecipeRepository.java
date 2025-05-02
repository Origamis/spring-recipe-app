package origamis.springframework.springrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import origamis.springframework.springrecipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
