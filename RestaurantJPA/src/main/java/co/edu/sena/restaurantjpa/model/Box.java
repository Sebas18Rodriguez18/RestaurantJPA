/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sebas
 */
@Entity
@Table(name = "box")
@NamedQueries({
    @NamedQuery(name = "Box.findAll", query = "SELECT b FROM Box b"),
    @NamedQuery(name = "Box.findById", query = "SELECT b FROM Box b WHERE b.id = :id"),
    @NamedQuery(name = "Box.findByName", query = "SELECT b FROM Box b WHERE b.name = :name"),
    @NamedQuery(name = "Box.findByStatus", query = "SELECT b FROM Box b WHERE b.status = :status"),
    @NamedQuery(name = "Box.findByInitialBalance", query = "SELECT b FROM Box b WHERE b.initialBalance = :initialBalance"),
    @NamedQuery(name = "Box.findByCurrentBalance", query = "SELECT b FROM Box b WHERE b.currentBalance = :currentBalance")})
public class Box implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "initial_balance")
    private BigDecimal initialBalance;
    @Basic(optional = false)
    @Column(name = "current_balance")
    private BigDecimal currentBalance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boxId")
    private Collection<Pay> payCollection;
    @JoinColumn(name = "cashier_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users cashierId;
    @OneToMany(mappedBy = "boxId")
    private Collection<Order1> order1Collection;

    public Box() {
    }

    public Box(Long id) {
        this.id = id;
    }

    public Box(Long id, String name, String status, BigDecimal initialBalance, BigDecimal currentBalance) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.initialBalance = initialBalance;
        this.currentBalance = currentBalance;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Collection<Pay> getPayCollection() {
        return payCollection;
    }

    public void setPayCollection(Collection<Pay> payCollection) {
        this.payCollection = payCollection;
    }

    public Users getCashierId() {
        return cashierId;
    }

    public void setCashierId(Users cashierId) {
        this.cashierId = cashierId;
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
        if (!(object instanceof Box)) {
            return false;
        }
        Box other = (Box) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.restaurantjpa.model.Box[ id=" + id + " ]";
    }
    
}
