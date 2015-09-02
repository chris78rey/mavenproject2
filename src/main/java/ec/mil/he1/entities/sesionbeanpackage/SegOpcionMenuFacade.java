/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.entities.sesionbeanpackage;

import ec.mil.he1.entidades.SegOpcionMenu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author christian_ruiz
 */
@Stateless
public class SegOpcionMenuFacade extends AbstractFacade<SegOpcionMenu> {
    @PersistenceContext(unitName = "PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegOpcionMenuFacade() {
        super(SegOpcionMenu.class);
    }
    
}
