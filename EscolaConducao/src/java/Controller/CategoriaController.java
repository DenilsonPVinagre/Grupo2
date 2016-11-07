/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Categoria;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import daoInterface.CategoriaDAO;
import daoImplementacao.CategoriaDAOImp;
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
public class CategoriaController {
    private Categoria categoria;
    private DataModel listacategoria;
    private List<Categoria> idcategoria;
    
    public void setIdCategoria (List<Categoria>categoria){
        this.idcategoria = categoria;        
    }
    public List<Categoria> getIdCategoria (){
        return this.idcategoria;
    }
    
    public DataModel getListarCategoria(){
        List<Categoria> lista = new CategoriaDAOImp().lista();
        listacategoria = new ListDataModel(lista);
        return listacategoria;
    }
    public Categoria getidCategoria(){
        return categoria;
    }
    
    public void setIdCursos(Categoria categoria){
        this.categoria = categoria;
    }
    
    public String prepararAdicionarCategoria(){
        categoria = new Categoria();
        return "gerirCategoria";
    }
    
    public String prepararAlterarCategoria(){
        categoria = (Categoria)(listacategoria.getRowData());
        return "gerirCategoria";
    }
    
    public String excluirCategoria(){
        Categoria categoriaTemp = (Categoria)(listacategoria.getRowData());
        CategoriaDAO dao = new CategoriaDAOImp();
        dao.delete(categoriaTemp);
        return "homeCategoria";
    }
    
    public String alterarCategoria(){
        CategoriaDAO dao = new CategoriaDAOImp();
        dao.update(categoria);
        return "homeCategoria";
      
    }
    
    public String votarMenuPrincipal(){
        return "menuPrincipal";
    }
}


