package Controller;

import Model.Cargo;
import Model.Funcionarios;
import Model.Provincia;
import daoImplementacao.CargoDAOImp;
import java.util.List;
import daoInterface.FuncionariosDAO;
import daoImplementacao.FuncionariosDAOImp;
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
public class FuncionariosController {
    private Funcionarios funcionario = new Funcionarios();
    private DataModel listaFuncionarios;
    private List<Funcionarios> funcionarios;
    private List<Cargo> listaCargo;
    private List<Provincia> listaProvincias;
    
    public void setFuncionarios (List<Funcionarios>funcionarios){
        this.funcionarios = funcionarios;        
    }
    public List<Funcionarios> getFuncionarios (){
        return this.funcionarios;
    }
    
    public DataModel getListarFuncionarios(){
        List<Funcionarios> lista = new FuncionariosDAOImp().lista();
        listaFuncionarios = new ListDataModel(lista);
        return listaFuncionarios;
    }
    
    public Funcionarios getFuncionario(){
        return funcionario;
    }
    
    public void setFuncionario(Funcionarios funcionario){
        this.funcionario = funcionario;
    }
    
    public List<Cargo> getListaCargo() {
        return listaCargo;
    }

    public void setListaCargo(List<Cargo> listaCargo) {
        this.listaCargo = listaCargo;
    }
    
    public List<Provincia> getListaProvincias() {
        return listaProvincias;
    }

    public void setListaProvincias(List<Provincia> listaProvincias) {
        this.listaProvincias = listaProvincias;
    }
    
    public String prepararAdicionarFuncionarios(){
        funcionario = new Funcionarios();
        return "gerirFuncionarios?faces-redirect=true";
    }
    
    public String prepararAlterarFuncionarios(){
        funcionario = (Funcionarios)(listaFuncionarios.getRowData());
        return "gerirFuncionarios?faces-redirect=true";
    }
    
    public String excluirFuncionarios(){
        Funcionarios funcionariosTemp = (Funcionarios)(listaFuncionarios.getRowData());
        FuncionariosDAO dao = new FuncionariosDAOImp();
        dao.delete(funcionariosTemp);
        return "homeFuncionarios?faces-redirect=true";
    }
    
    public String alterarFuncionarios(){
        FuncionariosDAO dao = new FuncionariosDAOImp();
        dao.update(funcionario);
        return "homeFuncionarios?faces-redirect=true";
    }
    
    public String adicionar(){
        FuncionariosDAO dao = new FuncionariosDAOImp();
        dao.save(funcionario);
        return "homeFuncionarios?faces-redirect=true";
    }
    
    public String votarMenuPrincipal(){
        return "menuPrincipal?faces-redirect=true";
    }
    
    public void carregarc(){
        CargoDAOImp cargodaoimpl = new CargoDAOImp();
        listaCargo = cargodaoimpl.lista();
    } 
    
    public void carregarp(){
        ProvinciaDAOImp provincialdaoimpl = new ProvinciaDAOImp();
        listaProvincias = provincialdaoimpl.lista();
    } 
}