package origamis.springframework.springrecipeapp.services;

import java.util.Set;

public interface RecipeService {

    Set<origamis.springframework.springrecipeapp.domain.Recipe> getRecipes();
}