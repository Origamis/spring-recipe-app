package origamis.springframework.springrecipeapp.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp() {
        category = new Category();
    }

    @Test
    void getIdReturnsCorrectValue() {
        category = new Category();
        category.setId(1L);
        assertEquals(1L, category.getId());
    }

    @Test
    void getDescriptionReturnsCorrectValue() {
        category = new Category();
        category.setDescription("Desserts");
        assertEquals("Desserts", category.getDescription());
    }

    @Test
    void getRecipesReturnsCorrectValue() {
        category = new Category();
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe = new Recipe();
        recipes.add(recipe);
        category.setRecipes(recipes);
        assertEquals(recipes, category.getRecipes());
    }

    @Test
    void setIdHandlesNullValue() {
        category = new Category();
        category.setId(null);
        assertNull(category.getId());
    }

    @Test
    void setDescriptionHandlesNullValue() {
        category = new Category();
        category.setDescription(null);
        assertNull(category.getDescription());
    }

    @Test
    void setRecipesHandlesNullValue() {
        category = new Category();
        category.setRecipes(null);
        assertNull(category.getRecipes());
    }
}
