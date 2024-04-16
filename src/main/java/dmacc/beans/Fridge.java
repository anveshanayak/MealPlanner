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
public class Fridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FRIDGE_ID")
    private long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "FRIDGE_INGREDIENTS",
        joinColumns = {@JoinColumn(name = "FRIDGE_ID", referencedColumnName = "FRIDGE_ID")},
        inverseJoinColumns = {@JoinColumn(name = "INGREDIENT_ID", referencedColumnName = "INGREDIENT_ID")}
    )
    private List<Ingredients> ingredients;

    // Constructors

    public Fridge() {
        super();
    }

    public Fridge(long id, List<Ingredients> ingredients) {
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
        return "Fridge [id=" + id + ", ingredients=" + ingredients + "]";
    }
}