package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue
     private Long idCategoria;
    
    @Column (name = "descricao")
     private String descricao;
    
    @Column (name = "preco")
     private float preco;
    
    

	public Categoria()
	{
		
	}

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Categoria{" + "idCategoria=" + idCategoria + ", descricao=" + descricao + ", preco=" + preco + '}';
    }
    
}
