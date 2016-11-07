package Model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anderson
 */
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
public class Matriculas implements Serializable{
    
    @Id
    @GeneratedValue
    private Long idMatriculas;
    
    @Column (name = "data_matricula")
    @Temporal (javax.persistence.TemporalType.DATE)
    private Date data_matricula;
    
    @Column (name = "numeroMatricula")
    private int numeroMatricula;
    
    @JoinColumn (name = "idFuncionarios", referencedColumnName = "idFuncionarios")
    @ManyToOne (fetch = FetchType.EAGER)
    private Funcionarios funcionarios;
    
    @JoinColumn (name = "idAlunos", referencedColumnName = "idAlunos")
    @ManyToOne (fetch = FetchType.EAGER)
    private Alunos alunos;
    
    @JoinColumn (name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne (fetch = FetchType.EAGER)
    private Categoria categoria;
    
    @JoinColumn (name = "idPagamentos", referencedColumnName = "idPagamentos")
    @ManyToOne (fetch = FetchType.EAGER)
    private Pagamentos pagamentos;
    
    @JoinColumn (name = "idHorarios", referencedColumnName = "idHorarios")
    @ManyToOne (fetch = FetchType.EAGER)
    private Horarios horarios;
    
    public Matriculas()
    {
        
    }

    public Long getIdMatriculas() {
        return idMatriculas;
    }

    public void setIdMatriculas(Long idMatriculas) {
        this.idMatriculas = idMatriculas;
    }

    public Date getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(Date data_matricula) {
        this.data_matricula = data_matricula;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Alunos getAlunos() {
        return alunos;
    }

    public void setAlunos(Alunos alunos) {
        this.alunos = alunos;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Pagamentos getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Pagamentos pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Horarios getHorarios() {
        return horarios;
    }

    public void setHorarios(Horarios horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        return "Matriculas{" + "idMatriculas=" + idMatriculas + ", data_matricula=" + data_matricula + ", numeroMatricula=" + numeroMatricula + ", funcionarios=" + funcionarios + ", alunos=" + alunos + ", categoria=" + categoria + ", pagamentos=" + pagamentos + ", horarios=" + horarios + '}';
    }
    
    
}
