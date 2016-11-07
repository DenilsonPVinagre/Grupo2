package Controller;

import Model.Login;
import Model.Perfil;
import Utils.Criptografia;
import daoImplementacao.LoginDAOImp;
import daoImplementacao.PerfilDAOImp;
import daoInterface.LoginDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Denilson
 */

@ManagedBean
@SessionScoped
public class LoginController {
    private Login login = new Login();
    private DataModel listalogins;
    private List<Login> logins;
    private List<Perfil> listaPerfil;
    private Criptografia criptografia = new Criptografia();

    public Login getLogin() {
        if(login == null){
        login = new Login();
        
        }
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public List<Login> getLogins() {
        return logins;
    }

    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }

    
    public DataModel getListalogins(){
        List<Login> lista = new LoginDAOImp().lista();
        listalogins = new ListDataModel(lista);
        return listalogins;
    }

    public List<Perfil> getListaPerfil() {
        return listaPerfil;
    }

    public void setListaPerfil(List<Perfil> listaPerfil) {
        this.listaPerfil = listaPerfil;
    }

    public String prepararAdicionarLogin(){
        login = new Login();
        return "gerirLogin?faces-redirect=true";
    }
    
    public String prepararAlterarLogin(){
        login = (Login)(listalogins.getRowData());
        return "gerirUtilizadores?faces-redirect=true";
    }
    
    public String excluirLogin(){
        Login loginTemp = (Login)(listalogins.getRowData());
        LoginDAO dao = new LoginDAOImp();
        dao.delete(loginTemp);
        return "homeUtilizadores?faces-redirect=true";
    }
    
    public String alterarLogin(){
        LoginDAO dao = new LoginDAOImp();
        dao.update(login);
        return "homeUtilizadores?faces-redirect=true";
      
    }
    
    public String adicionar(){
        LoginDAO dao = new LoginDAOImp();
        dao.save(login);
        return "homeUtilizadores?faces-redirect=true";
    }
    
    public String adicionarc(){
        LoginDAO dao = new LoginDAOImp();
        login.setSenha(criptografia.Cifrar(login.getSenha()));
        dao.save(login);
        

        return "homeUtilizadores?faces-redirect=true";
    }
    
    public String acessar(){
        LoginDAO logindao = new LoginDAOImp();
        login=logindao.acessar(login.getNome(), login.getSenha());
        
//        if(login.getNome().equals("") && login.getSenha().equals("")){
//            JOptionPane.showMessageDialog(null, "Utilizador ou Palavra Passe Errada");
//        return null;
//        }else{
        
        return "menuPrincipal.xhtml?faces-redirect=true";
//        }
    }
    
    
    public String acessarc(){
        LoginDAO logindao = new LoginDAOImp();
        
        login=logindao.acessar(login.getNome(), criptografia.Cifrar(login.getSenha()));
        
        
//        if(login.getNome().equals("") && login.getSenha().equals("")){
//            JOptionPane.showMessageDialog(null, "Utilizador ou Palavra Passe Errada");
//        return null;
//        }else{
        
        return "menuPrincipal.xhtml?faces-redirect=true";
//        }
    }
    
    
    public String sair(){
        login = null;
        login = new Login();
        return "login.xhtml?faces-redirect=true";
    }
    
    public String votarMenuPrincipal(){
        return "menuPrincipal?faces-redirect=true";
    }
    
    public void carregar(){
        PerfilDAOImp perfildaoimpl = new PerfilDAOImp();
        listaPerfil = perfildaoimpl.lista();
    }
}
