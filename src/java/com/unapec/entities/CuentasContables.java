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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CUENTAS_CONTABLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentasContables.findAll", query = "SELECT c FROM CuentasContables c"),
    @NamedQuery(name = "CuentasContables.findById", query = "SELECT c FROM CuentasContables c WHERE c.id = :id"),
    @NamedQuery(name = "CuentasContables.findByDescripcion", query = "SELECT c FROM CuentasContables c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CuentasContables.findByPermiteMovimiento", query = "SELECT c FROM CuentasContables c WHERE c.permiteMovimiento = :permiteMovimiento"),
    @NamedQuery(name = "CuentasContables.findByNivel", query = "SELECT c FROM CuentasContables c WHERE c.nivel = :nivel"),
    @NamedQuery(name = "CuentasContables.findByBalance", query = "SELECT c FROM CuentasContables c WHERE c.balance = :balance"),
    @NamedQuery(name = "CuentasContables.findByEstado", query = "SELECT c FROM CuentasContables c WHERE c.estado = :estado")})
public class CuentasContables implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERMITE_MOVIMIENTO")
    private BigInteger permiteMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NIVEL")
    private BigInteger nivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BALANCE")
    private BigDecimal balance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private BigInteger estado;
    @JoinColumn(name = "TIPO_CUENTA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TiposDeCuentas tipoCuenta;

    public CuentasContables() {
    }

    public CuentasContables(BigDecimal id) {
        this.id = id;
    }

    public CuentasContables(BigDecimal id, String descripcion, BigInteger permiteMovimiento, BigInteger nivel, BigDecimal balance, BigInteger estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.permiteMovimiento = permiteMovimiento;
        this.nivel = nivel;
        this.balance = balance;
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

    public BigInteger getPermiteMovimiento() {
        return permiteMovimiento;
    }

    public void setPermiteMovimiento(BigInteger permiteMovimiento) {
        this.permiteMovimiento = permiteMovimiento;
    }

    public BigInteger getNivel() {
        return nivel;
    }

    public void setNivel(BigInteger nivel) {
        this.nivel = nivel;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public TiposDeCuentas getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TiposDeCuentas tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
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
        if (!(object instanceof CuentasContables)) {
            return false;
        }
        CuentasContables other = (CuentasContables) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unapec.entities.CuentasContables[ id=" + id + " ]";
    }
    
}
