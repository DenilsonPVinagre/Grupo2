package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anderson
 */

@Entity
public class Pagamentos {
    
    @Id
    @GeneratedValue
    private Long idPagamentos;
    
    @Column(name = "descricao")
    private String descricao;
    
    @JoinColumn (name = "idContasBancarias", referencedColumnName = "idContasBancarias")
    @ManyToOne (fetch = FetchType.EAGER)
    private ContasBancarias contasBancarias;
    
    @JoinColumn (name = "idAlunos", referencedColumnName = "idAlunos")
    @ManyToOne (fetch = FetchType.EAGER)
    private Alunos alunos;
    
    @JoinColumn (name = "idTiposPagamento", referencedColumnName = "idTiposPagamento")
    @ManyToOne (fetch = FetchType.EAGER)
    private TiposPagamento tiposPagamento;
    
    public Pagamentos()
    {
        
    }

    public Long getIdPagamentos() {
        return idPagamentos;
    }

    public void setIdPagamentos(Long idPagamentos) {
        this.idPagamentos = idPagamentos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ContasBancarias getContasBancarias() {
        return contasBancarias;
    }

    public void setContasBancarias(ContasBancarias contasBancarias) {
        this.contasBancarias = contasBancarias;
    }

    public Alunos getAlunos() {
        return alunos;
    }

    public void setAlunos(Alunos alunos) {
        this.alunos = alunos;
    }

    public TiposPagamento getTiposPagamento() {
        return tiposPagamento;
    }

    public void setTiposPagamento(TiposPagamento tiposPagamento) {
        this.tiposPagamento = tiposPagamento;
    }

    @Override
    public String toString() {
        return "Pagamentos{" + "idPagamentos=" + idPagamentos + ", descricao=" + descricao + ", contasBancarias=" + contasBancarias + ", alunos=" + alunos + ", tiposPagamento=" + tiposPagamento + '}';
    }

       
}
