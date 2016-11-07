package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anderson
 */

@Entity
public class Horarios implements Serializable{
    
    @Id
    @GeneratedValue
    private int idHorarios ;
    
    @Column (name = "descricao")
    private String descricao;

	public Horarios ()
	{
		
	}

    public int getIdHorarios() {
        return idHorarios;
    }

    public void setIdHorarios(int idHorarios) {
        this.idHorarios = idHorarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Horarios{" + "idHorarios=" + idHorarios + ", descricao=" + descricao + '}';
    }
    
}
