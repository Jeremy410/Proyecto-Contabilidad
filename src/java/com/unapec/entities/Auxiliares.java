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
@Table(name = "AUXILIARES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auxiliares.findAll", query = "SELECT a FROM Auxiliares a"),
    @NamedQuery(name = "Auxiliares.findById", query = "SELECT a FROM Auxiliares a WHERE a.id = :id"),
    @NamedQuery(name = "Auxiliares.findByDescripcion", query = "SELECT a FROM Auxiliares a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Auxiliares.findByEstado", query = "SELECT a FROM Auxiliares a WHERE a.estado = :estado")})
public class Auxiliares implements Serializable {

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
    @Column(name = "ESTADO")
    private BigInteger estado;

    public Auxiliares() {
    }

    public Auxiliares(BigDecimal id) {
        this.id = id;
    }

    public Auxiliares(BigDecimal id, String descripcion, BigInteger estado) {
        this.id = id;
        this.descripcion = descripcion;
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
        if (!(object instanceof Auxiliares)) {
            return false;
        }
        Auxiliares other = (Auxiliares) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unapec.entities.Auxiliares[ id=" + id + " ]";
    }
    
}
