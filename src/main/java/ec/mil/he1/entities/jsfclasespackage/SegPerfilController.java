package ec.mil.he1.entities.jsfclasespackage;

import ec.mil.he1.entidades.SegPerfil;
import ec.mil.he1.entities.jsfclasespackage.util.JsfUtil;
import ec.mil.he1.entities.jsfclasespackage.util.JsfUtil.PersistAction;
import ec.mil.he1.entities.sesionbeanpackage.SegPerfilFacade;

import java.io.Serializable;
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

@Named("segPerfilController")
@SessionScoped
public class SegPerfilController implements Serializable {

    @EJB
    private ec.mil.he1.entities.sesionbeanpackage.SegPerfilFacade ejbFacade;
    private List<SegPerfil> items = null;
    private SegPerfil selected;

    public SegPerfilController() {
    }

    public SegPerfil getSelected() {
        return selected;
    }

    public void setSelected(SegPerfil selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SegPerfilFacade getFacade() {
        return ejbFacade;
    }

    public SegPerfil prepareCreate() {
        selected = new SegPerfil();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SegPerfilCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SegPerfilUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SegPerfilDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SegPerfil> getItems() {
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

    public SegPerfil getSegPerfil(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<SegPerfil> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SegPerfil> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SegPerfil.class)
    public static class SegPerfilControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SegPerfilController controller = (SegPerfilController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "segPerfilController");
            return controller.getSegPerfil(getKey(value));
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
            if (object instanceof SegPerfil) {
                SegPerfil o = (SegPerfil) object;
                return getStringKey(o.getPerId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SegPerfil.class.getName()});
                return null;
            }
        }

    }

}
