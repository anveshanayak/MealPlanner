package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Ingredients;
import dmacc.beans.MealPlan;
import dmacc.beans.Recipes;

import dmacc.beans.Cookbook;
import dmacc.beans.Fridge;
import dmacc.beans.ShoppingList;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public MealPlan mealPlan() {
		MealPlan bean = new MealPlan();
		return bean;
	}
	
	@Bean
	public Recipes recipe() {
		Recipes bean = new Recipes();
		return bean;
	}

	@Bean
	public Ingredients ingredient() {
		Ingredients bean = new Ingredients();
		return bean;
	}
	@Bean
    public Fridge fridge() {
        Fridge bean = new Fridge();
        return bean;
    }

    @Bean
    public Cookbook cookbook() {
        Cookbook bean = new Cookbook();
        return bean;
    }

    @Bean
    public ShoppingList shoppingList() {
        ShoppingList bean = new ShoppingList();
        return bean;
    }
}