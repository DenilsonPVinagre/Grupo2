package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "login")
@NamedQueries({@NamedQuery(name="login.a", query = "SELECT login FROM Login login WHERE login.nome=:nome AND login.senha=:senha")})

public class Login implements Serializable{
    
    @Id
    @GeneratedValue
    private Long idLogin;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "senha")
    private String senha;
    
    @JoinColumn(name = "perfil_idPerfil", referencedColumnName = "idPerfil")
    @ManyToOne(fetch = FetchType.EAGER)
    private Perfil perfil;
    
    public Login(){}

    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Login{" + "idLogin=" + idLogin + ", nome=" + nome + ", senha=" + senha + ", perfil=" + perfil + '}';
    }
    
    
    
}
