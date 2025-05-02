package origamis.springframework.springrecipeapp.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import origamis.springframework.springrecipeapp.services.RecipeService;

@Controller
@AllArgsConstructor
public class IndexController {

    private final RecipeService recipeService;

    @GetMapping({"/", "", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
