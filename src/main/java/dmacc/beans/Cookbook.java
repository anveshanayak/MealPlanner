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
public class Cookbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COOKBOOK_ID")
    private long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "COOKBOOK_RECIPES",
        joinColumns = {@JoinColumn(name = "COOKBOOK_ID", referencedColumnName = "COOKBOOK_ID")},
        inverseJoinColumns = {@JoinColumn(name = "RECIPE_ID", referencedColumnName = "RECIPE_ID")}
    )
    private List<Recipes> recipes;

    // Constructors

    public Cookbook() {
        super();
    }

    public Cookbook(long id, List<Recipes> recipes) {
        super();
        this.id = id;
        this.recipes = recipes;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Recipes> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipes> recipes) {
        this.recipes = recipes;
    }

    // toString() method

    @Override
    public String toString() {
        return "Cookbook [id=" + id + ", recipes=" + recipes + "]";
    }
}