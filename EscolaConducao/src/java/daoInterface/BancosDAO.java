/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterface;

import Model.Bancos;
import java.util.List;

/**
 *
 * @author Denilson
 */
public interface BancosDAO {
    public void save(Bancos bancos);
    public void update(Bancos bancos);
    public void delete(Bancos bancos);
    public Bancos getBancos (Long idBancos);
    public Bancos getBancosByDescricao (String descricao);
    public List<Bancos> lista();
}