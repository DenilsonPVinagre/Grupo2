/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Denilson
 */

@Entity
public class ContasBancarias implements Serializable{
    
    @Id
    @GeneratedValue
    private Long idContasBancarias;
    
    @Column(name = "descricao")
    private String descricao;
    
//    @JoinColumn(name = "idBancos", referencedColumnName = "idBancos")
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Bancos bancos;
    
    public ContasBancarias(){
        
    }

    public Long getIdContasBancarias() {
        return idContasBancarias;
    }

    public void setIdContasBancarias(Long idContasBancarias) {
        this.idContasBancarias = idContasBancarias;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

//    public Bancos getBancos() {
//        return bancos;
//    }
//
//    public void setBancos(Bancos bancos) {
//        this.bancos = bancos;
//    }

    @Override
    public String toString() {
        return "ContasBancarias{" + "idContasBancarias=" + idContasBancarias + ", descricao=" + descricao + '}';
    }

   

}
