/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import Model.Provincia;
import java.util.List;

/**
 *
 * @author Denilson
 */
public interface ProvinciaDAO {
    public void save(Provincia provincia);
    public void update(Provincia provincia);
    public void delete(Provincia provincia);
    public Provincia getProvincia (Long idProvincia);
    public Provincia getProvinciaByDescricao (String descricao);
    public List<Provincia> lista();
}
