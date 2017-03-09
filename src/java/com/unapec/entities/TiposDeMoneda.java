/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jeremy Lopez
 */
@Entity
@Table(name = "TIPOS_DE_MONEDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposDeMoneda.findAll", query = "SELECT t FROM TiposDeMoneda t"),
    @NamedQuery(name = "TiposDeMoneda.findById", query = "SELECT t FROM TiposDeMoneda t WHERE t.id = :id"),
    @NamedQuery(name = "TiposDeMoneda.findByDescripcion", query = "SELECT t FROM TiposDeMoneda t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TiposDeMoneda.findByTasaCambiaria", query = "SELECT t FROM TiposDeMoneda t WHERE t.tasaCambiaria = :tasaCambiaria"),
    @NamedQuery(name = "TiposDeMoneda.findByEstado", query = "SELECT t FROM TiposDeMoneda t WHERE t.estado = :estado")})
public class TiposDeMoneda implements Serializable {

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
    @Column(name = "TASA_CAMBIARIA")
    private BigDecimal tasaCambiaria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private BigInteger estado;

    public TiposDeMoneda() {
    }

    public TiposDeMoneda(BigDecimal id) {
        this.id = id;
    }

    public TiposDeMoneda(BigDecimal id, String descripcion, BigDecimal tasaCambiaria, BigInteger estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.tasaCambiaria = tasaCambiaria;
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

    public BigDecimal getTasaCambiaria() {
        return tasaCambiaria;
    }

    public void setTasaCambiaria(BigDecimal tasaCambiaria) {
        this.tasaCambiaria = tasaCambiaria;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
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
        if (!(object instanceof TiposDeMoneda)) {
            return false;
        }
        TiposDeMoneda other = (TiposDeMoneda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unapec.entities.TiposDeMoneda[ id=" + id + " ]";
    }
    
}
