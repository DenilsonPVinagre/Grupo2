/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Provincia;
import java.util.List;
import daoInterface.ProvinciaDAO;
import daoImplementacao.ProvinciaDAOImp;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author Denilson
 */

@ManagedBean
@SessionScoped
public class ProvinciaController {
    private Provincia provincia;
    private DataModel listaProvincia;
    private List<Provincia> idprovincia;
    
    public void setIdProvincia (List<Provincia>provincia){
        this.idprovincia = provincia;        
    }
    public List<Provincia> getIdProvincia (){
        return this.idprovincia;
    }
    
    public DataModel getListarProvincia(){
        List<Provincia> lista = new ProvinciaDAOImp().lista();
        listaProvincia = new ListDataModel(lista);
        return listaProvincia;
    }
    public Provincia getidProvincia(){
        return provincia;
    }
    
    public void setIdProvincia(Provincia provincia){
        this.provincia = provincia;
    }
    
    public String prepararAdicionarProvincia(){
        provincia = new Provincia();
        return "gerirProvincia";
    }
    
    public String prepararAlterarProvincia(){
        provincia = (Provincia)(listaProvincia.getRowData());
        return "gerirProvincia";
    }
    
    public String excluirProvincia(){
        Provincia provinciaTemp = (Provincia)(listaProvincia.getRowData());
        ProvinciaDAO dao = new ProvinciaDAOImp();
        dao.delete(provinciaTemp);
        return "homeProvincia";
    }
    
    public String alterarProvincia(){
        ProvinciaDAO dao = new ProvinciaDAOImp();
        dao.update(provincia);
        return "homeProvincia";
      
    }
    
    public String votarMenuPrincipal(){
        return "menuPrincipal";
    }
}
