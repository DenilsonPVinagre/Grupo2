/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Horarios;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import daoInterface.HorariosDAO;
import daoImplementacao.HorariosDAOImp;
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
public class HorariosController {
    private Horarios horarios;
    private DataModel listahorarios;
    private List<Horarios> idhorarios;
    
    public void setIdHorarios (List<Horarios>horarios){
        this.idhorarios = horarios;        
    }
    public List<Horarios> getIdHorarios (){
        return this.idhorarios;
    }
    
//    public String getClasseEscolhida(){
//        return idalunos!=null && idalunos.getIdAlunos()!= null ? idalunos.toString():"Classe não escolhida";   // Não conseguimos perceber o que significa a classe escolhida nesta parte do código...
//    }
    
    public DataModel getListarHorarios(){
        List<Horarios> lista = new HorariosDAOImp().lista();
        listahorarios = new ListDataModel(lista);
        return listahorarios;
    }
    public Horarios getidHorarios(){
        return horarios;
    }
    
    public void setIdHorarios(Horarios horarios){
        this.horarios = horarios;
    }
    
    public String prepararAdicionarHorarios(){
        horarios = new Horarios();
        return "gerirHorarios";
    }
    
    public String prepararAlterarHorarios(){
        horarios = (Horarios)(listahorarios.getRowData());
        return "gerirHorarios";
    }
    
    public String excluirHorarios(){
        Horarios horariosTemp = (Horarios)(listahorarios.getRowData());
        HorariosDAO dao = new HorariosDAOImp();
        dao.delete(horariosTemp);
        return "homeHorarios";
    }
    
    public String alterarHorarios(){
        HorariosDAO dao = new HorariosDAOImp();
        dao.update(horarios);
        return "homeHorarios";
      
    }
    
    public String votarMenuPrincipal(){
        return "menuPrincipal";
    }
}


