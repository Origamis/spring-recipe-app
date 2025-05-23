package origamis.springframework.springrecipeapp.services;

import origamis.springframework.springrecipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);
}