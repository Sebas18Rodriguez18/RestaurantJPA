/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.restaurantjpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sebas
 */
@Entity
@Table(name = "order")
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id"),
<<<<<<< Updated upstream
    @NamedQuery(name = "Order1.findByFecha", query = "SELECT o FROM Order1 o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "Order1.findByEstado", query = "SELECT o FROM Order1 o WHERE o.estado = :estado"),
=======
    @NamedQuery(name = "Order1.findByDate", query = "SELECT o FROM Order1 o WHERE o.date = :date"),
    @NamedQuery(name = "Order1.findByStatus", query = "SELECT o FROM Order1 o WHERE o.status = :status"),
>>>>>>> Stashed changes
    @NamedQuery(name = "Order1.findByTotal", query = "SELECT o FROM Order1 o WHERE o.total = :total")})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
<<<<<<< Updated upstream
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
=======
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
>>>>>>> Stashed changes
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total")
    private BigDecimal total;
<<<<<<< Updated upstream
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenId")
    private Collection<Pay> payCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenId")
    private Collection<OrderDetails> orderDetailsCollection;
    @JoinColumn(name = "caja_id", referencedColumnName = "id")
    @ManyToOne
    private Box cajaId;
    @JoinColumn(name = "cocina_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Kitchen cocinaId;
    @JoinColumn(name = "mesa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private co.edu.sena.restaurantjpa.model.Table mesaId;
    @JoinColumn(name = "mesero_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users meseroId;
=======
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<Pay> payCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<OrderDetails> orderDetailsCollection;
    @JoinColumn(name = "box_id", referencedColumnName = "id")
    @ManyToOne
    private Box boxId;
    @JoinColumn(name = "kitchen_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Kitchen kitchenId;
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private co.edu.sena.restaurantjpa.model.Table tableId;
    @JoinColumn(name = "waiter_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users waiterId;
>>>>>>> Stashed changes

    public Order() {
    }

    public Order(Long id) {
        this.id = id;
    }

<<<<<<< Updated upstream
    public Order(Long id, Date fecha, String estado, BigDecimal total) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
=======
    public Order(Long id, Date date, String status, BigDecimal total) {
        this.id = id;
        this.date = date;
        this.status = status;
>>>>>>> Stashed changes
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< Updated upstream
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
=======
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
>>>>>>> Stashed changes
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Collection<Pay> getPayCollection() {
        return payCollection;
    }

    public void setPayCollection(Collection<Pay> payCollection) {
        this.payCollection = payCollection;
    }

    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

<<<<<<< Updated upstream
    public Box getCajaId() {
        return cajaId;
    }

    public void setCajaId(Box cajaId) {
        this.cajaId = cajaId;
    }

    public Kitchen getCocinaId() {
        return cocinaId;
    }

    public void setCocinaId(Kitchen cocinaId) {
        this.cocinaId = cocinaId;
    }

    public co.edu.sena.restaurantjpa.model.Table getMesaId() {
        return mesaId;
    }

    public void setMesaId(co.edu.sena.restaurantjpa.model.Table mesaId) {
        this.mesaId = mesaId;
    }

    public Users getMeseroId() {
        return meseroId;
    }

    public void setMeseroId(Users meseroId) {
        this.meseroId = meseroId;
=======
    public Box getBoxId() {
        return boxId;
    }

    public void setBoxId(Box boxId) {
        this.boxId = boxId;
    }

    public Kitchen getKitchenId() {
        return kitchenId;
    }

    public void setKitchenId(Kitchen kitchenId) {
        this.kitchenId = kitchenId;
    }

    public co.edu.sena.restaurantjpa.model.Table getTableId() {
        return tableId;
    }

    public void setTableId(co.edu.sena.restaurantjpa.model.Table tableId) {
        this.tableId = tableId;
    }

    public Users getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Users waiterId) {
        this.waiterId = waiterId;
>>>>>>> Stashed changes
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
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.restaurantjpa.model.Order1[ id=" + id + " ]";
    }
    
}
