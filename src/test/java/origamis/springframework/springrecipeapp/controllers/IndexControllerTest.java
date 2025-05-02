package origamis.springframework.springrecipeapp.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import origamis.springframework.springrecipeapp.domain.Recipe;
import origamis.springframework.springrecipeapp.services.RecipeService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class IndexControllerTest {

    @InjectMocks
    IndexController indexController;

    @Mock
    RecipeService recipeService;

    @Test
    void getIndexPage() {
        // arrange
        var model = mock(Model.class);
        var argumentCaptor = ArgumentCaptor.forClass(Set.class);
        var recipe1 = new Recipe();
        recipe1.setId(1L);
        var recipe2 = new Recipe();
        recipe2.setId(2L);

        when(recipeService.getRecipes()).thenReturn(Set.of(recipe1, recipe2));

        // act
        String viewName = indexController.getIndexPage(model);

        // assert
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        assertEquals(2, argumentCaptor.getValue().size());
    }

    @Test
    public void testMockMVC() throws Exception {
        // arrange
        var mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}