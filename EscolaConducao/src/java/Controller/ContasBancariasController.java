/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ContasBancarias;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import daoInterface.ContasBancariasDAO;
import daoImplementacao.ContasBancariasDAOImp;
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
public class ContasBancariasController {
    private ContasBancarias contasBancarias;
    private DataModel listaContasBancarias;
    private List<ContasBancarias> idcontasBancarias;
    
    public void setIdContasBancarias (List<ContasBancarias>contasBancarias){
        this.idcontasBancarias = contasBancarias;        
    }
    public List<ContasBancarias> getIdContasBancarias (){
        return this.idcontasBancarias;
    }
    
//    public String getClasseEscolhida(){
//        return idalunos!=null && idalunos.getIdAlunos()!= null ? idalunos.toString():"Classe não escolhida";   // Não conseguimos perceber o que significa a classe escolhida nesta parte do código...
//    }
    
    public DataModel getListarContasBancarias(){
        List<ContasBancarias> lista = new ContasBancariasDAOImp().lista();
        listaContasBancarias = new ListDataModel(lista);
        return listaContasBancarias;
    }
    public ContasBancarias getidContasBancarias(){
        return contasBancarias;
    }
    
    public void setIdContasBancarias(ContasBancarias contasBancarias){
        this.contasBancarias = contasBancarias;
    }
    
    public String prepararAdicionarContasBancarias(){
        contasBancarias = new ContasBancarias();
        return "gerirContasBancarias";
    }
    
    public String prepararAlterarContasBancarias(){
        contasBancarias = (ContasBancarias)(listaContasBancarias.getRowData());
        return "gerirContasBancarias";
    }
    
    public String excluirContasBancarias(){
        ContasBancarias contasBancariasTemp = (ContasBancarias)(listaContasBancarias.getRowData());
        ContasBancariasDAO dao = new ContasBancariasDAOImp();
        dao.delete(contasBancariasTemp);
        return "homeContasBancarias";
    }
    
    public String alterarContasBancarias(){
        ContasBancariasDAO dao = new ContasBancariasDAOImp();
        dao.update(contasBancarias);
        return "homeContasBancarias";
      
    }
    
    public String votarMenuPrincipal(){
        return "menuPrincipal";
    }
}
