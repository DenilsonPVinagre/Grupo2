/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TiposPagamento;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import daoInterface.TiposPagamentoDAO;
import daoImplementacao.TiposPagamentoDAOImp;
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
public class TiposPagamentoController {
    private TiposPagamento tiposPagamento;
    private DataModel listatiposPagamento;
    private List<TiposPagamento> idtiposPagamento;
    
    public void setIdTiposPagamento (List<TiposPagamento>tiposPagamento){
        this.idtiposPagamento = tiposPagamento;        
    }
    public List<TiposPagamento> getIdTiposPagamento (){
        return this.idtiposPagamento;
    }
    
//    public String getClasseEscolhida(){
//        return idalunos!=null && idalunos.getIdAlunos()!= null ? idalunos.toString():"Classe não escolhida";   // Não conseguimos perceber o que significa a classe escolhida nesta parte do código...
//    }
    
    public DataModel getListarTiposPagamento(){
        List<TiposPagamento> lista = new TiposPagamentoDAOImp().lista();
        listatiposPagamento = new ListDataModel(lista);
        return listatiposPagamento;
    }
    public TiposPagamento getidTiposPagamento(){
        return tiposPagamento;
    }
    
    public void setIdTiposPagamento(TiposPagamento tiposPagamento){
        this.tiposPagamento = tiposPagamento;
    }
    
    public String prepararAdicionarTiposPagamento(){
        tiposPagamento = new TiposPagamento();
        return "gerirTiposPagamento";
    }
    
    public String prepararAlterarTiposPagamento(){
        tiposPagamento = (TiposPagamento)(listatiposPagamento.getRowData());
        return "gerirTiposPagamento";
    }
    
    public String excluirTiposPagamento(){
        TiposPagamento tiposPagamentoTemp = (TiposPagamento)(listatiposPagamento.getRowData());
        TiposPagamentoDAO dao = new TiposPagamentoDAOImp();
        dao.delete(tiposPagamentoTemp);
        return "homeTiposPagamento";
    }
    
    public String alterarTiposPagamento(){
        TiposPagamentoDAO dao = new TiposPagamentoDAOImp();
        dao.update(tiposPagamento);
        return "homeTiposPagamento";
      
    }
    
    public String votarMenuPrincipal(){
        return "menuPrincipal";
    }
}

