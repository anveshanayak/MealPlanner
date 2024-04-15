-- Drop database if exists
DROP DATABASE IF EXISTS mealplanner_db;

-- Create the database (change 'mealplan_db' to your desired database name)
CREATE DATABASE mealplan_db;

-- Use the created database
USE mealplan_db;

-- Create Ingredients table
CREATE TABLE Ingredients (
    INGREDIENT_ID BIGINT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(255) NOT NULL,
    CATEGORY VARCHAR(255),
    PRIMARY KEY (INGREDIENT_ID)
);

-- Create Recipes table
CREATE TABLE Recipes (
    RECIPE_ID BIGINT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(255) NOT NULL,
    CATEGORY VARCHAR(255),
    PRIMARY KEY (RECIPE_ID)
);

-- Create MealPlan table
CREATE TABLE MealPlan (
    MEAL_ID BIGINT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (MEAL_ID)
);

-- Create join table for Recipes and Ingredients (many-to-many relationship)
CREATE TABLE RecipeIngredients (
    RECIPE_ID BIGINT NOT NULL,
    INGREDIENT_ID BIGINT NOT NULL,
    CONSTRAINT FK_RecipeIngredients_Recipe FOREIGN KEY (RECIPE_ID) REFERENCES Recipes(RECIPE_ID),
    CONSTRAINT FK_RecipeIngredients_Ingredient FOREIGN KEY (INGREDIENT_ID) REFERENCES Ingredients(INGREDIENT_ID),
    PRIMARY KEY (RECIPE_ID, INGREDIENT_ID)
);

-- Create join table for MealPlan and Recipes (one-to-many relationship)
CREATE TABLE MealPlanRecipes (
    MEAL_ID BIGINT NOT NULL,
    RECIPE_ID BIGINT NOT NULL,
    CONSTRAINT FK_MealPlanRecipes_MealPlan FOREIGN KEY (MEAL_ID) REFERENCES MealPlan(MEAL_ID),
    CONSTRAINT FK_MealPlanRecipes_Recipe FOREIGN KEY (RECIPE_ID) REFERENCES Recipes(RECIPE_ID),
    PRIMARY KEY (MEAL_ID, RECIPE_ID)
);
