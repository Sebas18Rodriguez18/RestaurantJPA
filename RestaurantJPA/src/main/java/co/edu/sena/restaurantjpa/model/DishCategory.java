/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sebas
 */
@Entity
@Table(name = "dish_category")
@NamedQueries({
    @NamedQuery(name = "DishCategory.findAll", query = "SELECT d FROM DishCategory d"),
    @NamedQuery(name = "DishCategory.findById", query = "SELECT d FROM DishCategory d WHERE d.id = :id"),
    @NamedQuery(name = "DishCategory.findByName", query = "SELECT d FROM DishCategory d WHERE d.name = :name"),
    @NamedQuery(name = "DishCategory.findByDescription", query = "SELECT d FROM DishCategory d WHERE d.description = :description")})
public class DishCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<Dish> dishCollection;

    public DishCategory() {
    }

    public DishCategory(Long id) {
        this.id = id;
    }

    public DishCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Dish> getDishCollection() {
        return dishCollection;
    }

    public void setDishCollection(Collection<Dish> dishCollection) {
        this.dishCollection = dishCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DishCategory)) {
            return false;
        }
        DishCategory other = (DishCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.restaurantjpa.model.DishCategory[ id=" + id + " ]";
    }
    
}
