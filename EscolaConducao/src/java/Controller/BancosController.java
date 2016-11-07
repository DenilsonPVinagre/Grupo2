/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bancos;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import daoInterface.BancosDAO;
import daoImplementacao.BancosDAOImp;
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
public class BancosController {
    private Bancos bancos;
    private DataModel listaBancos;
    private List<Bancos> idbancos;
    
    public void setIdBancos (List<Bancos>bancos){
        this.idbancos = bancos;        
    }
    public List<Bancos> getIdBancos (){
        return this.idbancos;
    }
    
//    public String getClasseEscolhida(){
//        return idalunos!=null && idalunos.getIdAlunos()!= null ? idalunos.toString():"Classe não escolhida";   // Não conseguimos perceber o que significa a classe escolhida nesta parte do código...
//    }
    
    public DataModel getListarBancos(){
        List<Bancos> lista = new BancosDAOImp().lista();
        listaBancos = new ListDataModel(lista);
        return listaBancos;
    }
    public Bancos getidBancos(){
        return bancos;
    }
    
    public void setIdBancos(Bancos bancos){
        this.bancos = bancos;
    }
    
    public String prepararAdicionarBancos(){
        bancos = new Bancos();
        return "gerirBancos";
    }
    
    public String prepararAlterarBancos(){
        bancos = (Bancos)(listaBancos.getRowData());
        return "gerirBancos";
    }
    
    public String excluirBancos(){
        Bancos bancosTemp = (Bancos)(listaBancos.getRowData());
        BancosDAO dao = new BancosDAOImp();
        dao.delete(bancosTemp);
        return "homeBancos";
    }
    
    public String alterarBancos(){
        BancosDAO dao = new BancosDAOImp();
        dao.update(bancos);
        return "homeBancos";
      
    }
    
    public String votarMenuPrincipal(){
        return "menuPrincipal";
    }
}
