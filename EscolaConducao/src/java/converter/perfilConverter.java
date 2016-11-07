
package converter;

import Model.Perfil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Denilson
 */

@FacesConverter(forClass=Perfil.class)
public class perfilConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
       if (value != null && !value.isEmpty()){
           return (Perfil) uiComponent.getAttributes().get(value);
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Perfil) {
            Perfil entity= (Perfil) value;
            if (entity != null && entity instanceof Perfil && entity.getIdPerfil() != null) {
                uiComponent.getAttributes().put(entity.getIdPerfil().toString(), entity);
                return entity.getIdPerfil().toString();
        }
        }
    return "";
    }
}
