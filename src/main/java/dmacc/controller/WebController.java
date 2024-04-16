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

import dmacc.beans.Cookbook;
import dmacc.beans.Fridge;
import dmacc.beans.ShoppingList;

import dmacc.repository.CookbookRepository;
import dmacc.repository.FridgeRepository;
import dmacc.repository.ShoppingListRepository;


@Controller
public class WebController {
	@Autowired
	RecipeRepository recipeRepo;
	@Autowired
	ingredientsRepository ingredientsRepo;
	@Autowired
	MealPlanRepository mealPlanRepo;

	@Autowired
    FridgeRepository fridgeRepo;
    @Autowired
    CookbookRepository cookbookRepo;
    @Autowired
    ShoppingListRepository shoppingListRepo;

	
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

	// --------- Fridge Navigation -----------
    @GetMapping("viewFridge")
    public String viewFridge(Model model) {
        if (fridgeRepo.findAll().isEmpty()) {
            return addToFridge(model);
        }
        model.addAttribute("fridge", fridgeRepo.findAll().get(0));
        return "fridgeView";
    }

    @GetMapping("/addToFridge")
    public String addToFridge(Model model) {
        Fridge fridge = new Fridge();
        model.addAttribute("fridge", fridge);
        model.addAttribute("ingredients", ingredientsRepo.findAll());
        return "addToFridge";
    }

    @PostMapping("/updateFridge")
    public String updateFridge(Fridge fridge) {
        fridgeRepo.save(fridge);
        return "redirect:/viewFridge";
    }

    // --------- Cookbook Navigation -----------
    @GetMapping("viewCookbook")
    public String viewCookbook(Model model) {
        if (cookbookRepo.findAll().isEmpty()) {
            return addToCookbook(model);
        }
        model.addAttribute("cookbook", cookbookRepo.findAll().get(0));
        return "cookbookView";
    }

    @GetMapping("/addToCookbook")
    public String addToCookbook(Model model) {
        Cookbook cookbook = new Cookbook();
        model.addAttribute("cookbook", cookbook);
        model.addAttribute("recipes", recipeRepo.findAll());
        return "addToCookbook";
    }

    @PostMapping("/updateCookbook")
    public String updateCookbook(Cookbook cookbook) {
        cookbookRepo.save(cookbook);
        return "redirect:/viewCookbook";
    }

    // --------- ShoppingList Navigation -----------
    @GetMapping("viewShoppingList")
    public String viewShoppingList(Model model) {
        if (shoppingListRepo.findAll().isEmpty()) {
            return generateShoppingList(model);
        }
        model.addAttribute("shoppingList", shoppingListRepo.findAll().get(0));
        return "shoppingListView";
    }

    @GetMapping("/generateShoppingList")
    public String generateShoppingList(Model model) {
        // Logic to generate the shopping list based on the recipes and the fridge
        ShoppingList shoppingList = new ShoppingList();
        model.addAttribute("shoppingList", shoppingList);
        return "generateShoppingList";
    }

    @PostMapping("/updateShoppingList")
    public String updateShoppingList(ShoppingList shoppingList) {
        shoppingListRepo.save(shoppingList);
        return "redirect:/viewShoppingList";
    }

}