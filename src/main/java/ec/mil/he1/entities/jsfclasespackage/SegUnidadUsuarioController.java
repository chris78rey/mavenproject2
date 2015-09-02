package ec.mil.he1.entities.jsfclasespackage;

import ec.mil.he1.entidades.SegUnidadUsuario;
import ec.mil.he1.entities.jsfclasespackage.util.JsfUtil;
import ec.mil.he1.entities.jsfclasespackage.util.JsfUtil.PersistAction;
import ec.mil.he1.entities.sesionbeanpackage.SegUnidadUsuarioFacade;

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

@Named("segUnidadUsuarioController")
@SessionScoped
public class SegUnidadUsuarioController implements Serializable {

    @EJB
    private ec.mil.he1.entities.sesionbeanpackage.SegUnidadUsuarioFacade ejbFacade;
    private List<SegUnidadUsuario> items = null;
    private SegUnidadUsuario selected;

    public SegUnidadUsuarioController() {
    }

    public SegUnidadUsuario getSelected() {
        return selected;
    }

    public void setSelected(SegUnidadUsuario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SegUnidadUsuarioFacade getFacade() {
        return ejbFacade;
    }

    public SegUnidadUsuario prepareCreate() {
        selected = new SegUnidadUsuario();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SegUnidadUsuarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SegUnidadUsuarioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SegUnidadUsuarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SegUnidadUsuario> getItems() {
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

    public SegUnidadUsuario getSegUnidadUsuario(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<SegUnidadUsuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SegUnidadUsuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SegUnidadUsuario.class)
    public static class SegUnidadUsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SegUnidadUsuarioController controller = (SegUnidadUsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "segUnidadUsuarioController");
            return controller.getSegUnidadUsuario(getKey(value));
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
            if (object instanceof SegUnidadUsuario) {
                SegUnidadUsuario o = (SegUnidadUsuario) object;
                return getStringKey(o.getUusId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SegUnidadUsuario.class.getName()});
                return null;
            }
        }

    }

}
