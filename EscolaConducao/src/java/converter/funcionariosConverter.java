
package converter;

import Model.Funcionarios;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Denilson
 */

@FacesConverter(forClass=Funcionarios.class)
public class funcionariosConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
       if (value != null && !value.isEmpty()){
           return (Funcionarios) uiComponent.getAttributes().get(value);
       }
       return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Funcionarios) {
            Funcionarios entity= (Funcionarios) value;
            if (entity != null && entity instanceof Funcionarios && entity.getIdFuncionarios() != null) {
                uiComponent.getAttributes().put(entity.getIdFuncionarios().toString(), entity);
                return entity.getIdFuncionarios().toString();
        }
        }
    return "";
    }
}
