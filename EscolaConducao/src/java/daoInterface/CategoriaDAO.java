/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import Model.Categoria;
import java.util.List;

/**
 *
 * @author Denilson
 */
public interface CategoriaDAO {
    public void save(Categoria categoria);
    public void update(Categoria categoria);
    public void delete(Categoria categoria);
    public Categoria getCategoria (Long idCategoria);
    public Categoria getCategoriaByDescricao (String descricao);
    public List<Categoria> lista();
}
