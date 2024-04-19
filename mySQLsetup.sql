
CREATE DATABASE IF NOT EXISTS mealplan_db;

USE mealplan_db;

CREATE TABLE IF NOT EXISTS FridgeItems (
    ingredient_id INT NOT NULL PRIMARY KEY
    ingredient_name VARCHAR(25) NOT NULL,
    quantity INT
);

CREATE TABLE IF NOT EXISTS ShoppingList (
    ingredient_id INT NOT NULL PRIMARY KEY
    ingredient_name VARCHAR(25) NOT NULL,
    quantity INT
);


CREATE TABLE IF NOT EXISTS MealPlan (
    MEAL_NAME VARCHAR(25) NOT NULL,
    DAY_OF_THE_WEEK ENUM('Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday') NOT NULL,
    TIME_OF_DAY ENUM('Breakfast', 'Lunch', 'Dinner') NOT NULL,
    PRIMARY KEY (MEAL_NAME, DAY_OF_THE_WEEK, TIME_OF_DAY)
);

CREATE TABLE IF NOT EXISTS RecipeIngredients (
    RECIPE_ID INT NOT NULL AUTO_INCREMENT,
    RECIPE_NAME VARCHAR(25) NOT NULL,
    INGREDIENT_ID INT NOT NULL AUTO_INCREMENT,
    INGREDIENT_NAME VARCHAR(25) NOT NULL,
    PRIMARY KEY (RECIPE_ID, INGREDIENT_ID),
    quantity INT
);

INSERT INTO FridgeItems values (5, 'Cheese',200),(6, 'Carrot',100),(7, 'Beans',200),(8, 'Palak',100),(9, 'Mango',200), (4, 'Ghee',100);
INSERT INTO ShoppingList values (10, 'Onion',200),(11, 'Rice',100),(1,'Atta',200),(2, 'Salt',100),(12, 'Bread',200), (3, 'Salt',5);
INSERT INTO RecipeIngredients values (1,'Roti', 1,'Atta',300),(1,'Roti', 2,'Water',0.2),(1,'Roti', 3,'Salt',5),(1,'Roti', 4,'Ghee',10);
INSERT INTO MealPlan values ('Roti','Monday','Breakfast');
