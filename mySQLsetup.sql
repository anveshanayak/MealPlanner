CREATE DATABASE IF NOT EXISTS mealplan_db;

USE mealplan_db;

CREATE TABLE FridgeItems (
    ingredient_name VARCHAR(25) PRIMARY KEY NOT NULL,
    quantity INT
);

CREATE TABLE ShoppingList (
    ingredient_name VARCHAR(25) PRIMARY KEY NOT NULL,
    quantity INT
);


CREATE TABLE MealPlan (
    MEAL_NAME VARCHAR(25) NOT NULL,
    DAY_OF_THE_WEEK ENUM('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday') NOT NULL,
    TIME_OF_DAY ENUM('Breakfast', 'Lunch', 'Dinner') NOT NULL
);

CREATE TABLE RecipeIngredients (
    RECIPE_NAME VARCHAR(25) NOT NULL,
    INGREDIENT_NAME VARCHAR(25) NOT NULL,
    PRIMARY KEY (RECIPE_NAME, INGREDIENT_NAME)
);

