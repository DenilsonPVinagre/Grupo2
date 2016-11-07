/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Denilson
 */

@Entity
public class TiposPagamento implements Serializable{
    
    @Id
    @GeneratedValue
    private Long idTiposPagamento;
    
    @Column (name = "descricao")
    private String descricao;
    
    public TiposPagamento()
    {
        
    }

    public Long getIdTiposPagamento() {
        return idTiposPagamento;
    }

    public void setIdTiposPagamento(Long idTiposPagamento) {
        this.idTiposPagamento = idTiposPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TiposPagamento{" + "idTiposPagamento=" + idTiposPagamento + ", descricao=" + descricao + '}';
    }

}