package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import dmacc.beans.Recipes;
import dmacc.beans.Ingredients;
import dmacc.repository.MealPlanRepository;
import dmacc.repository.RecipeRepository;
import dmacc.repository.ingredientsRepository;

@Controller
public class WebController {
	@Autowired
	RecipeRepository recipeRepo;
	@Autowired
	ingredientsRepository ingredientsRepo;
	@Autowired
	MealPlanRepository mealPlanRepo;


	
	@GetMapping("/toMenu")
	public String goToMenu(Model model) 
	{
		return "index";
	}
	@GetMapping("viewAllMeals")

	public String viewAllMealPlan(Model model) 
	{
		model.addAttribute("recipes", recipeRepo.findAll());
		model.addAttribute("ingredients", ingredientsRepo.findAll());
		return "mealPlanView";
	}
	
	
	
	//--------Recipe Navigation-----------
	
	@GetMapping("viewAllRecipes")
	public String viewAllRecipes(Model model) {
		if(recipeRepo.findAll().isEmpty()) 
		{
			return addNewRecipe(model);
		}
		model.addAttribute("recipes", recipeRepo.findAll());
		return "recipeView";
	}
	
	@GetMapping("/inputRecipe")
	public String addNewRecipe(Model model) {
		Recipes r = new Recipes();
		model.addAttribute("newRecipe", r);
		return "recipeInput";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateRecipe(@PathVariable("id") long id, Model model) {
		Recipes r = recipeRepo.findById(id).orElse(null);
		System.out.println("RECIPE TO EDIT: " + r.toString());
		model.addAttribute("newRecipe", r);
		return "recipeInput";
	}
	
	@PostMapping("/update/{id}")
	public String reviseRecipe(Recipes r, Model model) {
		recipeRepo.save(r);
		return viewAllRecipes(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Recipes r = recipeRepo.findById(id).orElse(null);
	    recipeRepo.delete(r);
	    return viewAllRecipes(model);
	}

	//--------Ingredients Navigation-----------
	@GetMapping("viewAllIngredients")
	public String viewAllIngredients(Model model) {
		if(ingredientsRepo.findAll().isEmpty()) 
		{
			return addNewIngredient(model);
		}
		model.addAttribute("ingredients", ingredientsRepo.findAll());
		return "ingredientsView";
	}
	
	@GetMapping("/inputIngredient")
	public String addNewIngredient(Model model) 
	{
		Ingredients i = new Ingredients();
		model.addAttribute("newIngredient", i);
		return"ingredientInput";
	}
	
	@PostMapping("/updateIngredient/{id}")
	public String reviseIngredient(Ingredients i, Model model) {
		ingredientsRepo.save(i);
		return viewAllIngredients(model);
	}
	
	@GetMapping("/editIngredients/{id}")
	public String showUpdateIngredients(@PathVariable("id") long id, Model model) 
	{
		Ingredients i = ingredientsRepo.findById(id).orElse(null);
		model.addAttribute("newIngredients", i);
		return "ingredientInput";
	}
	
	@GetMapping("/deleteIngredients/{id}")
	public String deleteIngredients(@PathVariable("id") long id, Model model) 
	{
		Ingredients i = ingredientsRepo.findById(id).orElse(null);
		ingredientsRepo.delete(i);
		return "ingredientsView";
	}



}