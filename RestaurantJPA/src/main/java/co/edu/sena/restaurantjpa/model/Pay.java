/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sebas
 */
@Entity
@Table(name = "pay")
@NamedQueries({
    @NamedQuery(name = "Pay.findAll", query = "SELECT p FROM Pay p"),
    @NamedQuery(name = "Pay.findById", query = "SELECT p FROM Pay p WHERE p.id = :id"),
    @NamedQuery(name = "Pay.findByMetodoPago", query = "SELECT p FROM Pay p WHERE p.metodoPago = :metodoPago"),
    @NamedQuery(name = "Pay.findByMonto", query = "SELECT p FROM Pay p WHERE p.monto = :monto"),
    @NamedQuery(name = "Pay.findByFechaPago", query = "SELECT p FROM Pay p WHERE p.fechaPago = :fechaPago")})
public class Pay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "metodo_pago")
    private String metodoPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @JoinColumn(name = "caja_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Box cajaId;
    @JoinColumn(name = "orden_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Order ordenId;

    public Pay() {
    }

    public Pay(Long id) {
        this.id = id;
    }

    public Pay(Long id, String metodoPago, BigDecimal monto, Date fechaPago) {
        this.id = id;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Box getCajaId() {
        return cajaId;
    }

    public void setCajaId(Box cajaId) {
        this.cajaId = cajaId;
    }

    public Order getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Order ordenId) {
        this.ordenId = ordenId;
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
        if (!(object instanceof Pay)) {
            return false;
        }
        Pay other = (Pay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.restaurantjpa.model.Pay[ id=" + id + " ]";
    }
    
}
