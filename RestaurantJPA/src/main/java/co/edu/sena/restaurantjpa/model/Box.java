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
    @NamedQuery(name = "Box.findByNombre", query = "SELECT b FROM Box b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Box.findByEstado", query = "SELECT b FROM Box b WHERE b.estado = :estado"),
    @NamedQuery(name = "Box.findBySaldoInicial", query = "SELECT b FROM Box b WHERE b.saldoInicial = :saldoInicial"),
    @NamedQuery(name = "Box.findBySaldoActual", query = "SELECT b FROM Box b WHERE b.saldoActual = :saldoActual")})
public class Box implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "saldo_inicial")
    private BigDecimal saldoInicial;
    @Basic(optional = false)
    @Column(name = "saldo_actual")
    private BigDecimal saldoActual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cajaId")
    private Collection<Pay> payCollection;
    @JoinColumn(name = "cajero_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users cajeroId;
    @OneToMany(mappedBy = "cajaId")
    private Collection<Order> order1Collection;

    public Box() {
    }

    public Box(Long id) {
        this.id = id;
    }

    public Box(Long id, String nombre, String estado, BigDecimal saldoInicial, BigDecimal saldoActual) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.saldoInicial = saldoInicial;
        this.saldoActual = saldoActual;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public BigDecimal getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(BigDecimal saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Collection<Pay> getPayCollection() {
        return payCollection;
    }

    public void setPayCollection(Collection<Pay> payCollection) {
        this.payCollection = payCollection;
    }

    public Users getCajeroId() {
        return cajeroId;
    }

    public void setCajeroId(Users cajeroId) {
        this.cajeroId = cajeroId;
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
