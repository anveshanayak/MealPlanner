
CREATE DATABASE IF NOT EXISTS mealplan_db;

USE mealplan_db;

CREATE TABLE IF NOT EXISTS FridgeItems (
    ingredient_name VARCHAR(25) PRIMARY KEY NOT NULL,
    quantity INT
);

CREATE TABLE IF NOT EXISTS ShoppingList (
    ingredient_name VARCHAR(25) PRIMARY KEY NOT NULL,
    quantity INT
);


CREATE TABLE IF NOT EXISTS MealPlan (
    MEAL_NAME VARCHAR(25) NOT NULL,
    DAY_OF_THE_WEEK ENUM('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday') NOT NULL,
    TIME_OF_DAY ENUM('Breakfast', 'Lunch', 'Dinner') NOT NULL
);

CREATE TABLE IF NOT EXISTS RecipeIngredients (
    RECIPE_NAME VARCHAR(25) NOT NULL,
    INGREDIENT_NAME VARCHAR(25) NOT NULL,
    PRIMARY KEY (RECIPE_NAME, INGREDIENT_NAME),
    quantity INT
);

INSERT INTO FridgeItems values ('Cheese',200),('Carrot',100),('Beans',200),('Palak',100),('Mango',200);
INSERT INTO ShoppingList values ('Onion',200),('Rice',100),('Atta',200),('Salt',100),('Bread',200);
INSERT INTO RecipeIngredients values ('Roti','Atta',300),('Roti','Water',0.2),('Roti','Salt',5),('Roti','Ghee',10);
INSERT INTO MealPlan values ('Roti','Monday','Breakfast');
