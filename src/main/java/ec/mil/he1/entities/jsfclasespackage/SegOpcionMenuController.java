package ec.mil.he1.entities.jsfclasespackage;

import ec.mil.he1.entidades.SegOpcionMenu;
import ec.mil.he1.entities.jsfclasespackage.util.JsfUtil;
import ec.mil.he1.entities.jsfclasespackage.util.JsfUtil.PersistAction;
import ec.mil.he1.entities.sesionbeanpackage.SegOpcionMenuFacade;

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

@Named("segOpcionMenuController")
@SessionScoped
public class SegOpcionMenuController implements Serializable {

    @EJB
    private ec.mil.he1.entities.sesionbeanpackage.SegOpcionMenuFacade ejbFacade;
    private List<SegOpcionMenu> items = null;
    private SegOpcionMenu selected;

    public SegOpcionMenuController() {
    }

    public SegOpcionMenu getSelected() {
        return selected;
    }

    public void setSelected(SegOpcionMenu selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SegOpcionMenuFacade getFacade() {
        return ejbFacade;
    }

    public SegOpcionMenu prepareCreate() {
        selected = new SegOpcionMenu();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SegOpcionMenuCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SegOpcionMenuUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SegOpcionMenuDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SegOpcionMenu> getItems() {
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

    public SegOpcionMenu getSegOpcionMenu(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<SegOpcionMenu> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SegOpcionMenu> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SegOpcionMenu.class)
    public static class SegOpcionMenuControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SegOpcionMenuController controller = (SegOpcionMenuController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "segOpcionMenuController");
            return controller.getSegOpcionMenu(getKey(value));
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
            if (object instanceof SegOpcionMenu) {
                SegOpcionMenu o = (SegOpcionMenu) object;
                return getStringKey(o.getOpcId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SegOpcionMenu.class.getName()});
                return null;
            }
        }

    }

}
