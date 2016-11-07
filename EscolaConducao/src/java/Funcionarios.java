

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "funcionarios")
public class Funcionarios implements Serializable {
    
    @Id
    @GeneratedValue
    private Long idFuncionarios;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "datanascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    
    @Column(name = "numeroBi")
    private String numeroBi;
    
    @JoinColumn (name = "cargo_idCargo", referencedColumnName = "idCargo")
    @ManyToOne (fetch = FetchType.EAGER)
    private Cargo cargo;
    
    @JoinColumn(name = "provincia_idProvincia", referencedColumnName = "idProvincia")
    @ManyToOne(fetch = FetchType.EAGER)
    private Provincia provincia;
    
    public Funcionarios(){
    
}

    public Long getIdFuncionarios() {
        return idFuncionarios;
    }

    public void setIdFuncionarios(Long idFuncionarios) {
        this.idFuncionarios = idFuncionarios;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroBi() {
        return numeroBi;
    }

    public void setNumeroBi(String numeroBi) {
        this.numeroBi = numeroBi;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Funcionarios{" + "idFuncionarios=" + idFuncionarios + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", dataNascimento=" + dataNascimento + ", numeroBi=" + numeroBi + ", cargo=" + cargo + ", provincia=" + provincia + '}';
    }
    
    
}