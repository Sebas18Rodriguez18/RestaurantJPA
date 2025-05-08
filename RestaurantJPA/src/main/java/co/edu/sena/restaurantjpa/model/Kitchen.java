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
@Table(name = "kitchen")
@NamedQueries({
    @NamedQuery(name = "Kitchen.findAll", query = "SELECT k FROM Kitchen k"),
    @NamedQuery(name = "Kitchen.findById", query = "SELECT k FROM Kitchen k WHERE k.id = :id"),
    @NamedQuery(name = "Kitchen.findByNombre", query = "SELECT k FROM Kitchen k WHERE k.nombre = :nombre"),
    @NamedQuery(name = "Kitchen.findByDescripcion", query = "SELECT k FROM Kitchen k WHERE k.descripcion = :descripcion")})
public class Kitchen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "encargado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users encargadoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cocinaId")
    private Collection<Order> order1Collection;

    public Kitchen() {
    }

    public Kitchen(Long id) {
        this.id = id;
    }

    public Kitchen(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Users getEncargadoId() {
        return encargadoId;
    }

    public void setEncargadoId(Users encargadoId) {
        this.encargadoId = encargadoId;
    }

    public Collection<Order> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order> order1Collection) {
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
        if (!(object instanceof Kitchen)) {
            return false;
        }
        Kitchen other = (Kitchen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.restaurantjpa.model.Kitchen[ id=" + id + " ]";
    }
    
}
