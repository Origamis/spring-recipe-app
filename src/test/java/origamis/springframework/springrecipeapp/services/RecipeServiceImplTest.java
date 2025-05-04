package origamis.springframework.springrecipeapp.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import origamis.springframework.springrecipeapp.domain.Recipe;
import origamis.springframework.springrecipeapp.repositories.RecipeRepository;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    @InjectMocks
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Test
    void getRecipesReturnsAllRecipes() {
        // arrange
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);
        Set<Recipe> mockRecipes = Set.of(recipe1, recipe2);

        when(recipeRepository.findAll()).thenReturn(mockRecipes);

        // act
        Set<Recipe> recipes = recipeService.getRecipes();

        // assert
        assertNotNull(recipes);
        assertEquals(2, recipes.size());
        assertTrue(recipes.contains(recipe1));
        assertTrue(recipes.contains(recipe2));
        verify(recipeRepository, times(1)).findAll();
    }
    
    @Test
    void getRecipeByIdReturnsRecipe() {
        // arrange
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));

        // act
        Recipe foundRecipe = recipeService.findById(1L);

        // assert
        assertNotNull(foundRecipe);
        assertEquals(1L, foundRecipe.getId());
        verify(recipeRepository, times(1)).findById(1L);
    }
}