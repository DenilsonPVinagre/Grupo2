
package converter;

import Model.Provincia;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Denilson
 */

@FacesConverter(forClass=Provincia.class)
public class provinciaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
       if (value != null && !value.isEmpty()){
           return (Provincia) uiComponent.getAttributes().get(value);
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Provincia) {
            Provincia entity= (Provincia) value;
            if (entity != null && entity instanceof Provincia && entity.getIdProvincia() != null) {
                uiComponent.getAttributes().put(entity.getIdProvincia().toString(), entity);
                return entity.getIdProvincia().toString();
        }
        }
    return "";
    }
}
