package com.example.Ish.I.Like.To.Cook.controllers;

import com.example.Ish.I.Like.To.Cook.models.Recipe;
import com.example.Ish.I.Like.To.Cook.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("recipes", recipeRepository.findAll());
        return "index";
    }

    @GetMapping("recipes/add")
    public String displayAddRecipeForm(Model model) {
        model.addAttribute(new Recipe());
        return "add";
    }

    @PostMapping("recipes/add")
    public String processAddEmployerForm(@ModelAttribute Recipe newRecipe,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "add";
        }

        recipeRepository.save(newRecipe);
        model.addAttribute("recipes", recipeRepository.findAll());
        return "redirect:../";
    }

    @GetMapping("recipes/view/{recipeId}")
    public String displayViewEmployer(Model model, @PathVariable int recipeId) {

        Optional optRecipe = recipeRepository.findById(recipeId);
        if (optRecipe.isPresent()) {
            Recipe recipe = (Recipe) optRecipe.get();
            model.addAttribute("recipe", recipe);
            return "view";
        } else {
            return "redirect:../";
        }
    }

}
