-- Drop database if exists
DROP DATABASE IF EXISTS mealplan_db;

-- Create the database (change 'mealplan_db' to your desired database name)
CREATE DATABASE mealplan_db;

-- Use the created database
USE mealplan_db;

-- Create IngredientsList table
CREATE TABLE IngredientsList (
    ingredient_id INT PRIMARY KEY AUTO_INCREMENT,
    ingredient_name VARCHAR(255) NOT NULL,
    -- Add other relevant columns as needed
    UNIQUE (ingredient_name)
);

-- Create FridgeItems table
CREATE TABLE FridgeItems (
    fridge_item_id INT PRIMARY KEY AUTO_INCREMENT,
    ingredient_id INT,
    ingredient_name VARCHAR(25) NOT NULL,
    quantity INT,
    -- Add other relevant columns as needed
    FOREIGN KEY (ingredient_id) REFERENCES IngredientsList(ingredient_id)
);

-- Create ShoppingList table
CREATE TABLE ShoppingList (
    shopping_item_id INT PRIMARY KEY AUTO_INCREMENT,
    ingredient_id INT,
    -- Add other relevant columns as needed
    FOREIGN KEY (ingredient_id) REFERENCES IngredientsList(ingredient_id)
);

-- Create Recipes table
CREATE TABLE RecipesList (
    RECIPE_ID INT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(255) NOT NULL,
    PRIMARY KEY (RECIPE_ID)
);

-- Create MealPlan table
CREATE TABLE MealPlan (
    MEAL_ID INT NOT NULL AUTO_INCREMENT,
    RECIPE_ID INT NOT NULL,
    MEAL_NAME VARCHAR(25) NOT NULL,
    DAY_OF_THE_WEEK ENUM('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday') NOT NULL,
    TIME_OF_DAY ENUM('Breakfast', 'Lunch', 'Dinner') NOT NULL,
    PRIMARY KEY (MEAL_ID),
    CONSTRAINT FK_MealPlanRecipes_Recipe FOREIGN KEY (RECIPE_ID) REFERENCES RecipesList(RECIPE_ID)
);

-- Create join table for Recipes and Ingredients (many-to-many relationship)
CREATE TABLE RecipeIngredients (
    RECIPE_ID INT NOT NULL,
    INGREDIENT_ID INT NOT NULL,
    CONSTRAINT FK_RecipeIngredients_Recipe FOREIGN KEY (RECIPE_ID) REFERENCES RecipesList(RECIPE_ID),
    CONSTRAINT FK_RecipeIngredients_Ingredient FOREIGN KEY (INGREDIENT_ID) REFERENCES IngredientsList(INGREDIENT_ID),
    PRIMARY KEY (RECIPE_ID, INGREDIENT_ID)
);
