
package converter;

import Model.Cargo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Denilson
 */

@FacesConverter(forClass=Cargo.class)
public class cargoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
       if (value != null && !value.isEmpty()){
           return (Cargo) uiComponent.getAttributes().get(value);
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Cargo) {
            Cargo entity= (Cargo) value;
            if (entity != null && entity instanceof Cargo && entity.getIdCargo() != null) {
                uiComponent.getAttributes().put(entity.getIdCargo().toString(), entity);
                return entity.getIdCargo().toString();
        }
        }
    return "";
    }
}
