/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.entities.sesionbeanpackage;

import ec.mil.he1.entidades.SegGrupoSistema;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author christian_ruiz
 */
public class SegGrupoSistemaFacadeTest {
    
    public SegGrupoSistemaFacadeTest() {
    }
    
    @Ignore
    public void testCreate() throws Exception {
        System.out.println("create");
        SegGrupoSistema entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SegGrupoSistemaFacade instance = (SegGrupoSistemaFacade) container.getContext().lookup("java:global/classes/SegGrupoSistemaFacade");
        instance.create(entity);
        container.close();
        fail("The test case is a prototype.");
    }
    
    @Ignore
    public void testEdit() throws Exception {
        System.out.println("edit");
        SegGrupoSistema entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SegGrupoSistemaFacade instance = (SegGrupoSistemaFacade) container.getContext().lookup("java:global/classes/SegGrupoSistemaFacade");
        instance.edit(entity);
        container.close();
        fail("The test case is a prototype.");
    }
    
    @Ignore
    public void testRemove() throws Exception {
        System.out.println("remove");
        SegGrupoSistema entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SegGrupoSistemaFacade instance = (SegGrupoSistemaFacade) container.getContext().lookup("java:global/classes/SegGrupoSistemaFacade");
        instance.remove(entity);
        container.close();
        fail("The test case is a prototype.");
    }
    
    @Ignore
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SegGrupoSistemaFacade instance = (SegGrupoSistemaFacade) container.getContext().lookup("java:global/classes/SegGrupoSistemaFacade");
        SegGrupoSistema expResult = null;
        SegGrupoSistema result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SegGrupoSistemaFacade instance = (SegGrupoSistemaFacade) container.getContext().lookup("java:global/classes/SegGrupoSistemaFacade");
        List<SegGrupoSistema> expResult = null;
        List<SegGrupoSistema> result = instance.findAll();
        assertEquals(expResult, result);
        Assert.assertTrue("SE ejecuta correctamente", true);
        container.close();
        fail("The test case is a prototype.");
    }
    
    @Ignore
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SegGrupoSistemaFacade instance = (SegGrupoSistemaFacade) container.getContext().lookup("java:global/classes/SegGrupoSistemaFacade");
        List<SegGrupoSistema> expResult = null;
        List<SegGrupoSistema> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }
    
    @Ignore
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SegGrupoSistemaFacade instance = (SegGrupoSistemaFacade) container.getContext().lookup("java:global/classes/SegGrupoSistemaFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }
    
}
