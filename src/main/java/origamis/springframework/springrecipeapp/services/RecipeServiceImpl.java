package origamis.springframework.springrecipeapp.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import origamis.springframework.springrecipeapp.domain.Recipe;
import origamis.springframework.springrecipeapp.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    
    private final RecipeRepository recipeRepository;

    @Override
    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe Not Found!"));
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        
        return recipeSet;
    }
}
