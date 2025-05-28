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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Sebas
 */
@Entity
@javax.persistence.Table(name = "dining_table")
@NamedQueries({
    @NamedQuery(name = "DiningTable.findAll", query = "SELECT t FROM DiningTable t"),
    @NamedQuery(name = "DiningTable.findById", query = "SELECT t FROM DiningTable t WHERE t.id = :id"),
    @NamedQuery(name = "DiningTable.findByNumber", query = "SELECT t FROM DiningTable t WHERE t.number = :number"),
    @NamedQuery(name = "DiningTable.findByCapacity", query = "SELECT t FROM DiningTable t WHERE t.capacity = :capacity"),
    @NamedQuery(name = "DiningTable.findByStatus", query = "SELECT t FROM DiningTable t WHERE t.status = :status")})
public class DiningTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "number")
    private int number;
    @Basic(optional = false)
    @Column(name = "capacity")
    private int capacity;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinTable(name = "waiter_table", joinColumns = {
        @JoinColumn(name = "table_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "waiter_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Users> usersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tableId")
    private Collection<Order1> order1Collection;

    public DiningTable() {
    }

    public DiningTable(Long id) {
        this.id = id;
    }

    public DiningTable(Long id, int number, int capacity, String status) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
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
        if (!(object instanceof DiningTable)) {
            return false;
        }
        DiningTable other = (DiningTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.restaurantjpa.model.DiningTable[ id=" + id + " ]";
    }
    
}
