package ec.mil.he1.entities.jsfclasespackage;

import ec.mil.he1.entidades.SegGrupoSistema;
import ec.mil.he1.entities.jsfclasespackage.util.JsfUtil;
import ec.mil.he1.entities.jsfclasespackage.util.JsfUtil.PersistAction;
import ec.mil.he1.entities.sesionbeanpackage.SegGrupoSistemaFacade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("segGrupoSistemaController")
@SessionScoped
public class SegGrupoSistemaController implements Serializable {
    
    @EJB
    private ec.mil.he1.entities.sesionbeanpackage.SegGrupoSistemaFacade ejbFacade;
    private List<SegGrupoSistema> items = null;
    private SegGrupoSistema selected;
    
    public SegGrupoSistemaController() {
    }
    
    public SegGrupoSistema getSelected() {
        return selected;
    }
    
    public void setSelected(SegGrupoSistema selected) {
        this.selected = selected;
    }
    
    protected void setEmbeddableKeys() {
    }
    
    protected void initializeEmbeddableKey() {
    }
    
    private SegGrupoSistemaFacade getFacade() {
        return ejbFacade;
    }
    
    public SegGrupoSistema prepareCreate() {
        selected = new SegGrupoSistema();
        initializeEmbeddableKey();
        return selected;
    }
    
    public void create() {
        selected.setGruId(BigDecimal.ZERO);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SegGrupoSistemaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SegGrupoSistemaUpdated"));
    }
    
    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SegGrupoSistemaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public List<SegGrupoSistema> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }
    
    public SegGrupoSistema getSegGrupoSistema(java.math.BigDecimal id) {
        return getFacade().find(id);
    }
    
    public List<SegGrupoSistema> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }
    
    public List<SegGrupoSistema> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    
    @FacesConverter(forClass = SegGrupoSistema.class)
    public static class SegGrupoSistemaControllerConverter implements Converter {
        
        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SegGrupoSistemaController controller = (SegGrupoSistemaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "segGrupoSistemaController");
            return controller.getSegGrupoSistema(getKey(value));
        }
        
        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }
        
        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }
        
        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SegGrupoSistema) {
                SegGrupoSistema o = (SegGrupoSistema) object;
                return getStringKey(o.getGruId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SegGrupoSistema.class.getName()});
                return null;
            }
        }
        
    }
    
}
