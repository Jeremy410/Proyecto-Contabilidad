/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.entities.sessions;

import com.unapec.entities.CuentasContables;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jeremy Lopez
 */
@Stateless
public class CuentasContablesFacade extends AbstractFacade<CuentasContables> {

    @PersistenceContext(unitName = "Contabilidad_IIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentasContablesFacade() {
        super(CuentasContables.class);
    }
    
}
