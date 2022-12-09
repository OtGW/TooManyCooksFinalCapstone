package com.techelevator.dao;

import com.techelevator.model.Recipe;
import com.techelevator.services.RecipeService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcRecipeDaoTest extends BaseDaoTests{

    @Test
    public void getUserRecipes() {
    }

    @Test
    public void searchRecipes() {
    }

    @Test
    public void searchRecipesByIngredients() {
    }

    @Test
    public void getRecipe() {
    }

    @Test
    public void doesRecipeExist() {
    }

    @Test
    public void addRecipe() {
        RecipeDao recipeDao = getRecipeDao();
        RecipeService recipeService = getRecipeService();
        Recipe recipe = recipeDao.getRecipe(1);;

        recipeDao.addRecipe(recipe);

        recipe = recipeDao.getRecipe(1);
        Assert.assertEquals(1, recipe);
    }

    @Test
    public void updateRecipe_quantity_returns_success() {
        RecipeService recipeService = getRecipeService();
        Recipe recipe = recipeService.getRecipeById(1);
        recipe.getIngredients().get(0).setQuantity(5.0);

        recipeService.updateRecipe(recipe);

        recipe = recipeService.getRecipeById(1);
        Assert.assertEquals(5.0, recipe.getIngredients().get(0).getQuantity(), .01);
    }

// Not necessary
//    @Test
//    public void deleteRecipe() {
//    }

    @Test
    public void saveRecipeToUserList_valid_recipe_returns_success() {
        RecipeDao recipeDao = getRecipeDao();

        recipeDao.saveRecipeToUserList(1,1);

        List<Recipe> recipes = recipeDao.getUserRecipes(1);
        Assert.assertEquals(1, recipes.size());

        Recipe recipe = recipes.get(0);
        Assert.assertEquals(1, recipe.getId());
    }

    @Test
    public void removeRecipeFromUserList_return_success() {
        RecipeDao recipeDao = getRecipeDao();

        List<Recipe> recipes = recipeDao.getUserRecipes(2);
        Assert.assertEquals(1, recipes.size());

        Recipe recipe = recipes.get(0);
        Assert.assertEquals(1, recipe.getId());

        recipeDao.removeRecipeFromUserList(2, 1);

        recipes = recipeDao.getUserRecipes(2);
        Assert.assertEquals(0, recipes.size());
    }

    private RecipeDao getRecipeDao() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        RecipeDao recipeDao = new JdbcRecipeDao(jdbcTemplate);
        return recipeDao;
    }

    private UserDao getUserDao() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        UserDao userDao = new JdbcUserDao(jdbcTemplate);
        return userDao;
    }

    private IngredientDao getIngredientDao() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        IngredientDao ingredientDao = new JdbcIngredientDao(jdbcTemplate);
        return ingredientDao;
    }

    private RecipeService getRecipeService() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        RecipeService recipeService = new RecipeService(getRecipeDao(), getIngredientDao(), getUserDao());
        return recipeService;
    }

}