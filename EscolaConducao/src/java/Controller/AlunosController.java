package Controller;

import Model.Alunos;
import Model.Provincia;
import java.util.List;
import daoInterface.AlunosDAO;
import daoImplementacao.AlunosDAOImp;
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
public class AlunosController {
    private Alunos aluno = new Alunos();
    private DataModel listaAlunos;
    private List<Alunos> alunos;
    private List<Provincia> listaProvincias;
    
    public void setAlunos (List<Alunos> alunos){
        this.alunos = alunos;        
    }
    public List<Alunos> getAlunos(){
        return this.alunos;
    }
    
    public DataModel getListarAlunos(){
        List<Alunos> lista = new AlunosDAOImp().lista();
        listaAlunos = new ListDataModel(lista);
        return listaAlunos;
    }
    
    public Alunos getAluno(){
        return aluno;
    }
    
    public void setAluno(Alunos aluno){
        this.aluno = aluno;
    }

    public List<Provincia> getListaProvincias() {
        return listaProvincias;
    }

    public void setListaProvincias(List<Provincia> listaProvincias) {
        this.listaProvincias = listaProvincias;
    }
 
    public String prepararAdicionarAlunos(){
        aluno = new Alunos();
        return "gerirAlunos?faces-redirect=true";
    }
    
    public String prepararAlterarAlunos(){
        aluno = (Alunos)(listaAlunos.getRowData());
        return "gerirAlunos?faces-redirect=true";
    }
    
    public String excluirAlunos(){
        Alunos alunosTemp = (Alunos)(listaAlunos.getRowData());
        AlunosDAO dao = new AlunosDAOImp();
        dao.delete(alunosTemp);
        return "homeAlunos?faces-redirect=true";
    }
    
    public String alterarAlunos(){
        AlunosDAO dao = new AlunosDAOImp();
        dao.update(aluno);
        return "homeAlunos?faces-redirect=true";
    }
    
    public String adicionar(){
        AlunosDAO dao = new AlunosDAOImp();
        dao.save(aluno);
        return "homeAlunos?faces-redirect=true";
    }
    
    public String votarMenuPrincipal(){
        return "menuPrincipal?faces-redirect=true";
    }
    
    public void carregar(){
        ProvinciaDAOImp provincialdaoimpl = new ProvinciaDAOImp();
        listaProvincias = provincialdaoimpl.lista();
    }
}