/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cargo;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import daoInterface.CargoDAO;
import daoImplementacao.CargoDAOImp;
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
public class CargoController {
    private Cargo cargo = new Cargo();
    private DataModel listaCargo;
    private List<Cargo> idcargo;
    
    public void setIdCargo (List<Cargo>cargo){
        this.idcargo = cargo;        
    }
    public List<Cargo> getIdCargo (){
        return this.idcargo;
    }
    
//    public String getClasseEscolhida(){
//        return idalunos!=null && idalunos.getIdAlunos()!= null ? idalunos.toString():"Classe não escolhida";   // Não conseguimos perceber o que significa a classe escolhida nesta parte do código...
//    }
    
    public DataModel getListarCargo(){
        List<Cargo> lista = new CargoDAOImp().lista();
        listaCargo = new ListDataModel(lista);
        return listaCargo;
    }
    public Cargo getidCargo(){
        return cargo;
    }
    
    public void setIdCargo(Cargo cargo){
        this.cargo = cargo;
    }
    
    public String prepararAdicionarCargo(){
        cargo = new Cargo();
        return "gerirCargo?faces-redirect=true";
    }
    
    public String prepararAlterarCargo(){
        cargo = (Cargo)(listaCargo.getRowData());
        return "gerirCargo?faces-redirect=true";
    }
    
    public String excluirCargo(){
        Cargo cargoTemp = (Cargo)(listaCargo.getRowData());
        CargoDAO dao = new CargoDAOImp();
        dao.delete(cargoTemp);
        return "homeCargo?faces-redirect=true";
    }
    
    public String alterarCargo(){
        CargoDAO dao = new CargoDAOImp();
        dao.update(cargo);
        return "homeCargo?faces-redirect=true";
      
    }
    
    public String votarMenuPrincipal(){
        return "menuPrincipal?faces-redirect=true";
    }
}
