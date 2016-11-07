/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pagamentos;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import daoInterface.PagamentosDAO;
import daoImplementacao.PagamentosDAOImp;
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
public class PagamentosController {
    private Pagamentos pagamentos;
    private DataModel listapagamentos;
    private List<Pagamentos> idpagamentos;
    
    public void setIdPagamentos (List<Pagamentos>pagamentos){
        this.idpagamentos = pagamentos;        
    }
    public List<Pagamentos> getIdPagamentos (){
        return this.idpagamentos;
    }
    
//    public String getClasseEscolhida(){
//        return idalunos!=null && idalunos.getIdAlunos()!= null ? idalunos.toString():"Classe não escolhida";   // Não conseguimos perceber o que significa a classe escolhida nesta parte do código...
//    }
    
    public DataModel getListarPagamentos(){
        List<Pagamentos> lista = new PagamentosDAOImp().lista();
        listapagamentos = new ListDataModel(lista);
        return listapagamentos;
    }
    public Pagamentos getidPagamentos(){
        return pagamentos;
    }
    
    public void setIdPagamentos(Pagamentos pagamentos){
        this.pagamentos = pagamentos;
    }
    
    public String prepararAdicionarPagamentos(){
        pagamentos = new Pagamentos();
        return "gerirPagamentos";
    }
    
    public String prepararAlterarPagamentos(){
        pagamentos = (Pagamentos)(listapagamentos.getRowData());
        return "gerirPagamentos";
    }
    
    public String excluirPagamentos(){
        Pagamentos pagamentosTemp = (Pagamentos)(listapagamentos.getRowData());
        PagamentosDAO dao = new PagamentosDAOImp();
        dao.delete(pagamentosTemp);
        return "homePagamentos";
    }
    
    public String alterarPagamentos(){
        PagamentosDAO dao = new PagamentosDAOImp();
        dao.update(pagamentos);
        return "homePagamentos";
      
    }
    
    public String votarMenuPrincipal(){
        return "menuPrincipal";
    }
}


