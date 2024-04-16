package dmacc.beans;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHOPPING_LIST_ID")
    private long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "SHOPPING_LIST_INGREDIENTS",
        joinColumns = {@JoinColumn(name = "SHOPPING_LIST_ID", referencedColumnName = "SHOPPING_LIST_ID")},
        inverseJoinColumns = {@JoinColumn(name = "INGREDIENT_ID", referencedColumnName = "INGREDIENT_ID")}
    )
    private List<Ingredients> ingredients;

    // Constructors

    public ShoppingList() {
        super();
    }

    public ShoppingList(long id, List<Ingredients> ingredients) {
        super();
        this.id = id;
        this.ingredients = ingredients;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    // toString() method

    @Override
    public String toString() {
        return "ShoppingList [id=" + id + ", ingredients=" + ingredients + "]";
    }
}