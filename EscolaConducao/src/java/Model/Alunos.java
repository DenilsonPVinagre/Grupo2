package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Alunos implements Serializable{
    
    @Id
    @GeneratedValue
    private Long idAlunos;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "numeroBi")
    private String numeroBi;
    
    @Column(name = "datanascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datanascimento;
    
    @JoinColumn(name = "provincia_idProvincia", referencedColumnName = "idProvincia")
    @ManyToOne(fetch = FetchType.EAGER)
    private Provincia provincia;
    
    public Alunos(){
    
}

    public Long getIdAlunos() {
        return idAlunos;
    }

    public void setIdAlunos(Long idAlunos) {
        this.idAlunos = idAlunos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroBi() {
        return numeroBi;
    }

    public void setNumeroBi(String numeroBi) {
        this.numeroBi = numeroBi;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Alunos{" + "idAlunos=" + idAlunos + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", numeroBi=" + numeroBi + ", datanascimento=" + datanascimento + ", provincia=" + provincia + '}';
    }
    
        
    
}
