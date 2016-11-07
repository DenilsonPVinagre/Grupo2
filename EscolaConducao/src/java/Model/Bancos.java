package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anderson
 */

@Entity
public class Bancos implements Serializable{
    
    @Id
    @GeneratedValue
    private Long idBancos;
    
    @Column (name = "descricao")
    private String descricao;
    
        public Bancos()
        {
        
        }

    public Long getIdBancos() {
        return idBancos;
    }

    public void setIdBancos(Long idBancos) {
        this.idBancos = idBancos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Bancos{" + "idBancos=" + idBancos + ", descricao=" + descricao + '}';
    }

}
