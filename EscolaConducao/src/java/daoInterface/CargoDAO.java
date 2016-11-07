/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import Model.Cargo;
import java.util.List;

/**
 *
 * @author Denilson
 */
public interface CargoDAO {
    public void save(Cargo cargo);
    public void update(Cargo cargo);
    public void delete(Cargo cargo);
    public Cargo getCargo (Long idCargo);
    public Cargo getCargoByDescricao (String descricao);
    public List<Cargo> lista();
}