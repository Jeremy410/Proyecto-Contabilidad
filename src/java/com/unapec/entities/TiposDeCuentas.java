/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jeremy Lopez
 */
@Entity
@Table(name = "TIPOS_DE_CUENTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeCuentas.findAll", query = "SELECT t FROM TiposDeCuentas t"),
    @NamedQuery(name = "TiposDeCuentas.findById", query = "SELECT t FROM TiposDeCuentas t WHERE t.id = :id"),
    @NamedQuery(name = "TiposDeCuentas.findByDescripcion", query = "SELECT t FROM TiposDeCuentas t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TiposDeCuentas.findByOrigen", query = "SELECT t FROM TiposDeCuentas t WHERE t.origen = :origen"),
    @NamedQuery(name = "TiposDeCuentas.findByEstado", query = "SELECT t FROM TiposDeCuentas t WHERE t.estado = :estado")})
public class TiposDeCuentas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ORIGEN")
    private String origen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private BigInteger estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCuenta")
    private Collection<CuentasContables> cuentasContablesCollection;

    public TiposDeCuentas() {
    }

    public TiposDeCuentas(BigDecimal id) {
        this.id = id;
    }

    public TiposDeCuentas(BigDecimal id, String descripcion, String origen, BigInteger estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.origen = origen;
        this.estado = estado;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<CuentasContables> getCuentasContablesCollection() {
        return cuentasContablesCollection;
    }

    public void setCuentasContablesCollection(Collection<CuentasContables> cuentasContablesCollection) {
        this.cuentasContablesCollection = cuentasContablesCollection;
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
        if (!(object instanceof TiposDeCuentas)) {
            return false;
        }
        TiposDeCuentas other = (TiposDeCuentas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unapec.entities.TiposDeCuentas[ id=" + id + " ]";
    }
    
}
