package org.launchcode.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    // This points to some verribles
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    //added this
    @OneToMany
    @JoinColumn(name="category_id")
    private List<Cheese> cheeses = new ArrayList<>();
    //end add this

    //This points to constructoirs
    public Category() {};

    public Category(String name) {
        this.name = name;
    }

    //Gets and sets
    public int getId() {return id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}
//added the next 2
    public List<Cheese> getCheeses() {return cheeses;}

    public String toString(){
        return name;
    }
}