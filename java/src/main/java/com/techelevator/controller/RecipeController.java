package com.techelevator.controller;


import com.techelevator.dao.RecipeExistsException;
import com.techelevator.model.ExternalRecipeModel;
import com.techelevator.model.Recipe;
import com.techelevator.services.RecipeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
@CrossOrigin
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(path = "/recipes", method = RequestMethod.GET)
    public List<Recipe> recipeSearch(@RequestParam String searchWord) {
        return recipeService.searchRecipes(searchWord);
    }

    @RequestMapping(path = "/recipes/import", method = RequestMethod.GET)
    public boolean importRecipe() throws RecipeExistsException {
        return recipeService.importRecipe();
    }

}
