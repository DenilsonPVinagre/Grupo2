/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Matriculas;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import daoInterface.MatriculasDAO;
import daoImplementacao.MatriculasDAOImp;
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
public class MatriculasController {
    private Matriculas matriculas;
    private DataModel listamatriculas;
    private List<Matriculas> idmatriculas;
    
    public void setIdMatriculas (List<Matriculas>matriculas){
        this.idmatriculas = matriculas;        
    }
    public List<Matriculas> getIdMatriculas (){
        return this.idmatriculas;
    }
    
//    public String getClasseEscolhida(){
//        return idalunos!=null && idalunos.getIdAlunos()!= null ? idalunos.toString():"Classe não escolhida";   // Não conseguimos perceber o que significa a classe escolhida nesta parte do código...
//    }
    
    public DataModel getListarMatriculas(){
        List<Matriculas> lista = new MatriculasDAOImp().lista();
        listamatriculas = new ListDataModel(lista);
        return listamatriculas;
    }
    public Matriculas getidMatriculas(){
        return matriculas;
    }
    
    public void setIdMatriculas(Matriculas matriculas){
        this.matriculas = matriculas;
    }
    
    public String prepararAdicionarMatriculas(){
        matriculas = new Matriculas();
        return "gerirMatriculas";
    }
    
    public String prepararAlterarMatriculas(){
        matriculas = (Matriculas)(listamatriculas.getRowData());
        return "gerirMatriculas";
    }
    
    public String excluirMatriculas(){
        Matriculas matriculasTemp = (Matriculas)(listamatriculas.getRowData());
        MatriculasDAO dao = new MatriculasDAOImp();
        dao.delete(matriculasTemp);
        return "homeMatriculas";
    }
    
    public String alterarMatriculas(){
        MatriculasDAO dao = new MatriculasDAOImp();
        dao.update(matriculas);
        return "homeMatriculas";
      
    }
    
    public String votarMenuPrincipal(){
        return "menuPrincipal";
    }
}


